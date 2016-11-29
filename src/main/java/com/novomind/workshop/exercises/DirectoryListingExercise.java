package com.novomind.workshop.exercises;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryListingExercise {

	public static void main(String[] args) {
		listDirectories();
		//final String test2 = "test2";
		//andThen(() -> System.out.println("test1"), () -> System.out.println(test2)).run();
	}

	@SuppressWarnings("unchecked")
	private static void listDirectories() {
		File file = new File("C:\\Users\\jangulo\\Documents\\JavaSchulung");
		String[] directoryList = file.list();

		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(directoryList));

		arrayList.sort(createComparator(true, false, true));
		System.out.println(arrayList);
		arrayList.sort(createComparator(false, false, false));
		System.out.println(arrayList);
		arrayList.sort(createComparator(false, true, false));
		System.out.println(arrayList);
	}

	public static Runnable andThen(Runnable r1, Runnable r2) {

		return new Runnable() {

			@Override
			public void run() {
				r1.run();
				r2.run();
			}
		};
	}

	public static Comparator<String> createComparator(boolean ascending,
			boolean caseSensitive, boolean spaceSensitive) {
		return (o1, o2) -> {
			String myo1 = caseSensitive ? o1
					: o1.toLowerCase();
			String myo2 = caseSensitive ? o2
					: o2.toLowerCase();
			myo1 = spaceSensitive ? myo1.replaceAll("\\s+", "")
					: myo1;
			myo2 = spaceSensitive ? myo2.replaceAll("\\s+", "")
					: myo2;
			return ascending ? myo1.compareTo(myo2)
					: myo2.compareTo(myo1);
		};
	}
}
