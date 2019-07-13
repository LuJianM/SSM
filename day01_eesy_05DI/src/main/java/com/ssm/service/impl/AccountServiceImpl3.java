package com.ssm.service.impl;

import com.ssm.service.IAccountService;

import java.lang.reflect.Array;
import java.util.*;

public class AccountServiceImpl3 implements IAccountService {

    private String[] myStr;

    private List<String> myList;

    private Map<String, String> myMap;

    private Properties myProps;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(myStr));
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}
