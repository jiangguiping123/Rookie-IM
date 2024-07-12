package com.rookie.im.user.common.exception;

import com.rookie.im.common.domain.resp.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.MalformedParametersException;

import static com.rookie.im.user.common.exception.CommonErrorEnum.PARAM_INVALID;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    //当系统异常时，返回ApiResult.fail(500, "系统异常") 给前端提示
    //当业务中抛出BusinessException时，返回ApiResult.fail(e.getMessage())
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult<?> businessException(BusinessException e) {
        log.info("business exception! reason is: {}", e.getMessage(),e);
        return ApiResult.fail(e.getErrorCode(), e.getMessage());
    }

    //捕获系统异常，返回ApiResult.fail(500, "系统异常") 给前端提示
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        StringBuffer errMsg = new StringBuffer();
        e.getBindingResult().getFieldErrors()
                .forEach(x -> errMsg.append(x.getField()).append(x.getDefaultMessage()).append(","));
        String errorMsg = errMsg.toString();
        log.info("method argument not valid exception! reason is: {}", errMsg.toString(), e);
        return ApiResult.fail(PARAM_INVALID.getErrorCode(), errorMsg.substring(0,errorMsg.length() -1));

    }


}
