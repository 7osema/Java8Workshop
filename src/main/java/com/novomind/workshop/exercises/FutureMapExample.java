package com.novomind.workshop.exercises;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureMapExample {
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws InterruptedException, ExecutionException {


		Future<String> future = executorService.submit(() -> {
			Thread.sleep(5000);
			return "Das hat aber gedauert AAA";
		});

		Future<String> mappedFuture = mapToLowerCase(future);

		System.out.println("Ich bin hier " + mappedFuture);
		System.out.println(mappedFuture.get());
		System.out.println(mapToLowerCase2(future).get());
		executorService.shutdown();
	}

	private static Future<String> mapToLowerCase2(Future<String> future) {
		return executorService.submit(() -> future.get().toLowerCase());
	}

	private static Future<String> mapToLowerCase(Future<String> future) {
		return new Future<String>() {

			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}

			@Override
			public String get() throws InterruptedException, ExecutionException {
				return future.get().toLowerCase();
			}

			@Override
			public String get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				return future.get().toLowerCase();
			}

		};
	}

}
