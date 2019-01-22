/**
 * created by Zheng Jiateng on 2019/1/22.
 */
package com.jmall;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test1() {
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
    }

    @Test
    public void test2() {
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.add(b2));
        System.out.println(Double.toString(0.52));
    }

   @Test
    public void test3() {
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.add(b2));
    }

}
