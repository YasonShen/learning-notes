package com.yang.mashibing.service;

import com.yang.mashibing.dao.UserDao;

/**
 * @author shenqiuyang3
 * @date 2020/10/18 14:48
 */
public class UserService {

    private UserDao userDao;


    public UserService() {

    }

    public void save() {
        userDao.save();
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;

        //看看有没有拿到userDao
        System.out.println(userDao);
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
    }
}
