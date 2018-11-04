/**
 * created by Zheng Jiateng on 2018/10/31.
 */
package com.jmall.ioc.interfaces;

public class OneInterfaceImpl implements OneInterface{

    @Override
    public String hello(String word) {
        return "Word from interface\"OneInterface\":" + word;
    }
}
