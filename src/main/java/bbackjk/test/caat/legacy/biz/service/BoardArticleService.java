package bbackjk.test.caat.legacy.biz.service;

import bbackjk.test.caat.legacy.biz.dto.BoardArticleDto;

public interface BoardArticleService {


    /**
     * 게시글 정보 가져오기
     */
    BoardArticleDto getById(long id);

    /**
     * 게시글 조회 (조회수 증가)
     */
    BoardArticleDto readById(long id);

    void register(BoardArticleDto registerModel);

    void modify(BoardArticleDto modifyModel);
}

