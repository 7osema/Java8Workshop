package com.novomind.workshop.commons;

public interface TestInterfaceA {
	default String getName(){
		return TestInterfaceA.class.getName();
	}
}
