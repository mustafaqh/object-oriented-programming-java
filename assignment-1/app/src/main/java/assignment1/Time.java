package assignment1;


import java.util.Scanner;


/**
 * code for task 1.
 */
public class Time {
  /**
   * programs which reads a number of seconds and,
   *  prints the same amount of time given in hours, minutes and seconds.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "UTF-8");
    System.out.print("Give a number of seconds : ");
    int number = scan.nextInt();
    int hour = number / 3600;
    int rest = number % 3600;
    int minut = rest / 60;
    int seconds = rest & 60;

    System.out.println(
        "This corresponds to: " + hour + "  hours " + minut + "  minutes " + seconds + " secondes");
    scan.close();
  }

}
