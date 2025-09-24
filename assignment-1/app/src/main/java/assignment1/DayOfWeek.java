package assignment1;

import java.util.Scanner;

/**
 * program that asks for a day and prints the name of that day. 
 */
public class DayOfWeek {
  /**
   * the main method.
   *
   * @param args .
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "UTF-8");
    System.out.print("Enter year: ");
    int year = scan.nextInt();
    System.out.print("Enter month (1-12): ");
    int m = scan.nextInt(); // scanning the month number.
    System.out.print("Enter the day of the month (1-31): ");
    int q = scan.nextInt(); // scanning the day number.
    int weekDay;

    // January and February are counted as months 13 and 14 for the previous year
    if (m == 1 || m == 2) {
      m = m + 12;
      year = year - 1;
    }

    int j = year / 100;
    int k = year % 100;

    weekDay = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
    String s = "";
    switch (weekDay) {
      case 0:
        s = "Saturday";
        break;
      case 1:
        s = "Sunday";
        break;
      case 2:
        s = "Monday";
        break;
      case 3:
        s = "Tuesday";
        break;
      case 4:
        s = "Wednesday";
        break;
      case 5:
        s = "Thrusday";
        break;
      case 6:
        s = "Friday";
        break;
      default:
        break;

    }
    System.out.println("The day of the week is " + s);

    scan.close();
  }

}
