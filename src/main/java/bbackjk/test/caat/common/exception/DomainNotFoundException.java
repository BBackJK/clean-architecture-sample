package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class DomainNotFoundException extends CommonException {

    public DomainNotFoundException() {
        super(ErrorCode.DOMAIN_NOT_FOUND);
    }
}
