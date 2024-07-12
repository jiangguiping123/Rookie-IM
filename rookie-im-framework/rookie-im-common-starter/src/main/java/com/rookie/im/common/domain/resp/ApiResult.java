package com.rookie.im.common.domain.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "通用API返回结果")
public class ApiResult<T> {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "错误码")
    private Integer errCode;
    @ApiModelProperty(value = "错误信息")
    private String errMsg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> ApiResult<T> success() {
        ApiResult<T> result = new ApiResult<>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> ApiResult<T> fail(Integer code, String msg) {
        ApiResult<T> result = new ApiResult<T>();
        result.setSuccess(Boolean.FALSE);
        result.setErrCode(code);
        result.setErrMsg(msg);
        return result;
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>();
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

//    public static <T> ApiResult<T> fail(ErrorEnum errorEnum) {
//        ApiResult<T> result = new ApiResult<T>();
//        result.setSuccess(Boolean.FALSE);
//        result.setErrCode(errorEnum.getErrorCode());
//        result.setErrMsg(errorEnum.getErrorMsg());
//        return result;
//    }

}
