package assignment1;

import java.util.Scanner;


/**
 * code for uupgift print calander.
 */
public class PrintCalander {

  public int enteredYear(Scanner scan) {
    int year = scan.nextInt();
    return year;
  }

  public int enteredMonth(Scanner scan) {
    int month = scan.nextInt();
    return month;
  }

  /**
   * method to determain leapyear.
   *
   * @param startYear counter for year start at 1.
   * @param d array contain the nuber of days for each month.
   */
  public void leapYear(int startYear, int[] d) {
    if (((startYear % 4 == 0) && (startYear % 100 != 0)) 
        || (startYear % 100 == 0)) {
      d[1] = 29;
    } else {
      d[1] = 28;
    }
  }


  /**
   * method to get month's name.
   *
   * @param month number o the month entedrd by the users.
   * @return name of the month.
   */
  public String getMonthName(int month) {
    switch (month) {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        return "not a logic number";
    }
  }

  /**
   * method tho intalize the calander.
   *
   * @param month month enterd by the user.
   * @param year  year enterd by the user.
   * @param months array that contain names of the monthes.
   */
  public void instalization(int month, int year, String[] months) {
    
    int startDay = 1;
    int startMonth = 1;
    int startYear = 1; 
    int weDay = 2;

   
    int[] d = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    
    while (true) {
      
      if (startDay == 1 && startMonth == month && startYear == year) {
        break;
      }
      
      leapYear(startYear, d);

      weDay++;
      startDay++;
      
      if (startDay > d[startMonth - 1]) {
        
        startMonth++;
  
        startDay = 1;
      }

      
      if (startMonth > 12) {
        
        startMonth = 1;
        
        startYear++;
      }
      if (weDay == 7) {
        weDay = 0;
      }
      
    }

    int space = weDay;
    
    for (int i = 1; i <= (d[month - 1] + weDay); i++) {
      if (i > 6) {
        weDay = weDay % 6;
      }
    }

    if (space < 0) {
      space = 6;
    }
    
    for (int j = 0; j < space; j++) {
      System.out.print("      ");
    }
    for (int k = 1; k <= d[month - 1]; k++) {
      System.out.printf(" %4d ", k);
      
      if (((k + space) % 7 == 0) || (k == d[month - 1])) {
        System.out.println();
      }
    }
  }

  /**
   * method to print calander.
   *
   * @param day day's name
   * @param monthName month's name.
   * @param year enterd by user.
   */
  public void printHeader(String[] day, String monthName, int year) {
    System.out.println("   " + monthName + "  " + (year + 1800));
    for (int nr = 0; nr <= 6; nr++) {
      System.out.print("   " + day[nr]);
    }
    System.out.println("\n   ---------------------------------------");
  }


  /**
   * the main methods.
   *
   * @param args unused argument.
   */
  public static void main(String[] args) {

    String[] months = { "January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December" };

    String[] day = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    Scanner scan = new Scanner(System.in, "utf-8");
    PrintCalander theCalander = new PrintCalander();

    System.out.print("Enter a year after 1800: ");
    int year = theCalander.enteredYear(scan);
    

    System.out.print("Enter a month (1-12): ");
    int monthNumber = theCalander.enteredMonth(scan);

    if (year < 1800) {
      System.out.println("Enter vaild year ...! clander starts at 1800");
    } else {
      year = year - 1800;
      String monthName = theCalander.getMonthName(monthNumber);
      theCalander.printHeader(day, monthName, year);
      theCalander.instalization(monthNumber, year, months);
    }

    

    scan.close();
  }

}
