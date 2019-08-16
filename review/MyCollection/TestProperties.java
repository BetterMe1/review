package exercise.review.MyCollection;

import java.io.*;
import java.util.Properties;

/**
 * @Description:
 * @Author:Anan
 * @Date:2019/8/15
 */
public class TestProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("xa","西安");
        properties.setProperty("sh","上海");
        System.out.println(properties.getProperty("xn"));
        File file = new File("");
        try {
            properties.store(new FileOutputStream(file),"");//将属性资源持久化到外部
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            properties.load(new FileInputStream(file));//从外部加载配置
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
