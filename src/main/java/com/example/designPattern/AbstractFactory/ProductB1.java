package com.example.designPattern.AbstractFactory;


public class ProductB1 implements AbstractProductB {
    @Override
    public String doSomething() {
        String clsName = this.getClass().getName();
        System.out.println(clsName + " doSomething");
        return clsName;
    }
}

