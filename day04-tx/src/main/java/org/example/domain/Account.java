package org.example.domain;

import java.io.Serializable;

/**
 * Account class
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/9/23
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;

    public Account() {
    }

    public Account(Integer id, String name, Float money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
    // getter and setter
    // toString
}
