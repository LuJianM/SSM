package com.ssm.factory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建一个bean对象的工厂
 * Bean：在计算机术语中，表示可重用组件，如Service
 * JavaBean：用java 语言编写的可重用组件
 *      JavaBean > 实体类
 *
 * 所以BeanFactory是创建我们service和dao对象的。
 * 如何创建：
 *      1.需要一个配置文件来配置Service和Dao
 *          配置内容：唯一标识=全限定名（key：value）
 *      2.读取配置文件中的内容，用反射创建对象。
 *
 *
 *
 *
 */
public class BeanFactory {
    private static Properties props;

    //用来保存要创建的对象。可以称它为容器
    private static Map<String,Object> beans;

    static {
        try {
            props = new Properties();
            //getResourceAsStream(String path)：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
            InputStream in  = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String keyPath = props.getProperty(key);
                Object bean = Class.forName(keyPath).newInstance();
                beans.put(key,bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据bean名称获取bean对象
     * @param beanName
     * @return
     */
    public  static Object getBean(String beanName){
        return beans.get(beanName);
    }
}


//    /**
//     * 根据Bean名称获取Bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            System.out.println("beanPath："+beanPath);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
//}
