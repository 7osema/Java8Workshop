package com.novomind.workshop.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureExercise {


	public static void main(String[] args) throws InterruptedException {

		String text1 = "Michael Guru Jose Sascha";
		String text2 = "Andreas Guru Boris Sascha";
		String text3 = "Elisabetta Tobias Henning Sascha";
		String text4 = "Guru Kathrin Nadja Sarah";

		List<String> texte = new ArrayList<>();
		texte.add(text1);
		texte.add(text2);
		texte.add(text3);
		texte.add(text4);

		ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<String, String>();

		class Task implements Runnable {

			private String text;

			public Task(String text) {
				this.text = text;
			}

			@Override
			public void run() {
				String[] splittedText = text.split(" ");
				for (String word : splittedText) {
					String indexOf = String.valueOf(texte.indexOf(text));
					hashMap.merge(word, indexOf, (oldValue, newValue)->{
						return oldValue + " "+ newValue;
					});
				}
			}

		}
		ExecutorService executorService = Executors.newCachedThreadPool();
		texte.forEach(s -> executorService.submit(new Task(s)));

		executorService.shutdown();
		executorService.awaitTermination(10, TimeUnit.SECONDS);

		System.out.println(hashMap);
	}


}
