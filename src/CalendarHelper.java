import java.util.Scanner;

/**
 * Helper methods for the Calendar program
 * 
 * @author Javier Garcia
 *
 */
public class CalendarHelper {
	
	/**
	 * This method calculates the day that Thanksgiving is on. Thanksgiving is
	 * always on the fourth Thursday of November. Depending on the first day of the
	 * month, a constant needs to be added to 3 * 7 since we have three full weeks.
	 * For example, if the first day of the month is on a Sunday then for that month
	 * Thanksgiving will be on 5 + 3 * 7 = 26th day of November.
	 * 
	 * @param startDay The day of the week that November starts on (0 = Sunday)
	 * @return The day in November that Thanksgiving is on
	 */
	public static int thanks(int startDay) {
		int i = (5 - startDay)+ (3*7);//calculates thanksgiving day
		return i;
	}

	
	/**
	 * This method returns the day of the week that the first day of a month occurs
	 * on. First it uses the getTotalNumberOfDays() method to get the number of days
	 * elapsed since January 1st, 1800 which was on a Wednesday (3). With total
	 * number of days since 1/1/1800 we can add 3 and then mod by 7 to get the day
	 * of the week that a month starts on.
	 * 
	 * @param year  The year for the month to determine
	 * @param month The month to determine
	 * @return The day of the week that the month begins on. 0 = Sunday and 6 =
	 *         Saturday.
	 */
	public static int getStartDay(int year, int month) {
		// call the method getTotalNumberOfDays and store it in a variable
		int start = getTotalNumberOfDays(year,month);
		// called start
		start += 3;
		// add 3 to the variable start
		// return start % 7
		return start%7;

	}

	/**
	 * Returns the total number of the days up to the given month in the given year
	 * since January 1st, 1800. For example, passing 2 for the month (February) and
	 * 1800 for the year should return 31 since 31 days would have had to pass to
	 * get to 2/1/1800. Similarly, passing 2 for the month and 1801 for the year
	 * should return 396 (365 + 31) since 1800 was not a leap year. This method
	 * should use getNumberOfDaysInMonth() and isLeapYear() to calculate the result.
	 * 
	 * @param year  The year for the month to determine
	 * @param month The month to determine
	 * @return The total number of days up to the given month for a given year. For
	 *         example, passing 2 for the month (February) should return 31 because
	 *         there are always 31 days before February.
	 */
	public static int getTotalNumberOfDays(int year, int month) {
		int totdays = year - 1800;//finds amount of years after 1800
		totdays *= 365; //multiplies ^ by a year
		if(year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
			totdays += year/400;
		}
		if (month == 1) {//Distinguishes month with 1 - 12
			totdays += 0;
		}
		if (month == 2) {//Distinguishes month with 1 - 12
			totdays += 31;
		}
		if (month == 3) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 60;
			} else {
				totdays += 59;
			}
		}
		if (month == 4) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 91;
			} else {
				totdays += 90;
			}
		}
		if (month == 5) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 121;
			} else {
				totdays += 120;
			}
		}
		if (month == 6) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 152;
			} else {
				totdays += 151;
			}
		}
		if (month == 7) {//Distinguishes month with 1 - 12
			if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 182;
			} else {
				totdays += 181;
			}
		}
		if (month == 8) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 213;
			} else {
				totdays += 212;
			}
		}
		if (month == 9) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 244;
			} else {
				totdays += 243;
			}
		}
		if (month == 10) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 274;
			} else {
				totdays += 273;
			}
		}
		if (month == 11) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 305;
			} else {
				totdays += 304;
			}
		}
		if (month == 12) {//Distinguishes month with 1 - 12
			if (year % 400 == 0|| year % 4 == 0 && year % 100 != 0) {//checks if leap year
				totdays += 235;
			} else
				totdays += 235;
		}
		return totdays;
	}

	/**
	 * Returns the number of the days in the given month of the given year. Take
	 * leap year into consideration.
	 * 
	 * @param year  The year for the month to determine
	 * @param month The month to determine
	 * @return The total number of days in the given month.
	 */
	public static int getNumberOfDaysInMonth(int year, int month) {
		int days = 1;
		if(month == 1) {//finds days in that month
			days = 31;
		}
		if(month == 2) {//finds days in that month
			if(year%400 == 0|| year % 4 == 0 && year % 100 != 0) {//calculates leap day
				days = 29;
			}else {
				days = 28;
			}
		}
		if(month == 3) {//finds days in that month
			days = 31;
		}
		if(month == 4) {//finds days in that month
			days = 30;
		}
		if(month == 5) {//finds days in that month
			days = 31;
		}
		if(month == 6) {//finds days in that month
			days = 30;
		}
		if(month == 7) {//finds days in that month
			days = 31;
		}
		if(month == 8) {//finds days in that month
			days = 31;
		}
		if(month == 9) {//finds days in that month
			days = 30;
		}
		if(month == 10) {//finds days in that month
			days = 31;
		}
		if(month == 11) {//finds days in that month
			days = 30;
		}
		if(month == 12) {//finds days in that month
			days = 31;
		}
	
		return days;

	}

}

