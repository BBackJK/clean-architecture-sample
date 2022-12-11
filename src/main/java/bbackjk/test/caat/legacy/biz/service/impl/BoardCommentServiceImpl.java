package bbackjk.test.caat.legacy.biz.service.impl;

import bbackjk.test.caat.common.exception.DBFailException;
import bbackjk.test.caat.common.exception.DomainNotFoundException;
import bbackjk.test.caat.common.exception.UpdateNoPermissionException;
import bbackjk.test.caat.legacy.biz.dao.LegacyBoardCommentDao;
import bbackjk.test.caat.legacy.biz.dao.LegacyBoardArticleDao;
import bbackjk.test.caat.legacy.biz.dto.BoardCommentDto;
import bbackjk.test.caat.legacy.biz.service.BoardCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements BoardCommentService {

    private final LegacyBoardCommentDao boardCommentDao;
    private final LegacyBoardArticleDao boardArticleDao;

    @Override
    public void register(BoardCommentDto registerModel) {

        // 게시글 유효성 검증
        boardArticleDao.findById(registerModel.getBoardArticleId()).orElseThrow(DomainNotFoundException::new);

        // TODO: 회원 유효성 검증 PASS

        // 댓글 작성
        int affected = boardCommentDao.insert(registerModel);
        if (affected < 1) {
            throw new DBFailException();
        }
    }

    @Override
    public void modify(BoardCommentDto modifyModel) {

        final var selected = boardCommentDao.findById(modifyModel.getId()).orElseThrow(DomainNotFoundException::new);

        if (selected.isNotSameUser(modifyModel.getUserId())) {
            throw new UpdateNoPermissionException();
        }

        int affected = boardCommentDao.update(modifyModel);
        if (affected < 1) {
            throw new DBFailException();
        }
    }

    @Override
    public void remove(BoardCommentDto removeModel) {

        final var selected = boardCommentDao.findById(removeModel.getId()).orElseThrow(DomainNotFoundException::new);

        if (selected.isNotSameUser(removeModel.getUserId())) {
            throw new UpdateNoPermissionException();
        }

        int affected = boardCommentDao.deleteById(selected.getId());
        if (affected < 1) {
            throw new DBFailException();
        }
    }
}

