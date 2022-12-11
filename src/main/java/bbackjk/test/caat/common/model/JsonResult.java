package bbackjk.test.caat.common.model;


import bbackjk.test.caat.common.utils.StringUtilz;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JsonResult {

    private JsonHeader header;
    private JsonBody body;

    public static JsonResult success() {
        return success(null, 200);
    }

    public static JsonResult success(int httpStatus) {
        return success(null, httpStatus);
    }

    public static JsonResult success(Object data) {
        return success(data, 200);
    }

    public static JsonResult success(Object data, int httpStatus) {
        return new JsonResult(
                headerSuccess(httpStatus)
                , bodySuccess(data)
        );
    }

    public static JsonResult fail() {
        return fail(StringUtilz.EMPTY, 500);
    }

    public static JsonResult fail(int httpStatus) {
        return fail(StringUtilz.EMPTY, httpStatus);
    }

    public static JsonResult fail(String message) {
        return fail(message, 500);
    }


    public static JsonResult fail(String message, int httpStatus) {
        return new JsonResult(
                headerFail(message, httpStatus)
                , bodyFail()
        );
    }


    private static JsonHeader headerFail(String message, int httpStatus) {
        return new JsonHeader(
                false
                , httpStatus
                , message
        );
    }

    private static JsonHeader headerSuccess(int httpStatus) {
        return new JsonHeader(
                true
                , httpStatus
                , StringUtilz.EMPTY
        );
    }

    private static JsonBody bodyFail() {
        return new JsonBody(null);
    }

    private static JsonBody bodySuccess(Object data) {
        return new JsonBody(data);
    }
}
