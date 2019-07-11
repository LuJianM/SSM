package com.ssm.ul;

import com.ssm.dao.IAccountDao;
import com.ssm.service.IAccountService;
import com.ssm.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟表现层
 */
public class Client {

    /**
     * 核心容器在的两个接口引发出了问题（工厂是立即创建所有的资源，还是需要用的时候再来加载需要的资源）：
     * ApplicationContext：
     *      构建核心容器时，创建对象采取的策略是立即加载的方式。读完配置文件就创建配置文件中的对象。
     * BeanFactory：
     *      构建核心容器时，创建对象采取的策略是延迟加载的方式。什么时候根据id获取对象，什么时候创建对象。
     * @param args
     */
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext applicationContext = null;
//        applicationContext = new FileSystemXmlApplicationContext("");
//        applicationContext = new AnnotationConfigApplicationContext("");
        applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //两种获取实例的方式
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");



        System.out.println(as);
        as.saveAccount();
        as.toString();
        //手动关闭容器
        applicationContext.close();
        Thread.sleep(3000);

    }
}
