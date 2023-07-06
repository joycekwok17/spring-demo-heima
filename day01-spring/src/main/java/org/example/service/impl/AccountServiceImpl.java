package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;

import java.util.*;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
//
public class AccountServiceImpl implements IAccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    //    private IAccountDao accountDao;
//    private String name;
//    private Integer age;
//    private Date birthday;

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }

    @Override
    public void saveAccount() {
//        int i=1;
//        accountDao.saveAccount();
//        System.out.println(i++);
//        System.out.println("service executed saveAccount method..."+ name + " " + age + " " + birthday);
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(mySet);
        System.out.println(myProps);
    }
}
