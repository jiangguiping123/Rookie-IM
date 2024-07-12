package com.rookie.im.user.service;

import com.rookie.im.user.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rookie.im.user.domain.req.ImportUserReq;
import com.rookie.im.user.domain.resp.ImportUserResp;

import java.util.List;

/**
 * <p>
 * 菜鸟 IM 用户表 服务类
 * </p>
 *
 * @author paoge
 * @since 2024-07-11
 */
public interface IUserService  {
    User getUserById(Integer id);


    ImportUserResp importUsers(ImportUserReq userList);

}
