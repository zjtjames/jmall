/**
 * created by Zheng Jiateng on 2018/11/1.
 */
package com.jmall.ioc.interfaces;

public class OneInterfaceImplTestDrive {
    public static void main(String[] args) {
        OneInterface oif = new OneInterfaceImpl();
        System.out.println(oif.hello("huangfeihong."));
    }
}
