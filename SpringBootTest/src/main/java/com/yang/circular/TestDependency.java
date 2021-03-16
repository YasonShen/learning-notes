package com.yang.circular;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shenqiuyang3
 * @date 2021/2/23 12:04
 * @Description
 */
public class TestDependency {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanA.class, BeanB.class);
        BeanA beanA = context.getBean(BeanA.class);
        BeanB beanB = context.getBean(BeanB.class);
//        BeanB beanBInBeanA = beanA.getBeanB();
//        BeanA beanAInBeanB = beanB.getBeanA();
        System.out.println(beanA);
        System.out.println(beanB);
//        System.out.println(beanB == beanBInBeanA);
//        System.out.println(beanA == beanAInBeanB);
    }
}

