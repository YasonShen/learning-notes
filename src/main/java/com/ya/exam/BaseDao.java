package com.ya.exam;

import javax.websocket.Session;

/**
 * @author shenqiuyang3
 * @date 2020/10/20 9:33
 */
public abstract class BaseDao<T> {

    private Session session;
    private Class clazz;

    public BaseDao() {
        Class<? extends BaseDao> clazz = this.getClass();
    }
 }
