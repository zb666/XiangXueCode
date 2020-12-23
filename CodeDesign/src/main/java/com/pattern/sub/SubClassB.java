package com.pattern.sub;

import com.pattern.AbstractClass;

public class SubClassB extends AbstractClass {
    @Override
    protected void templateMethod() {
        System.out.println("Template B");
    }
}
