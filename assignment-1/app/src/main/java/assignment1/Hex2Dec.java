package assignment1;

import java.util.Scanner;

/**
 * code for task 8.
 */
public class Hex2Dec {

  /**
   *  method that returns the deciaml value for a string containing a hexadecimal value.
   *
   * @param hex argument for a string containing a hexadecimal value. 
   * @return returns the deciaml value.
   */
  public static int hexToDecimal(String hex) {
    hex = hex.toLowerCase();
    int result = 0; 
    int temp = 1;
    for (int i = hex.length() - 1; i >= 0; i--) {
      char ch = hex.charAt(i);
      if (ch >= '0' && ch <= '9') {
        result = result + (ch - '0') * temp;
      } else if (ch == 'a') {
        result = result + temp * 10;
      } else if (ch == 'b') {
        result = result + temp * 11;
      } else if (ch == 'c') {
        result = result + temp * 12;
      } else if (ch == 'd') {
        result = result + temp * 13;
      } else if (ch == 'e') {
        result = result + temp * 14;
      } else if (ch == 'f') {
        result = result + temp * 15;
      }
      temp = temp * 16;
    }
    return result;
  }

  /**
   * the main method.
   *
   * @param args unused argument.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in, "UTF-8");
    System.out.print("Enter a hex number: ");
    String hex = scanner.nextLine();
    System.out.println("The decimal value for " + hex + " is " + hexToDecimal(hex) + ".");
    scanner.close();
  }
}
