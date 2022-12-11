package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.enums.ErrorCode;

public class ParameterNotValidException extends CommonException {

    public ParameterNotValidException() {
        super(ErrorCode.PARAMETER_NOT_VALID);
    }
}
