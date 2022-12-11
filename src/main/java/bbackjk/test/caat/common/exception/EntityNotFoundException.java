package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class EntityNotFoundException extends CommonException {

    public EntityNotFoundException() {
        super(ErrorCode.DOMAIN_NOT_FOUND);
    }
}
