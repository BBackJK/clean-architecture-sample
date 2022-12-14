package bbackjk.test.caat.common.exception;

import bbackjk.test.caat.common.model.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {
            BoardNotFoundException.class
            , DBFailException.class
            , DomainNotFoundException.class
            , UpdateNoPermissionException.class
            , ParameterNotValidException.class
            , CommonException.class
    })
    protected JsonResult boardNotFoundHandler(CommonException ex) {
        return JsonResult.fail(ex.getMessage(), ex.getErrorCode().getHttpCode());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected JsonResult validExceptionHandler(ConstraintViolationException ex) {

        List<String> results = new ArrayList<>();
        for (var x : ex.getConstraintViolations()) {
            results.add(x.getMessage());
        }

        return JsonResult.fail(String.join("\n", results));
    }
}
