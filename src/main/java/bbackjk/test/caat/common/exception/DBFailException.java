package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class DBFailException extends CommonException {

    public DBFailException() {
        super(ErrorCode.DB_FAIL);
    }
}
