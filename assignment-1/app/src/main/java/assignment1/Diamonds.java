package assignment1;

import java.util.Scanner;

/**
 * program to create an diamond of stars.
 */
public class Diamonds {
  /**
   * the main method.
   *
   * @param args unused argument.
   */
  public static void main(String[] args) {

    Scanner numb = new Scanner(System.in, "UTF-8");
    System.out.print("Give a positive number ");
    int anyNumber = numb.nextInt();

    if (anyNumber < 0) {
      System.out.println("it is not a positive number, enter a postive number ");
    } else {
      int i;
      int j;
      for (i = 0; i <= anyNumber; i++) {
        for (j = 1; j <= anyNumber - i; j++) {
          System.out.print(" ");
        }
        for (j = 1; j <= 2 * i - 1; j++) {
          System.out.print("*");
        }
        System.out.println("");
      }
      for (i = anyNumber - 1; i >= 1; i--) {
        for (j = 1; j <= anyNumber - i; j++) {
          System.out.print(" ");
        }
        for (j = 1; j <= 2 * i - 1; j++) {
          System.out.print("*");
        }
        System.out.println("");

      }
    }
    numb.close();
  }
}
