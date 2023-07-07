package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;

import java.util.*;

/**
 * The type Account service.
 *
 * @author Xuanchi Guo
 * @project Spring -demo
 * @created 7 /6/23
 */
//
public class AccountServiceImpl implements IAccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    /**
     * Sets my strs.
     *
     * @param myStrs the my strs
     */
    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    /**
     * Sets my list.
     *
     * @param myList the my list
     */
    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    /**
     * Sets my set.
     *
     * @param mySet the my set
     */
    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    /**
     * Sets my map.
     *
     * @param myMap the my map
     */
    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    /**
     * Sets my props.
     *
     * @param myProps the my props
     */
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
