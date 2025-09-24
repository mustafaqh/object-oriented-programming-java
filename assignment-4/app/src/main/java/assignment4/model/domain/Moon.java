package assignment4.model.domain;

/**
 * class represents the moon of the solar system.
 */
public class Moon extends TheBody {
  private long avgOrbitRad; // average orbiting radius.

  /**
   * public constructor of the Moon class.
   *
   * @param n           String, name of the moon.
   * @param avgR        long, avg raduis of the moon.
   * @param avgOrbitRad long, average orbiting radius.
   */
  public Moon(String n, long avgR, long avgOrbitRad) {
    super(n, avgR);
    this.avgOrbitRad = avgOrbitRad;
  }

  /**
   * getter method to get the average orbiting radius.
   *
   * @return long, the average orbiting radius.
   */
  public long getAvgOrbitRad() {
    return avgOrbitRad;
  }

  /**
   * setter method to set vaverage orbiting radius.
   *
   * @param avgOrbitRad long, average orbiting radius.
   */
  public void setAvgOrbitRad(long avgOrbitRad) {
    this.avgOrbitRad = avgOrbitRad;
  }


  
  /**
   * abstarct method return String contain moon name and its radis and its orbit radius as String.
   */
  @Override
  public String toString() {
    return "--" + super.getName() + ":" + super.getAvgRadius() + ":" + this.getAvgOrbitRad();
  }

}
