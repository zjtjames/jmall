/**
 * created by Zheng Jiateng on 2018/11/12.
 */
package com.jmall.beanannotation.javabased;

public class StringStore implements Store {

    public void init() {
        System.out.println("This is init.");
    }

    public void destroy() {
        System.out.println("This is destroy.");
    }
}
