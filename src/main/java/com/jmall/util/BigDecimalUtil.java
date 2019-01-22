/**
 * created by Zheng Jiateng on 2019/1/22.
 */
package com.jmall.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    //把构造器设为私有 避免工具类被实例化
    private BigDecimalUtil() {
    }

    // 不会丢失精度的加法 在工具类里将它用BigDecimal的String构造器转化成BigDecimal再运算
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        // 除不尽的策略 保留2位小数 四舍五入
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }

}
