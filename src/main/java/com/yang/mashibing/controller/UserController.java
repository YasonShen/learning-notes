package com.yang.mashibing.controller;

import com.yang.mashibing.service.UserService;

/**
 * @author shenqiuyang3
 * @date 2020/10/18 14:49
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
