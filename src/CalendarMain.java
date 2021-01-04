import java.util.Scanner;

/**
 * A program that prints a calendar month or year.
 * 
 * @author Javier Garcia
 *
 */
public class CalendarMain {
	/**
	 * Use the getValidInt() method to get a valid year between 1800 and 3000.
	 * Within the do loop, add code where it has the "your code" comment to prompt
	 * them to enter a "y" or an "m" and if they answer "m" you will also need to
	 * ask them for a number between 1 and 12 using the getValidInt() method. If
	 * they answered "y" then print out every month for that year. If they answered
	 * "m" then print out just the one month. If they answered anything else then
	 * output an error message.
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// Prompt the user to enter the year

		boolean repeat;

		do {
			// your code
			System.out.print("Enter a year between 1800 and 3000: ");// user asked to enter a year
			int year = kb.nextInt();// user follows prompt
			while (year < 1800 || year > 3000) {// doesn't execute until input is within guidelines
				System.out.print("Enter a year between 1800 and 3000: ");// repeat if failed
				year = kb.nextInt();// repeat if failed
			}
			String choose;// variable for either year or month
			do {
				System.out.println("Select one of the following options: ");
				System.out.println("To get the month calendar press m");
				System.out.println("To get the year calendar press y");
				System.out.print("Enter your choice: ");// prompts user to choose either y or m
				choose = kb.next();
			} while (!choose.equalsIgnoreCase("y") && !choose.equalsIgnoreCase("m"));
			if (!choose.equalsIgnoreCase("y")) {
				System.out.println("Enter a month of the year(1-12)");// prompts user to enter a year
				int month = kb.nextInt();// users input of 1-12
				printMonth(year, month);// calls printMonth
			}
			if (!choose.equalsIgnoreCase("m")) {
				for (int month = 1; month <= 12; month++) { // puts user through all 12 months
					printMonth(year, month);// calls printMonth
				}
			}

			String answer;
			do {
				System.out.println();
				System.out.print("Do you have another year to print the calender:yes/no-->");// asks the user if they
																								// want to rerun the
																								// program
				answer = kb.next();// user answers
			} while (!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes"));

			repeat = answer.equalsIgnoreCase("yes");// repeats if user types yes
		} while (repeat); // repeat as long as the user wants to

	}

	/**
	 * Outputs a month on the calendar for a given year. Use the printTitle() and
	 * the printMonthBody() methods to do the actual printing
	 * 
	 * @param year  The year to print
	 * @param month The month to print
	 */
	public static void printMonth(int year, int month) {
		// call the method printTitle with the values year and month
		printMonthTitle(year, month);
		// call the method printMonthBody with the values year and month
		printMonthBody(year, month);
	}

	/**
	 * Prints the month name, a separator line and then the days of the week (Sun,
	 * Mon, ..., Sat)
	 * 
	 * @param year  The year of the month title to print.
	 * @param month The month to print.
	 */
	public static void printMonthTitle(int year, int month) {
		// output the title for each month of the year
		if (month == 1) {
			System.out.println("        January " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 2) {
			System.out.println("        Feburary " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 3) {
			System.out.println("        March " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 4) {
			System.out.println("        April " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 5) {
			System.out.println("        May " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 6) {
			System.out.println("        June " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 7) {
			System.out.println("        July " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 8) {
			System.out.println("        August " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 9) {
			System.out.println("        September " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 10) {
			System.out.println("        October " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 11) {
			System.out.println("        November " + year);//outputs 8 spaces + the month + the year
		}
		if (month == 12) {
			System.out.println("        December " + year);//outputs 8 spaces + the month + the year
		}
		System.out.println("----------------------------");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat ");

	}

	/**
	 * This method prints the body of the calendar for the given month by first
	 * determining the start day of the month (using the getStartDay() method) and
	 * then calling the print method to actually print the rest of the calendar.
	 * 
	 * @param year The year of the month to print
	 * @param The  month to print. (1 = January and 12 = December)
	 */
	public static void printMonthBody(int year, int month) {
		// call the method getStartDay to get the start day for the given month of
		// the year
		int StartDay = CalendarHelper.getStartDay(year, month);
		// call the method print to print the calendar for the month and pass
		// the first day of the month as the parameter
		print(StartDay, year, month);
		System.out.println();//next line

	}

	/**
	 * Prints the calendar for the given month.
	 * 
	 * @param startDay The day of the week that the month begins on. (0 = Sunday and
	 *                 6 = Saturday)
	 * @param year     The year of the month
	 * @param month    The month to print. (1 = January and 12 = December)
	 */
	public static void print(int startDay, int year, int month) {
		// call the method getNumberOfdaysInMonth to find out the number of the
		// days in the month
		CalendarHelper.getNumberOfDaysInMonth(year, month);
		// use a for loop to print spaces up to the start day for each month
		for (int i = 0; i < startDay + 1; i++) {// find the first day of the month(weekday)
			System.out.print("    ");// spaces before the first day

		}
		int md = CalendarHelper.getNumberOfDaysInMonth(year, month);// defines number of days
		for (int i = 1; i <= md; i++) {
			System.out.printf("%4d", i);//prints days

			if ((i + startDay + 1) % 7 == 0) {
				System.out.println();//organizes calendar
			}
		}
		System.out.println();
		if(month == 11) {//only if November
			int i = CalendarHelper.thanks(startDay);
			System.out.println("Thanksgiving will be on the " + i + "th day of November");//outputs thanksgiving day
		}
	
	}
}