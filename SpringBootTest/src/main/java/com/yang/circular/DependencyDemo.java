package com.yang.circular;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenqiuyang3
 * @date 2021/2/23 16:40
 * @Description
 */
public class DependencyDemo {

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    private final Set<String> singletonsCurrentlyInCreation =
            Collections.newSetFromMap(new ConcurrentHashMap<>(16));

    public <T> T getBean(Class<T> beanClass) throws Exception{
        beanClass.getSimpleName();

        return null;
    }
}
