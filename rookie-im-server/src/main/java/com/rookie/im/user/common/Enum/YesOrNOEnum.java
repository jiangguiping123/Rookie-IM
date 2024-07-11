package com.rookie.im.user.common.Enum;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum YesOrNOEnum {

    NO(0,"否"),
    YES(1,"是");

    //状态
    private final Integer status;
    //描述
    private final String desc;
}
