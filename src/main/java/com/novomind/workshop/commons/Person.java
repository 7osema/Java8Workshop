package com.novomind.workshop.commons;

import java.util.Optional;

public class Person {

	public enum Gender {
		MALE, FEMALE;
	}

	private final String name;
	private final String telefonNumber;
	private final Gender gender;
	private final Integer age = 10;

	public Person(String name) {
		this.name = name;
		this.telefonNumber = null;
		this.gender = null;
	}

	public Person(String name, String telefonNumber) {
		super();
		this.name = name;
		this.telefonNumber =telefonNumber;
		this.gender = null;
	}

	public Person(String name, String telefonNumber, Gender gender) {
		this.name = name;
		this.telefonNumber = telefonNumber;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	public Optional<String> getTelefonNumber() {
		return Optional.ofNullable(telefonNumber);
	}

	public Gender getGender() {
		return Optional.ofNullable(gender).orElse(Gender.MALE);
	}

	public Integer getAge() {
		return age;
	}

}
