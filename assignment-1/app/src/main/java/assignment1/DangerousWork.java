package assignment1;

import java.util.Scanner;

/**
 * code for task three.
 */
public class DangerousWork {
  /**
   * program which calculate the minimum number of days you need to work to earn a specific amount.
   *
   * @param args unused argument.
   */
  public static void main(String[] args) {
    int counter = 1;
    Scanner scan = new Scanner(System.in);
    
    System.out.print("How much would you like to earn? ");
    
    float theMoney = scan.nextFloat();
    while (theMoney > 0.01) {
      theMoney = theMoney / 2;
      counter++;
    }
    
    if (theMoney != 0.01) {
      counter = counter - 1;
    }
    
    if (counter >= 30) {
      System.out.println("You won't survive");
    } else {
      
      System.out.printf("You will have your money in %d days.", counter);
    }
    scan.close();
  }

}
