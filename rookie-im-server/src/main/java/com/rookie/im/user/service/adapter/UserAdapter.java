package com.rookie.im.user.service.adapter;

//对类型转换的操作


import cn.hutool.core.bean.BeanUtil;
import com.rookie.im.user.common.Enum.YesOrNOEnum;
import com.rookie.im.user.domain.dto.UserEntity;
import com.rookie.im.user.domain.entity.User;

import java.util.UUID;

public class UserAdapter {

    //静态方法接收一个前端发送的数据req返回一个存入数据库中的User类
    public static User importUserSave(UserEntity entity) {
        User user =new User();
        BeanUtil.copyProperties(entity,user);
        user.setOpenId("1000");
        user.setUserId(UUID.randomUUID().toString());
        user.setForbiddenFlag(YesOrNOEnum.NO.getStatus());
        return user;
    }

}
