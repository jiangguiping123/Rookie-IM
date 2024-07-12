package com.rookie.im.user.domain.req;

import com.rookie.im.common.domain.req.BaseRequest;
import com.rookie.im.user.domain.dto.UserEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ImportUserReq extends BaseRequest {

    @ApiModelProperty(value = "用户资料列表")
    private List<@Valid UserEntity> userList;
}
