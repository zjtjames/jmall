/**
 * created by Zheng Jiateng on 2019/1/2.
 */
package com.jmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * str的形式为 yyyy-MM-dd HH:mm:ss  2019-01-02 17:24:25
 * Date为java.util.Date形式  Fri Jan 01 11:11:11 CST 2010
 */
public class DateTimeUtil {
    // joda-time

    //Date->str
    //str->Date

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dateToStr(Date date, String formatStr) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    // 重载
    public static String dateToStr(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static Date strToDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static void main(String[] args) {
        System.out.println(dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(strToDate("2010-01-01 11:11:11", "yyyy-MM-dd HH:mm:ss"));
    }
}
