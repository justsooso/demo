package com.example.designPattern.builder;

public class ProductB implements Product {
    @Override
    public void Build() {
        String clsName = this.getClass().getName();
        System.out.println(clsName + " build...");
    }
}
