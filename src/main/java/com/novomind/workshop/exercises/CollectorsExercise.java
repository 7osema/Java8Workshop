package com.novomind.workshop.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExercise {

	public static void main(String[] args) {
		List<String> oldNames = Arrays.asList("Otto", "Karl", "Franz");
		List<String> newNames = Arrays.asList("Maia", "Otto", "Franz");

		System.out.println("Old names: " +
				oldNames.stream()
				.filter(newNames::contains)
				.collect(Collectors.toList()));

		System.out.println("Deleted: " +
				oldNames.stream()
				.filter(n -> !newNames.contains(n))
				.collect(Collectors.toList()));

		System.out.println("New names:" +
				newNames.stream()
				.filter(n -> !oldNames.contains(n))
				.collect(Collectors.toList()));
	}

}
