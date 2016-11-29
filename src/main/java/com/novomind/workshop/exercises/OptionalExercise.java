package com.novomind.workshop.exercises;

import java.util.Arrays;
import java.util.List;

import com.novomind.workshop.commons.Person;

public class OptionalExercise {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Otto", "345"),
				new Person("Karl"),
				new Person("Max"),
				new Person("Michael", "3445"),
				new Person("Thomas"),
				new Person("Guru"),
				new Person("Finn", "56677"),
				new Person("Franz", "345"));

		persons.forEach(person -> System.out.println(person.getName() + " - " + person.getTelefonNumber().orElse("no number")));
	}

}
