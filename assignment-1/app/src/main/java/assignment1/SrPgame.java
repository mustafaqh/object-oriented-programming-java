package assignment1;

import java.util.Random;
import java.util.Scanner;

/**
 * code for task five.
 */
public class SrPgame {

  /**
   * program forscissor-rock-paper game.
   *
   * @param args unused argument.
   */
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in, "UTF-8");
    Random rnd = new Random();
    int draw = 0;
    int playerScore = 0;
    int compScore = 0;

    while (true) {
      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");

      int input = scan.nextInt();

      int comp = rnd.nextInt(3) + 1;
      if (input == 1 && comp == 1) {
        System.out.println("It's a draw!");
        draw++;
      } else if (input == 1 && comp == 2) {
        System.out.println("You lost, computer had rock!");
        compScore++;
      } else if (input == 1 && comp == 3) {
        System.out.println("You won, computer had paper!");
        playerScore++;
      } else if (input == 2 && comp == 1) {
        System.out.println("You won, computer had Scissor!");
        playerScore++;
      } else if (input == 2 && comp == 2) {
        System.out.println("It's a draw!");
        draw++;
      } else if (input == 2 && comp == 3) {
        System.out.println("You, computer had paper!");
        compScore++;
      } else if (input == 3 && comp == 1) {
        System.out.println("You lost, computer had Scissor!");
        compScore++;
      } else if (input == 3 && comp == 2) {
        System.out.println("You won, computer had rock!");
        playerScore++;
      } else if (input == 3 && comp == 3) {
        System.out.println("It's a draw!");
        draw++;
      } else if (input == 0) {
        System.out.println("Score: " + playerScore + " (you) " + compScore + " (computer) " + draw + " (draw). ");
        break;
      } else {
        System.out.println("Invaild choise");
      }

    }
    scan.close();
  }

}
