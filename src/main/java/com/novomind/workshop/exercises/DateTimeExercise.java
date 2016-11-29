package com.novomind.workshop.exercises;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeExercise {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek[] daysOfWeek = DayOfWeek.values();

        System.out.print("   "+now.getMonth().getDisplayName(TextStyle.FULL, Locale.GERMANY) + " ");
        System.out.println(now.getYear());

        for (DayOfWeek dayOfWeek : daysOfWeek) {
            System.out.print(dayOfWeek.getDisplayName(TextStyle.SHORT,Locale.GERMANY) + " ");
        }

        System.out.println();

        LocalDateTime beginningThisMonth = now.withDayOfMonth(1);
        for (int i = 0; i < daysOfWeek.length && !beginningThisMonth.getDayOfWeek().equals(daysOfWeek[i]); i++) {
        	System.out.print("   ");
        }

        for (int i=0; i<beginningThisMonth.getMonth().length(false) && beginningThisMonth.getMonth().equals(now.getMonth()); i++) {
        	if (beginningThisMonth.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
        		System.out.println();
        	}
        	if (beginningThisMonth.getDayOfMonth() == now.getDayOfMonth()) {
        		//System.out.print(String.format("%10", beginningThisMonth.getDayOfMonth()));
        		System.out.printf("%2d ",beginningThisMonth.getDayOfMonth());
        	} else {
        		System.out.printf("%2d ",beginningThisMonth.getDayOfMonth());
        	}
        	beginningThisMonth = beginningThisMonth.plusDays(1);
        }

    }

}
