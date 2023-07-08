package org.example.cglib;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class Producer {
    public void saleProduct(float money) {
        System.out.println("sell product and get money: " + money);
    }

    public void afterService(float money) {
        System.out.println("provide after service and get money: " + money);
    }
}
