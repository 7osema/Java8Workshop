package com.novomind.workshop.exercises;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExercise {

	public static void main(String[] args) {

		Integer[] digits = {  3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3, 2, 3,
				8, 4, 6, 2, 6, 4, 3, 3, 8, 3, 2, 7, 9, 5, 0, 2, 8, 8, 4, 1, 9, 7, 1,
				6, 9, 3, 9, 9, 3, 7, 5, 1, 0, 5, 8, 2, 0, 9, 7, 4, 9, 4, 4, 5, 9, 2,
				3, 0, 7, 8, 1, 6, 4, 0, 6, 2, 8, 6 };

		Optional<Integer> sum = Stream.of(digits).reduce(Integer::sum);
		System.out.println(sum);

		// Here we do not get an optional back
		Integer sumQuadrat = Stream.of(digits).reduce(0, (x, y) -> x + y*y);
		System.out.println(sumQuadrat);
	}

}
