package com.example.designPattern.Prototype;

public class ConcretePrototype1 implements Prototype {
	public Prototype clone() {
		Prototype prototype = new ConcretePrototype1();
        System.out.println("ConcretePrototype1 clone()");
		return prototype;
	}
}

