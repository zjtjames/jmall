/**
 * created by Zheng Jiateng on 2018/11/10.
 */
package com.jmall.beanannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component("guaguagua")
public class BeanAnnotation {

    public void say(String arg) {
        System.out.println("BeanAnnotation: " + arg);
    }

    public void myHashCode() {
        System.out.println("BeanAnnotation: " + this.hashCode());
    }

}
