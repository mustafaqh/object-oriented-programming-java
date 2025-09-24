package assignment4.model.domain;

import java.util.ArrayList;

/**
 * class represents a registry for the solar system.
 */
public class SysRegistry {

  private ArrayList<SolarSys> systems = new ArrayList<>();
  private long planetMinOrbit = 57900000;
  private long planetMaxOrbit = 4500000000L;
  private long moonMinOrbit = 9378;
  private long moonMaxOrbit = 12952000;
  

  /**
   * method to check if the system is allready in the system,
   * if the sun is allready in the system.
   *
   * @param s String, name of the sun if the system we want to found.
   * @return boolean, true if the sun is found, false if sun is not found.
   */
  public boolean sysFound(String s) {
    for (int i = 0; i < systems.size(); i++) {
      if (systems.get(i).getStar().getName().toLowerCase().equals(s)) {
        return true;
      }
    }
    return false;
  }

  /**
   * method to add a new solar system to systems.
   *
   * @param s SolarSys, instance of SolarSys represents the new system to add.
   */
  public void addNewSystem(SolarSys s) {
    systems.add(s);
  }

  /**
   * method to remove a specifc solar system by the name of its Star.
   *
   * @param s String, name of the star of the solar system.
   * @return boolean, true if the system is deleted, false if not.
   */
  public boolean removeSys(String s) {
    for (SolarSys solar : systems) {
      if (solar.getStar().getName().toLowerCase().equals(s)) {
        systems.remove(solar);
        return true;
      }
    }
    return false;
  }

  /**
   * method provides read only of the elemnt of SolaSys.
   *
   * @return Iterable SolarSys, list of systems.
   */
  public Iterable<SolarSys> listTheSys() {
    return systems;
  }

  /**
   * method provides read only acceses for the elemnts of the moons.
   *
   * @param p Planet, instance of class planet.
   * @return Iterable Moon , list of moons.
   */
  public Iterable<Moon> listTheMoons(Planet p) {
    return p.getTheMoon();
  }

  /**
   * method provides read only acceses for the elemnts of the planets.
   *
   * @param s Star, instance of class Star.
   * @return Iterable Planet , list of planets.
   */
  public Iterable<Planet> listThePlanets(Star s) {
    return s.getThePlanets();
  }

  /**
   * method to check if the moon is in the system.
   *
   * @param p        PLanet, instance of class Planet.
   * @param moonName String, name of the moon to check.
   * @return Boolean, true if found, false if not.
   */
  public boolean moonFound(Planet p, String moonName) {
    for (Moon m : listTheMoons(p)) {
      if (m.getName().equals(moonName)) {
        return true;
      }
    }
    return false;
  }

  /**
   * method to get the planet by its name.
   *
   * @param s    String, name of the planet.
   * @param star Star, instance of the Star class.
   * @return Planet, planet if it found, else it return null.
   */
  public Planet getPlanetByName(String s, Star star) {
    for (Planet p : star.getThePlanets()) {
      if (p.getName().toLowerCase().equals(s)) {
        return p;
      }
    }
    return null;
  }

  /**
   * method to get a star by its name.
   *
   * @param s String, name of the star.
   * @return Star, the star if it found, null if it is not found.
   */
  public Star getSolarSys(String s) {
    for (int i = 0; i < systems.size(); i++) {
      if (systems.get(i).getStar().getName().toLowerCase().equals(s)) {
        return systems.get(i).getStar();
      }
    }
    return null;
  }

  /**
   * method to get the moon by its name.
   *
   * @param s String, name of the moon.
   * @param p Planet, instance of class Planet.
   * @return Moon, moon if it is found or null if it is not.
   */
  public Moon getMoonByName(String s, Planet p) {
    for (Moon m : p.getTheMoon()) {
      if (m.getName().equals(s)) {
        return m;
      }
    }
    return null;
  }

  /**
   * method to get moon info as String.
   *
   * @param m Moon,instance of class Moon represents a specific moon.
   * @return Srtring, moon info.
   */
  public String getMoonInfo(Moon m) {
    return m.toString();
  }

  /**
   * method to get planet info as String.
   *
   * @param p Planet, instance of clas Planet represents a specific planet.
   * @return String, planet info.
   */
  public String getPlanetInfo(Planet p) {
    return p.toString();
  }

  /**
   * method to get star info as String.
   *
   * @param s Star, instance of class Star represents a specific star.
   * @return String, star info.
   */
  public String getStarInfo(Star s) {
    return s.toString();
  }

  /**
   * method to prepare the data before write it to the file.
   *
   * @return String, the data as String.
   */
  public String writeToFile() {
    StringBuilder bld = new StringBuilder();
    for (SolarSys sys : systems) {
      Star star = sys.getStar();
      bld.append(star.toString() + "\n");
      for (Planet p : star.getThePlanets()) {
        bld.append(p.toString() + "\n");
        for (Moon m : p.getTheMoon()) {
          bld.append(m.toString() + "\n");
        }
      }
    }
    return bld.toString();
  }

  /**
   * method to check if the planet orbiting raduis is valid.
   *
   * @param orbitingRadius long a specific orbiting raduis to to check.
   * @return boolean, true if it valid, false if it is not
   */
  public boolean validPlanetOrbit(long orbitingRadius) {
    return (orbitingRadius >= planetMinOrbit && orbitingRadius <= planetMaxOrbit);
  }

  /**
   * method to check if the planet orbiting raduis is valid.
   *
   * @param orbitingRadius long a specific orbiting raduis to to check.
   * @return boolean, true if it valid, false if it is not
   */
  public boolean validMoonOrbit(long orbitingRadius) {
    return (orbitingRadius >= moonMinOrbit && orbitingRadius <= moonMaxOrbit);
  }

}
