package com.yang.io;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * @author shenqiuyang
 * @date 2021/7/5 下午3:43
 */
public class BufferedReaderTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
//        File file = new File("SpringBootTest/src/resources/login.txt");
        try {
            BufferedReader bufferedReader = null;
            try{
//                System.out.println(file.getCanonicalPath());
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(BufferedReaderTest.class.getResource("/login.txt").getPath()), "UTF-8"));

                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    if (StringUtils.startsWith(line, "###")) {
                        continue;
                    }
                    stringBuffer.append(line);
                }
            }finally {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println(stringBuffer.toString());
        }

        JSONObject jsonObject = JSONObject.parseObject(stringBuffer.toString());
        JSONObject variable = JSONObject.parseObject(jsonObject.getString("variable"));
        if (variable != null){
            Iterator<Map.Entry<String, Object>> iter = variable.entrySet().iterator();
            while (iter.hasNext()){
                Map.Entry<String, Object> next = iter.next();
                System.out.println(next.getKey());
                System.out.println(next.getValue());
            }
        }
        JSONArray flow = JSONObject.parseArray((jsonObject.getString("flow")));
        for (Object object : flow) {
            System.out.println(object);
            JSONObject obj = JSONObject.parseObject(object.toString());
            String action = obj.getString("action");
            System.out.println(action);
            char[] chars = action.toCharArray();
            System.out.println(String.valueOf(chars));
        }
        System.out.println(jsonObject);
    }
}
