/**
 * created by Zheng Jiateng on 2018/11/11.
 */
package com.jmall.beanannotation.injection.service;

import com.jmall.beanannotation.injection.dao.InjectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InjectionServiceImpl implements InjectionService {

//    @Autowired // 一种用法：@Autowired用于成员变量
//    private InjectionDAO injectionDAO;

//    构造器注入
//    @Autowired
//    public InjectionServiceImpl(InjectionDAO injectionDAO) {
//        this.injectionDAO = injectionDAO;
//    }

//     设值注入
//    @Autowired
//    public void setInjectionDAO(InjectionDAO injectionDAO) {
//        this.injectionDAO = injectionDAO;
//    }

//    @Override
//    public void save(String arg) {
//        //模拟业务操作
//        System.out.println("Service接受参数" + arg);
//        arg = arg + ":" +this.hashCode();
//        injectionDAO.save(arg);
//    }

    @Autowired
    private List<InjectionDAO> list;

    @Autowired
    private Map<String, InjectionDAO> map;

    @Override
    public void save(String arg) {
        if (!list.isEmpty()) {
            System.out.println("list...");
            for (InjectionDAO bean : list) {
                System.out.println(bean.getClass().getName());
            }
        } else {
            System.out.println("List<InjectionDAO> list is null");
        }

        System.out.println();

        if (!map.isEmpty()) {
            System.out.println("map...");
            for (Map.Entry<String, InjectionDAO> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue().getClass().getName());
            }
        } else {
            System.out.println("List<InjectionDAO> list is null");
        }
    }
}
