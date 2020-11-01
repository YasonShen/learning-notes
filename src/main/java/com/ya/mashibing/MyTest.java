package com.ya.mashibing;

import com.ya.mashibing.controller.UserController;
import com.ya.mashibing.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shenqiuyang3
 * @date 2020/10/18 14:49
 */
public class MyTest {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        UserService userService = new UserService();

        Class<? extends UserController> clazz = userController.getClass();
        Field field = clazz.getDeclaredField("userService");
        String name = field.getName();
        name = "set" + name.substring(0,1).toUpperCase() + name.substring(1,name.length());
        Method method = clazz.getMethod(name, UserService.class);
        method.invoke(userController, userService);

//        System.out.println(userService);
//        Class<? extends UserController> clazz = userController.getClass();
//        Field declaredField = clazz.getDeclaredField("userService");
//        declaredField.setAccessible(true);
//        String name = declaredField.getName();
//        name = "set" + name.substring(0,1).toUpperCase() + name.substring(1, name.length());
//        Method method = clazz.getMethod(name, UserService.class);
//        method.invoke(userController, userService);
        System.out.println(userController.getUserService());
    }
}
