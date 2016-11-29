package com.novomind.workshop.exercises;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import com.novomind.workshop.commons.Person;
import com.novomind.workshop.commons.Person.Gender;

public class GroupingExercise {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Anna", "345", Gender.FEMALE),
				new Person("Karl", "34544", Gender.MALE),
				new Person("Max", "34544", Gender.MALE),
				new Person("Michaelin", "3445", Gender.FEMALE),
				new Person("Thomas", "34544", Gender.MALE),
				new Person("Guru", "34544", Gender.MALE),
				new Person("Finn", "56677", Gender.MALE),
				new Person("Franz", "345", Gender.MALE));

		Map<Gender, List<String>> collect1 = persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
		Map<Gender, Integer> collect2 = persons.stream().collect(
				Collectors.groupingBy(Person::getGender,
				Collectors.mapping(p-> p.getAge(),
						Collectors.reducing(Integer.valueOf(0), (x, y) -> x + y))));
		Map<Gender, Integer> collect3 = persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.summingInt(Person::getAge)));

		System.out.println(collect1);
		System.out.println(collect2);
		System.out.println(collect3);


		List<String> asList = Arrays.asList("a", "b", "c");
		List<String> asList2 = Arrays.asList("1", "2", "3");

		System.out.println(zip(asList.stream(), asList2.stream()).collect(Collectors.toList()));
	}

	private static Stream zip(Stream<String> stream1, Stream<String> stream2) {

		Iterator<String> iterator1 = stream1.iterator();
		Iterator<String> iterator2 = stream2.iterator();

		Builder<Object> streamBuilder = Stream.builder();

		// achtung -> forEachRemaining braucht ein consumer!
		// andere Variante wäre iterator.forEach ...
		iterator1.forEachRemaining(obj -> streamBuilder.add(obj).add(iterator2.next()));

		return streamBuilder.build();

	}
}
