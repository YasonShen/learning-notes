package com.yang;

import com.yang.common.SpringUtils;
import com.yang.service.DemoService;
import com.yang.service.impl.DemoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shenqiuyang
 * @date 2021/7/11 上午11:59
 */
public class TestClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        DemoService bean = SpringUtils.getBean("DemoServiceImpl");
        System.out.println("start run");
    }
}
