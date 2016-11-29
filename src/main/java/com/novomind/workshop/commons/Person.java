package com.novomind.workshop.commons;

import java.util.Optional;

public class Person {

	private final String name;
	private final Optional<String> telefonNumber;

	public Person(String name) {
		this.name = name;
		telefonNumber = Optional.empty();
	}

	public Person(String name, String telefonNumber) {
		super();
		this.name = name;
		this.telefonNumber = Optional.of(telefonNumber);
	}

	public String getName() {
		return name;
	}
	public Optional<String> getTelefonNumber() {
		return telefonNumber;
	}


}
