package com.novomind.workshop.exercises;

import java.util.Arrays;

import com.novomind.workshop.commons.List2;


public class CollectionExercise {

	public static void main(String[] args) {

		List2<String> testList = //
				new List2<String>(Arrays.asList("a", "b", "c", "B"));

		testList.forEachIf(System.out::println, o -> o.equalsIgnoreCase("b"));
	}

}
