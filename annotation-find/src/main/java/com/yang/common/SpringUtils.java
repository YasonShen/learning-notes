package com.yang.common;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenqiuyang
 * @date 2021/7/11 上午11:37
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private Map<String, Object> handleMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
        Map<String, Object> beanMaps = applicationContext.getBeansWithAnnotation(ServiceName.class);
        if (MapUtils.isNotEmpty(beanMaps)){
            for (Map.Entry<String, Object> bean : beanMaps.entrySet()) {
                ServiceName annotation = bean.getValue().getClass().getAnnotation(ServiceName.class);
                String className = annotation.value().getName();
                String name = annotation.name();
                System.out.println("className:"+className+", name:"+name);
                handleMap.put(className, name);
            }
        }
    }

    public static <T> T getBean(String beanName){
        if (applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else {
            return null;
        }

    }
}
