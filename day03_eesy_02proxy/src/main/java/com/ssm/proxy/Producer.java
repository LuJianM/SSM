package com.ssm.proxy;

public class Producer implements IProducer {
    public void saleProduct(float money) {
        System.out.println("电脑卖出去了，获得了"+money+"元");
    }

    public void afterservice(float money) {
        System.out.println("电脑维护，花了"+money+"元");
    }
}
