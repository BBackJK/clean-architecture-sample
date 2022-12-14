package bbackjk.test.caat.common.enums;

public enum ErrorCode {

    DOMAIN_NOT_FOUND(404, "존재하지 않은 도메인 입니다."),
    ENTITY_NOT_FOUND(404, "존재하지 않은 데이터 입니다."),
    BOARD_NOT_FOUND(404, "존재하지 않은 게시판 입니다."),
    DB_FAIL(500, "DB 에러"),
    UPDATE_NO_PERMISSION(409, "수정할 권한이 없습니다."),
    PARAMETER_NOT_VALID(400, "유효한 요청이 아닙니다.");

    private final int httpCode;
    private final String message;

    public int getHttpCode() {
        return httpCode;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

}
