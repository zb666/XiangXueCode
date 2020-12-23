package com.pattern.sub;

import com.pattern.AbstractClass;

public class SubClassA extends AbstractClass {
    @Override
    protected void templateMethod() {
        System.out.println("Template A");
    }
}
