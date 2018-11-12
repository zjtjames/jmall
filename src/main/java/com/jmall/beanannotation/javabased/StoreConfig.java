/**
 * created by Zheng Jiateng on 2018/11/12.
 */
package com.jmall.beanannotation.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfig {

    @Bean(name = "store", initMethod = "init", destroyMethod = "destroy")
    public Store getStringStore() {
        return new StringStore();
    }


}
