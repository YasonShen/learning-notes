package com.yang.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shenqiuyang3
 * @date 2021/3/6 16:14
 * @Description
 */
public class SimpleWriteTest {

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 1; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    private List<DemoData2> data2() {
        List<DemoData2> list = new ArrayList<DemoData2>();
        for (int i = 0; i < 3; i++) {
            DemoData2 data = new DemoData2();
            data.setCount(new Date());
            data.setTotal("11");
            list.add(data);
        }
        return list;
    }


    @Test
    public void simpleWrite() {
        // 写法1
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, DemoData.class).sheet("模板1").doWrite(data());
//        EasyExcel.write(fileName, DemoData.class).sheet("模板2").doWrite(data());
        ExcelWriter excelWriter = null;
        try {
            // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
            WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "模板" + 1).build();
            WriteSheet writeSheet2 = EasyExcel.writerSheet(1, "模板" + 2).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = data();
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            ExcelWriter excelWriter1 = EasyExcel.write(fileName, DemoData2.class).build();
            for (int i = 0; i < 2; i++) {
                excelWriter.write(data, writeSheet1);
                excelWriter1.write(data2(), writeSheet1);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }


    }
}
