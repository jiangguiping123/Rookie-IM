package com.rookie.im.user.common.exception;

import com.rookie.im.common.domain.resp.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
