package assignment4.model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;




/**
 * represents the planets of the solar system and it extends the TheBody class.
 */
public class Planet extends TheBody {
  private long avgOrbitRad; // average orbiting radius.

  private ArrayList<Moon> theMoons = new ArrayList<>();

  /**
   * public constructor of Planet class.
   *
   * @param n           String, name of the planet.
   * @param avgR        long, avg radius of the plant.
   * @param avgOrbitRad long, average orbiting radius.
   */
  public Planet(String n, long avgR, long avgOrbitRad) {
    super(n, avgR);
    this.avgOrbitRad = avgOrbitRad;
  }

  /**
   * getter method to get average orbiting radius.
   *
   * @return long, average orbiting radius.
   */
  public long getAvgOrbitRad() {
    return avgOrbitRad;
  }

  /**
   * setter method to set average orbiting radius.
   *
   * @param avgOrbitRad long, average orbiting radius.
   */
  public void setAvgOrbitRad(long avgOrbitRad) {
    this.avgOrbitRad = avgOrbitRad;
  }

  /**
   * public method add a new moon to planet.
   *
   * @param m Moon, instance of a class moon represent a specific moon.
   */
  public void addMoon(Moon m) {
    theMoons.add(m);
  }

  /**
   * public method to remoove a moon from the moons of a planet.
   *
   * @param m Moon, instance of a class moon represent a specific moon.
   */
  public void removeMoon(Moon m) {
    theMoons.remove(m);
  }

  /**
   * method provides read only of the elemnt of moons array lsit.
   *
   * @return Iterable Moon , list of moons.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We want this.")
  public Iterable<Moon> getTheMoon() {
    return theMoons;
  }

  /**
   * method to delete all the moons of the planets.
   */
  public void deleteAllMoons() {
    theMoons.clear();
  }

  /**
   * method to sort the moons according to their size.
   */
  public void sortBySize() {
    theMoons.sort((Moon m1, Moon m2) -> Double.compare(m1.getAvgRadius(), m2.getAvgRadius()));
  }

  /**
   * method to sort the moons according to their orbital radius.
   */
  public void sortByOrbitalRad() {
    theMoons.sort((Moon m1, Moon m2) -> Double.compare(m1.getAvgOrbitRad(), m2.getAvgOrbitRad()));
  }

  /**
   * abstract method return planet name, avg radius, and avg orbit radius as String.
   */
  @Override
  public String toString() {
    return "-" + super.getName() + ":" + super.getAvgRadius() + ":" + this.getAvgOrbitRad();
  }
}
