package assignment1;

import java.util.Random;

/**
 * static function to check if ant visited all or not.
 */

public class Ants {
  static Random rand = new Random();


  public static boolean coveredAllBoard(int[][] chess) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (chess[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   *  main function start.
   *
   * @param args unused argument.
   */
  //
  public static void main(String[] args) {
    // print header

    System.out.println("Ants");
    System.out.println("========\n");
    // store average number of steps
    double averageSteps = 0;
    // loop 10 times
    for (int simulation = 1; simulation <= 10; simulation++) {
      // create new chess board
      int[][] chess = new int[8][8];
      // reset board
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          chess[i][j] = 0;
        }
      }

      // generate random number to put ant on board
      int startingLocX = rand.nextInt(8);
      int startingLocY = rand.nextInt(8);
      // set location to 1
      chess[startingLocX][startingLocY] = 1;
      // store number of steps
      int step = 0;

      // while loop is not break
      while (!coveredAllBoard(chess)) {
        // move ant to any location
        int move = rand.nextInt(4);
        // decide which side ant move
        if (move == 0) {
          if (startingLocX > 0) {
            startingLocX--;
            step++;
          }
        } else if (move == 1) {
          if (startingLocX < 7) {
            startingLocX++;
            step++;
          }
        } else if (move == 2) {
          if (startingLocY > 0) {
            startingLocY--;
            step++;
          }
        } else if (move == 3) {
          if (startingLocY < 7) {
            startingLocY++;
            step++;
          }
        }
        chess[startingLocX][startingLocY] = 1;
      }
      averageSteps += step;
      System.out.println("Number of steps in simulation " + simulation + " : " + step);
    }
    System.out.println("Average amount of steps : " + averageSteps / 10);
  }
}
