package com.rookie.im.user.controller;


import com.rookie.im.common.domain.resp.ApiResult;
import com.rookie.im.user.domain.req.ImportUserReq;
import com.rookie.im.user.domain.resp.ImportUserResp;
import com.rookie.im.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

/**
 * <p>
 * 菜鸟 IM 用户表 前端控制器
 * </p>
 *
 * @author paoge
 * @since 2024-07-11
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户资料相关接口")
public class UserController {

        @Autowired
        private IUserService userService;
        @GetMapping("/")
        public String getUser() {
            return userService.getUserById(1).getUserName();
        }

        @PutMapping("/import")
        @ApiOperation(value = "导入用户资料导入")
        public ApiResult<ImportUserResp> importUser(@RequestBody @Valid ImportUserReq req) {
                ImportUserResp resp = userService.importUsers(req);
                return ApiResult.success(resp);
        }

}

