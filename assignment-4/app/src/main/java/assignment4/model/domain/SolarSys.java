package assignment4.model.domain;

/**
 * class that reprsent a solar system.
 */
public class SolarSys {
  private Star star; // The star of the solar system.

  /**
   * constructor of the solar system calss.
   *
   * @param s Star, the star of the solar system.
   */
  public SolarSys(Star s) {
    this.star = s;
  }

  /**
   * getter method to get the star of solar system.
   *
   * @return Start, instance of class star represent the star of a system.
   */
  public Star getStar() {
    return star;
  }

  /**
   * setter method to get the star of solar system.
   *
   * @param star Start, instance of class star represent the star of a system.
   */
  public void setStar(Star star) {
    this.star = star;
  }

  
}
