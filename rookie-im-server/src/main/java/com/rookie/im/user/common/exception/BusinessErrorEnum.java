package com.rookie.im.user.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessErrorEnum implements ErrorEnum{
    //业务异常
    BUSINESS_ERROR(1001,"{0}"),
    SYSTEM_ERROR(1002,"系统开小差啦,请稍后再试")
    //系统异常
    ;

    private Integer code;
    private String msg;

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}
