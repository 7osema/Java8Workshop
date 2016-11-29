package com.novomind.workshop.commons;

public interface TestInterfaceB {
	default String getName() {
		return TestInterfaceB.class.getName();
	}
}
