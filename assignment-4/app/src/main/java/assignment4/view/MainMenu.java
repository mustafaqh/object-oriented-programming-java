package assignment4.view;

import assignment4.model.domain.Moon;
import assignment4.model.domain.Planet;
import assignment4.model.domain.SolarSys;
import assignment4.model.domain.Star;
import assignment4.model.domain.SysRegistry;
import java.util.Scanner;

/**
 * class for the main menu of the program.
 */
public class MainMenu {
  private String size = "size";
  private String orbit = "orbit";
  private Scanner scan = new Scanner(System.in);

  /**
   * represents the alternatives of the main menu.
   */
  public enum TheMainMenu {
    /**
     * alternative of the main menu.
     */
    CREATE,
    LIST,
    DELETE,
    EXIT
  }

  /**
   * represents the alternatives of the create sub menu.
   */
  public enum CreateSubMenu {
    /**
     * alternative of what to create.
     */
    SOLAR,
    PLANET,
    MOON,
    EXIT
  }

  /**
   * represents the alternatives of the listing sub menu.
   */
  public enum ListingMenu {
    /**
     * alternative of what to list.
     */
    LISTALL,
    LISTD_EATAILS_ORDED_BY_SIZE,
    LIST_DEATAILS_ORDED_BY_ORBET,
    EXIT
  }

  /**
   * represents the alternatives of the deleting sub menu.
   */
  public enum DeleteSubMenu {
    /**
     * alternative of what to delete.
     */
    SOLAR,
    PLANET,
    MOON,
    EXIT
  }

  /**
   * method to manage the main menu and recive the user input.
   *
   * @return one of mainMenu values.
   */
  public TheMainMenu theMainMenu() {
    System.out.println("welcome to solar system app");
    System.out.println("Chose alternatove to start: (\'enter the alternative number\')");
    System.out.println("1. Show creating list.");
    System.out.println("2. Show informations.");
    System.out.println("3. Show delete list.");
    System.out.println("4. Quit the application." + "\n");


    String alt = scan.nextLine().toLowerCase();

    if (alt.equals("1")) {
      return TheMainMenu.CREATE;
    }
    if (alt.equals("2")) {
      return TheMainMenu.LIST;
    }
    if (alt.equals("3")) {
      return TheMainMenu.DELETE;
    }

    System.out.println("Bye Bye");
    return TheMainMenu.EXIT;
    
  }

  /**
   * method to manage the creating sub menu and recive the user input.
   *
   * @return one of createSubMenu values.
   */
  public CreateSubMenu creatMenu() {
    System.out.println("what do yoy want to create: (\'enter the alternative number\')");
    System.out.println("1. Create Solar System(create a star)");
    System.out.println("2. Creaete a new planet (add new planet to a star)");
    System.out.println("3. Create a new moon (add a moon to planet)");
    System.out.println("Enter any thing else to go back to main menu." + "\n");
    
    String alt = scan.nextLine().toLowerCase();

    if (alt.equals("1")) {
      return CreateSubMenu.SOLAR;
    }
    if (alt.equals("2")) {
      return CreateSubMenu.PLANET;
    }
    if (alt.equals("3")) {
      return CreateSubMenu.MOON;
    }
    return CreateSubMenu.EXIT;
  }

  /**
   * metjoid to manage the information sub menu and rrecive the user inpt.
   *
   * @return one of listingMenu vlues.
   */
  public ListingMenu inforamtionSubMenu() {
    System.out.println("Enter the alternative number.");
    System.out.println("1. List all solar systems.");
    System.out.println("2. See detailed information about particular solar system orded by SIZE.");
    System.out.println("3. See detailed information about "
        + "particular solar system orded by ORBITAL RADUIS.");
    System.out.println("Enter any thing else to go back to main menu." + "\n");

    
    String alt = scan.nextLine().toLowerCase();

    if (alt.equals("1")) {
      return ListingMenu.LISTALL;
    }
    if (alt.equals("2")) {
      return ListingMenu.LISTD_EATAILS_ORDED_BY_SIZE;
    }
    if (alt.equals("3")) {
      return ListingMenu.LIST_DEATAILS_ORDED_BY_ORBET;
    }

    return ListingMenu.EXIT;

  }

  /**
   * method to print out the deleting sub menu.
   */
  public DeleteSubMenu deletingSubMenu() {
    System.out.println("what do you want to delete: (\'enter the alternative number\')");
    System.out.println("1. delete A Star");
    System.out.println("2. delete A planet");
    System.out.println("3. delete A moon.");
    System.out.println("Enter any thing else to go back to main menu. " + "\n");
    
 
    String alt = scan.nextLine().toLowerCase();

    if (alt.equals("1")) {
      return DeleteSubMenu.SOLAR;
    }
    if (alt.equals("2")) {
      return DeleteSubMenu.PLANET;
    }
    if (alt.equals("3")) {
      return DeleteSubMenu.MOON;
    }

    return DeleteSubMenu.EXIT;
  }

  /**
   * method to print the all solar systems in the system.
   */
  public void listTheSystems(SysRegistry reg) {
    System.out.println("THE SOLAR SYSTEMS:");
    int i = 1;
    for (SolarSys sys : reg.listTheSys()) {
      Star star = sys.getStar();
      System.out.println((i) + "." + star.getName());
      i++;
    }
  }

  /**
   * method to print the info of aspecific moon.
   *
   * @param m Moon, instance of a specific Moon.
   */
  public void printMoonInfo(Moon m, SysRegistry reg) {
    System.out.println(reg.getMoonInfo(m));
  }

  /**
   * method to print the info of a planet and it calls another method to print the
   * moon of this planet while the moons are sorted by their size.
   *
   * @param p Planet, instance of class Moon, represents a specific planet.
   */
  public void printPlanetInfoBySize(Planet p, SysRegistry reg) {
    System.out.println(p.toString());
    p.sortBySize();
    for (Moon m : reg.listTheMoons(p)) {
      printMoonInfo(m, reg);
    }
  }

  /**
   * method to print the info of a planet and it calls another method to print the
   * moon of this planet while the moons are sorted by their avg orbit raduis.
   *
   * @param p Planet, instance of class Moon, represents a specific planet.
   */
  public void printPlanetInfoByorbit(Planet p, SysRegistry reg) {
    System.out.println(p.toString());
    p.sortByOrbitalRad();
    for (Moon m : reg.listTheMoons(p)) {
      printMoonInfo(m, reg);
    }
  }

  /**
   * method to print inforamtion of the star of the system and it calls method to
   * print the planet of the system orded by size.
   *
   * @param sys SolarSys, instance of solar system class.
   */
  public void printSysInfo(SolarSys sys, String s, SysRegistry reg) {
    Star theStar = sys.getStar();
    System.out.println(theStar.toString());
    Iterable<Planet> planets = reg.listThePlanets(theStar);
    if (planets == null) {
      System.out.println("no planets found to show their information");
      return;
    }
    for (Planet p : planets) {
      if (s.equals(size)) {
        printPlanetInfoBySize(p, reg);
      } else if (s.equals(orbit)) {
        printPlanetInfoByorbit(p, reg);
      }

    }

  }

  /**
   * method to print the info of apesific system choosen by user.
   *
   * @param s String, to decide the way of sorting according size or orbital
   *          raduis if s equal orbit sorting will be accordig orbital raduis if
   *          it equals size sorting is according size I USED S TO AVOID DUPLICATE
   *          THE CODE.
   */
  public void listDeatails(String s, SysRegistry reg) {
    System.out.println("enter the name of the solar system: \"Name of the STAR\" ");

    String starName = scan.nextLine().toLowerCase();
   
    if (!reg.sysFound(starName)) {
      System.out.println("System is NOT found..!");
    } else {
      for (SolarSys sys : reg.listTheSys()) {
        Star star = sys.getStar();
        if (!star.getName().toLowerCase().equals(starName)) {
          continue;
        }
        if (s.equals(size)) {
          printSysInfo(sys, size, reg);
        } else if (s.equals(orbit)) {
          printSysInfo(sys, orbit, reg);
        }

      }
    }

  }

  /**
   * method to delete a moon by finding its solar system and its planet.
   */
  public void deletMoon(SysRegistry reg) {

    System.out.println("enter the name of the star of the solar system that the moon is in");
    
    String starName = scan.nextLine().toLowerCase();

    if (reg.getSolarSys(starName) == null) {

      System.out.println("Solar system(Star) is not found...!");

    } else {

      System.out.println("enter the name of  planet that the moon orbits.");
      String planetName = scan.nextLine().toLowerCase();
      Star star = reg.getSolarSys(starName);
      Planet planet = reg.getPlanetByName(planetName, star);

      if (planet == null) {

        System.out.println("planet is not found...!");

      } else {

        System.out.println("Enter the name of the moon you want to delete.");
        String moonName = scan.nextLine();
        
        Moon moon = reg.getMoonByName(moonName, planet);

        if (moon == null) {

          System.out.println("moon is not found");

        } else {

          planet.removeMoon(moon);
          System.out.println("moon was deleted.");

        }
      }
    }
  }

  /**
   * method to delete a sepecific plan by its name.
   */
  public void deletePlanet(SysRegistry reg) {

    System.out.println("WARNING: by deletenig a planet to delete all its stars.");
    System.out.println("enter the name of the star that the planet orbits.");
    String starName = scan.nextLine().toLowerCase();

    if (reg.getSolarSys(starName) == null) {

      System.out.println("the solar system (STAR) is not found");

    } else {

      System.out.println("enter name of the planet to delete.");
      String planetName = scan.nextLine();
      
      Planet planet = reg.getPlanetByName(planetName, reg.getSolarSys(starName));

      if (planet == null) {

        System.out.println("the Planet is NOT FOUND");

      } else {

        planet.deleteAllMoons();
        reg.getSolarSys(starName).removePlanet(planet);
        System.out.println("the planet and its moons have been deleted.");

      }
    }
  }

  /**
   * method to delete a star(solar system.)
   */
  public void deleteStar(SysRegistry reg) {

    System.out.println("WARNING: by deleting a star you dfelete its all solar system.");
    System.out.println("enter the name of the star to delete.");
    
    String starName = scan.nextLine().toLowerCase();
    

    if (reg.getSolarSys(starName) == null) {

      System.out.println("the solar system (STAR) is not found");

    } else {

      for (Planet p : reg.getSolarSys(starName).getThePlanets()) {
        p.deleteAllMoons();
      }

      reg.getSolarSys(starName).deleteAllPlanets();

      if (reg.removeSys(starName)) {
        System.out.println("the entire solar system has been deleted");
      } else {
        System.out.println("somthing went wrong the solar has been not deleted.");
      }
    
    }
  }

  /**
   * method to create a moon and it to the desired planet in a specific solar
   * System.
   */
  public void createNewMoon(SysRegistry reg) {
    System.out.println("Eneter the name of the Solar system you want add the Moon to.");
    
    String sysName = scan.nextLine().toLowerCase();
    if (reg.getSolarSys(sysName) == null) {
      System.out.println("System is not found");
    } else {
      System.out.println("enter the name of the planet you want add planet to.");
      String planetName = scan.nextLine().toLowerCase();
      if (reg.getPlanetByName(planetName, reg.getSolarSys(sysName)) == null) {
        System.out.println("Planet is not found");
      } else {
        System.out.println("Enter the name of the Moon");
        String moonName = scan.nextLine().toLowerCase();
        System.out.println("Enter the avg raduis of the moon");
        long avgRaduis = scan.nextLong();
        System.out.println("enter the Avg orbit raduis of the moon");
        long avgOrbitRad = scan.nextLong();
        if (!reg.validMoonOrbit(avgOrbitRad)) {
          System.out.println("please inter a valid vlue..!");
        } else {
          Moon m = new Moon(moonName, avgRaduis, avgOrbitRad);
          reg.getPlanetByName(planetName, reg.getSolarSys(sysName)).addMoon(m);
         
          System.out.println("the moon has been added.");
        }
      }
    }
  }

  /**
   * method to create new Planet and add it to a desired solar system.
   */
  public void createnewPlanet(SysRegistry reg) {
    System.out.println("Eneter the name of the Solar system you want add the Planet to.");
    
    String sysName = scan.nextLine().toLowerCase();
    if (reg.getSolarSys(sysName) == null) {
      System.out.println("System is not found");
    } else {
      System.out.println("Enter the name of the planet");
      String planetNmae = scan.nextLine().toLowerCase();
      System.out.println("Enter the avg raduis of the planet");
      long avgRaduis = scan.nextLong();
      System.out.println("enter the Avg orbit raduis of the planet");
      long avgOrbitRad = scan.nextLong();
      if (!reg.validPlanetOrbit(avgOrbitRad)) {
        System.out.println("please inte a valid orbital radius..!");
      } else {
        Planet p = new Planet(planetNmae, avgRaduis, avgOrbitRad);
        reg.getSolarSys(sysName).addPlanet(p);
        System.out.println("the planet has been add");
        
      }

    }
  }

  /**
   * method to create new Star wich create a new system.
   */
  public void createNewStar(SysRegistry reg) {
    System.out.println("\n" + "enter the name of the Star." + "\n");

    String starName = scan.nextLine();
    System.out.println("enter the avg radius of the Star " + starName);
    long avgRaduis = scan.nextLong();
    Star s = new Star(starName, avgRaduis);
    SolarSys ss = new SolarSys(s);
    reg.addNewSystem(ss);
    
    System.out.println("#################################################");
    System.out.println("\n" + "Star and solar system are created.." + "\n");
    System.out.println("#################################################");
  }
  
  /**
   * method to print the error msg.
   *
   * @param e Exception.
   */
  public void errorPrinter(Exception e) {
    System.out.println("ERROR MESSAGE : " + e);
  }
  
}
