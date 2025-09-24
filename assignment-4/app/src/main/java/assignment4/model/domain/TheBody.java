package assignment4.model.domain;

/**
 * abstract class that represents the space body, it can be star, palnet, or
 * moon.
 */
public abstract class TheBody {
  private String name;
  private long avgRaduis;

  protected TheBody(String n, long avgR) {
    this.name = n;
    this.avgRaduis = avgR;
  }

  public String getName() {
    return name;
  }

  /**
   * sitter to set the name to the body.
   *
   * @param name String, name of the body.
   */
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("You should enter Name !");
    }
    this.name = name;
  }

  public long getAvgRadius() {
    return avgRaduis;
  }

  public void setAvgRadius(long avgRaduis) {
    this.avgRaduis = avgRaduis;
  }

  

  public abstract String toString();
}
