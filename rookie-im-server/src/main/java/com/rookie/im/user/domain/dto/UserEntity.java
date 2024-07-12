package com.rookie.im.user.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.rookie.im.user.common.annotation.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "导入用户资料实体")
public class UserEntity {
    @ApiModelProperty(value = "Appid", required = true)
    private Long appId;
    @Max(value = 5, message = "昵称长度不能超过5个字符")
    @Min(value = 3, message = "昵称长度不能少于3个字符")
    @NotNull
    @ApiModelProperty(value = "昵称", required = true)
    private String userName;
    @IsMobile     // 自定义注解
    @NotNull
    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "性别")
    private Integer sex;
    @ApiModelProperty(value = "个性签名")
    private String selfSignature;
    @ApiModelProperty(value = "是否允许好友邀请")
    private Integer friendAllowType;
}
