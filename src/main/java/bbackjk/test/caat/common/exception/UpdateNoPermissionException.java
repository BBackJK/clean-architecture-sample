package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class UpdateNoPermissionException extends CommonException {

    public UpdateNoPermissionException() {
        super(ErrorCode.UPDATE_NO_PERMISSION);
    }
}
