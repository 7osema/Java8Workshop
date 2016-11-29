package com.novomind.workshop.exercises;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExercise {

	public static class HelpClass {
		Double result = 0.0;

		public void add(Double d, Double... other) {
			result = result + d * d;
			for (Double double1 : other) {
				result = result + double1 * double1;
			}
		}

		public void add(HelpClass other) {
			result = result + other.result;
		}

	}

	public static void main(String[] args) {

		Integer[] digits = {  3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3,
				8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1,
				6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9, 2,
				3, 0, 7, 8, 1, 6, 4, 0, 6, 2, 8, 6 };

		Double[] doubles = {3.0, 4.5, 6.3, 3.0};

		Optional<Integer> sum = Stream.of(digits).reduce(Integer::sum);
		System.out.println(sum);

		// Here we do not get an optional back
		Double sumQuadrat = Stream.of(doubles).reduce(0.0, (x, y) -> x + y*y);
		System.out.println(sumQuadrat);

		HelpClass collect = Stream.of(doubles).collect(HelpClass::new, HelpClass::add, HelpClass::add);
		System.out.println(collect.result);
	}


}
