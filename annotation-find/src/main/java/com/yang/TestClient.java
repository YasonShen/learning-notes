package com.yang;

import com.yang.common.ServiceName;
import com.yang.common.SpringUtils;
import com.yang.service.DemoService;
import com.yang.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shenqiuyang
 * @date 2021/7/11 上午11:59
 */
public class TestClient {
    public static void main(String[] args) {
        System.out.println("start run");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringUtils.class, DemoServiceImpl.class);
        SpringUtils bean1 = applicationContext.getBean(SpringUtils.class);
        bean1.setApplicationContext(applicationContext);
        System.out.println(bean1);
        DemoService bean = applicationContext.getBean(DemoService.class);
        System.out.println(bean);
        Object demoService = SpringUtils.getBean("DemoService");
        System.out.println(demoService);
//        DemoService bean = SpringUtils.getBean("DemoServiceImpl");
    }
}
