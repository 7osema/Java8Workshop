package com.novomind.workshop.commons;

public class CoolClass implements TestInterfaceA, TestInterfaceB {

	@Override
	public String getName() {
		return TestInterfaceB.super.getName();
	}

}
