package com.novomind.workshop.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jangulo
 *
 */
public class CollectionsExercise {

	private static Map<String, String> cache = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			System.out.println(cachedComputation("test"));
		}
	}

	private static String cachedComputation(String string) {
		return cache.computeIfAbsent(string, CollectionsExercise::expensiveComputation);
	}

	public static String expensiveComputation(String param) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "das hat aber gedauert: "+param;
	}

}
