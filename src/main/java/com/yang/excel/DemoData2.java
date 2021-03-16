package com.yang.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @author shenqiuyang3
 * @date 2021/3/6 16:55
 * @Description
 */
public class DemoData2 {
    @ExcelProperty(value = "字符串标题", index = 0)
    private String total;
    @ExcelProperty(value = "日期标题", index = 2)
    private Date count;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getCount() {
        return count;
    }

    public void setCount(Date count) {
        this.count = count;
    }
}
