package com.pattern.facade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * 调用不同系统的方法
 * 典型代表 RequestFacade
 */
public class FacadeFather {
    SubSys1 subSys1 = new SubSys1();
    SubSys2 subSys2 = new SubSys2();
    SubSys3 subSys3 = new SubSys3();

   public void doSomethingFacade(){
        subSys1.doSth1();
        subSys2.doSth2();
        subSys3.doSth3();
    }
}
