package assignment1;

import java.util.Random;
import java.util.Scanner;

/**
 * code for task two.
 */
public class Nine {
  /**
   * program which simulate a simple roll game .
   *
   * @param args .
   */
  public static void main(String[] args) {

    Random rnd = new Random();
    Scanner scan = new Scanner(System.in, "UTF-8");

    System.out.println("playing a game");
    System.out.println("================\n");
    System.out.print("Ready to play? (Y/N)");

    char choice1 = scan.next().charAt(0);
    if (choice1 == 'n' || choice1 == 'N') {
      System.out.println("okey..! bye..");
    } else if (choice1 == 'y' || choice1 == 'Y') {
      int sum = 0;
      int roll2;
      int comRoll2;
      
      int roll1 = rnd.nextInt(6) + 1;
      sum = sum + roll1;
      

      System.out.println("You rolled " + sum);
      System.out.print("Would you like to roll again? (Y/N)");
      
      char choice2 = scan.next().charAt(0);

      if (choice2 == 'y' || choice2 == 'Y') {
        
        roll2 = rnd.nextInt(6) + 1;
        sum = sum + roll2;
        System.out.println("You rolled " + roll2 + " and in total you have " + sum);
      }
     
      int comSum = 0;
      int comRoll1 = rnd.nextInt(6) + 1;
      comSum = comSum + comRoll1;
      System.out.println("The computer rolled " + comSum);
      
      if (comRoll1 <= 4) {
        comRoll2 = rnd.nextInt(6) + 1;
        comSum = comSum + comRoll2;
        System.out.println("The computer rolls again and gets " + comRoll2 +  " in total " + comSum);
      }

      if (sum > comSum) {
        if (sum >= 10) {
          System.out.println("\"fat\" you lose..! ");
        } else {
          System.out.println("You win..!");
        }
      } else if (sum < comSum) {
        if (comSum >= 10) {
          System.out.println("\"computer is fat\" you win..!");
        } else {
          System.out.println("you lose..!");
        }
      }
    }
    scan.close();
  }

}
