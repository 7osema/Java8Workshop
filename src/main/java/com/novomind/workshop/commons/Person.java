package com.novomind.workshop.commons;

import java.util.Optional;

public class Person {

	private final String name;
	private final String telefonNumber;

	public Person(String name) {
		this.name = name;
		this.telefonNumber = null;
	}

	public Person(String name, String telefonNumber) {
		super();
		this.name = name;
		this.telefonNumber =telefonNumber;
	}

	public String getName() {
		return name;
	}
	public Optional<String> getTelefonNumber() {
		return Optional.ofNullable(telefonNumber);
	}


}
