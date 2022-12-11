package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class BoardNotFoundException extends CommonException {

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
