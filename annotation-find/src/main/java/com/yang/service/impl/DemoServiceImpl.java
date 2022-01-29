package com.yang.service.impl;

import com.yang.common.ServiceName;
import com.yang.service.DemoService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author shenqiuyang
 * @date 2021/7/11 上午11:31
 */
@Component
@ServiceName(value = DemoService.class, name = "DemoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String getName() {
        System.out.println("getName");
        return "";
    }

    @Override
    public String getId() {
        System.out.println("getId");
        return "";
    }
}
