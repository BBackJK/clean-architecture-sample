package bbackjk.test.caat.common.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class JsonHeader {

    private final boolean result;
    private final int httpCode;
    private final String message;
    private final LocalDateTime timestamp;

    public JsonHeader(boolean result, int httpCode, String message) {
        this.result = result;
        this.httpCode = httpCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
