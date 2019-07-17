package com.ssm.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person
{
    void walk();
    void sayHello(String name);
}

class Ljm implements Person{
    public void walk() {
        System.out.println("鲁建明在走");
    }

    public void sayHello(String name) {
        System.out.println("鲁建明说："+name);
    }
}

class MyInvokationHandler implements InvocationHandler
{
    private Object targetObject;
    public  MyInvokationHandler(Object targetObject){
        this.targetObject=targetObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("正在执行的方法:" + method);

        if (args != null)
        {
            System.out.println("执行该方法传入的实参：");
            for (Object val : args)
            {
                System.out.println(val);

            }
        }
        else
        {

            System.out.println("调用该方法无需实参！");
            method.invoke(targetObject,args);
        }
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) throws Exception
    {
        //自己的类
        Ljm ljm = new Ljm();
        //创建一个InvocationHandler对象
        InvocationHandler handler = new MyInvokationHandler(ljm);
        // 使用指定的InvocationHandler来生成一个动态代理对象
        Person p = (Person)Proxy.newProxyInstance(ljm.getClass().getClassLoader()
                , ljm.getClass().getInterfaces(), handler);
        //调用动态代理对象的walk()和sayHello()
        p.walk();
        //p.sayHello("孙悟空");
    }
}
