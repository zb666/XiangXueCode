package com.pattern;

public abstract class AbstractClass {

    public void operation(){
        System.out.println("pre ... ");
        System.out.println("step1 ... ");
        System.out.println("step222");
        templateMethod();
    }

    protected abstract void templateMethod();


}
