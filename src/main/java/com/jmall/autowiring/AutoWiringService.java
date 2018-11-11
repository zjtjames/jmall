/**
 * created by Zheng Jiateng on 2018/11/8.
 */
package com.jmall.autowiring;

public class AutoWiringService {

    private AutoWiringDao autoWiringDao;

//    public AutoWiringService(AutoWiringDao autoWiringDao) {
//        System.out.println("AutoWiringServiceConstructor");
//        this.autoWiringDao = autoWiringDao;
//
//    }

    public void setAutoWiringDao(AutoWiringDao autoWiringDao) {
        System.out.println("setAutoWiringDao");
        this.autoWiringDao = autoWiringDao;
    }

    public void say(String word) {
        this.autoWiringDao.say(word);
    }
}
