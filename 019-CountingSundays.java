/*
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * 
 * Thirty days has September, April, June and November.
 * 
 * All the rest have thirty-one,
 * 
 * Saving February alone, Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine
 * 
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */

import  java.time.*;
import java.time.temporal.TemporalAdjusters;

public class N019CountingSundays {
	
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(1901, Month.JANUARY, 1);
		LocalDate endDate = LocalDate.of(2000, Month.DECEMBER, 31);
		int sundaysCount = 0;
		
		while (date.isBefore(endDate)) {
			date = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
			if (date.getDayOfMonth() == 1) {
				sundaysCount++;
			}
		}
		
		System.out.println(sundaysCount);
	}
}
