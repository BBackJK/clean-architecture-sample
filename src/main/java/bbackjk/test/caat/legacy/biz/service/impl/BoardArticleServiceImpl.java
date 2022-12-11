package bbackjk.test.caat.legacy.biz.service.impl;

import bbackjk.test.caat.legacy.biz.dao.LegacyBoardCommentDao;
import bbackjk.test.caat.legacy.biz.dao.LegacyBoardDao;
import bbackjk.test.caat.legacy.biz.dao.LegacyBoardArticleDao;
import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;
import bbackjk.test.caat.legacy.biz.service.BoardArticleService;
import bbackjk.test.caat.common.exception.BoardNotFoundException;
import bbackjk.test.caat.common.exception.DBFailException;
import bbackjk.test.caat.common.exception.DomainNotFoundException;
import bbackjk.test.caat.common.exception.UpdateNoPermissionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardArticleServiceImpl implements BoardArticleService {

    private final LegacyBoardArticleDao boardArticleDao;
    private final LegacyBoardDao boardDao;
    private final LegacyBoardCommentDao boardCommentDao;

    @Override
    public BoardArticleDto getById(long id) {
        return boardArticleDao.findById(id).orElseThrow(DomainNotFoundException::new);
    }

    @Override
    public BoardArticleDto readById(long id) {

        // 조회
        final var selected = boardArticleDao.findById(id).orElseThrow(DomainNotFoundException::new);

        // 조회수 증가
        boardArticleDao.increaseViewCount(id);

        // 게시글 댓글
        selected.setCommentList(boardCommentDao.findAllByBoardArticleId(selected.getId()));

        return selected;
    }

    @Override
    public void register(BoardArticleDto registerModel) {

        boardDao.findById(registerModel.getBoardId())
                .orElseThrow(BoardNotFoundException::new);

        // TODO: 회원 유효성 조회

        // 등록
        int affected = boardArticleDao.insert(registerModel);

        // 등록 실패 시 에러처리
        if (affected < 1) {
            throw new DBFailException();
        }
    }

    @Override
    public void modify(BoardArticleDto modifyModel) {

        // 수정할 데이터 조회
        final var selected = boardArticleDao.findById(modifyModel.getId())
                .orElseThrow(DomainNotFoundException::new);

        // 수정할 데이터의 userId와 로그인한사람의 userId 다를 시 Fail
        if (selected.isNotSameUser(modifyModel.getUserId())) {
            throw new UpdateNoPermissionException();
        }

        // 수정
        int affected = boardArticleDao.update(modifyModel);

        // 수정 실패시 throw
        if (affected < 1) {
            throw new DBFailException();
        }
    }
}

