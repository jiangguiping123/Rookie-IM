package com.rookie.im.user.common.exception;

import lombok.Data;


//统一异常返回
@Data
public class BusinessException extends RuntimeException{

    private Integer errorCode;
    private String errorMsg;

    //构造函数
    public BusinessException() {
        super();
    }

    public BusinessException(Integer errorCode,String errorMsg) {
        super(errorMsg);
        this.errorCode =errorCode;
        this.errorMsg =errorMsg;
    }

    public BusinessException(ErrorEnum error) {
        super(error.getErrorMsg());
        this.errorMsg =error.getErrorMsg();
        this.errorCode =error.getErrorCode();
    }
}
