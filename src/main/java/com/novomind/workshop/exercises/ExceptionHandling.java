package com.novomind.workshop.exercises;

import java.util.function.Function;

public class ExceptionHandling {

	interface FunctionWithException {
		String apply(String s) throws Exception;
	}

	public static Function<String, String> unchecked(FunctionWithException func) {
		return inputString -> {
			try {
				return func.apply(inputString);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		};
	}

	public static void main(String[] args) {
		Function<String, String> function = unchecked( s -> {
			Thread.sleep(1000);
			return "fertig1";
		});

		/* Das kompiliert nicht weil eine Exception geworfen wird
		Function<String, String> f1 = s -> {
			Thread.sleep(1000);
			System.out.println("fertig2");
		};
		*/
	}

}
