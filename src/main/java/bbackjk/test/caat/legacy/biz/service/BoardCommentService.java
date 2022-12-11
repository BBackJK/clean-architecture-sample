package bbackjk.test.caat.legacy.biz.service;

import bbackjk.test.caat.legacy.biz.dto.BoardCommentDto;

public interface BoardCommentService {

    void register(BoardCommentDto registerModel);
    void modify(BoardCommentDto modifyModel);
    void remove(BoardCommentDto removeModel);
}
