package com.example.designPattern.builder;
public class ConcreteBuilder implements Builder {

	private Product resultProduct;

	public Product getResult() {
		return resultProduct;
	}

	public void buildPart() {
        resultProduct = new ProductA();
        resultProduct.Build();
	}
}