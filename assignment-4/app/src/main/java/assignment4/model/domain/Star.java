package assignment4.model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;



/**
 * class reprsent the star of each solar system, it extends TheBody class.
 */
public class Star extends TheBody {
  // array list of all planets of a solar system.
  private ArrayList<Planet> thePlanets = new ArrayList<>();
  // array list of all planets of a solar system.

  /**
   * constructor of class star.
   *
   * @param n    String, name of the star.
   * @param avgR long, the avg radius of a star.
   */
  public Star(String n, long avgR) {
    super(n, avgR);
  }

  /**
   * method to read only the planets, "get the planets in array list planets".
   *
   * @return Iterable Planet , read only.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We want this.")
  public Iterable<Planet> getThePlanets() {
    return thePlanets;
  }

  /**
   * method to add a planet to the solar system of a star.
   *
   * @param planet Planet, instace of class planet to add to the star.
   */
  public void addPlanet(Planet planet) {
    thePlanets.add(planet);
  }

  /**
   * method to remove planet of a solar system if a specific star.
   *
   * @param planet Planet, instance of class planet represents specific planet.
   */
  public void removePlanet(Planet planet) {
    thePlanets.remove(planet);
  }

  /**
   * method to delete all the planets of the star.
   */
  public void deleteAllPlanets() {
    thePlanets.clear();
  }

  /**
   * method to sort the planets according to their size.
   */
  public void sortBySize() {
    thePlanets.sort((Planet p1, Planet p2) -> Double.compare(p1.getAvgRadius(), p2.getAvgRadius()));
  }

  /**
   * method to sort the planets according to their orbital radius.
   */
  public void sortByOrbitalRad() {
    thePlanets.sort((Planet p1, Planet p2) 
          -> Double.compare(p1.getAvgOrbitRad(), p2.getAvgOrbitRad()));
  }

  /**
   * abstract method return star name and avg radius as String.
   */
  @Override
  public String toString() {
    return super.getName() + ":" + super.getAvgRadius();
  }
}
