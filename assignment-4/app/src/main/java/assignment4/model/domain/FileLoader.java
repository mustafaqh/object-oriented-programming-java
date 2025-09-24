package assignment4.model.domain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * class to manage reading and writing to the file.
 */
public class FileLoader {
  
  /**
   *  method to read the data from a file.
   *
   * @param reg SysRegistry, instace  of class SysRegistry.
   */
  public void fileReader(SysRegistry reg) {
    String[] data;
    Star star = null;
    Planet planet = null;
    Moon moon = null;

    try (Scanner scan = new Scanner(new File("solarsystems.data"), Charset.defaultCharset())) {
      String s = "";
      while (scan.hasNextLine()) {
        s = scan.nextLine();

        if (s.trim().length() == 0) {
          continue;
        }
        data = s.split(":");
        char c = '-';

        if (!data[0].startsWith("-")) {
          int x = Integer.parseInt(data[1]);
          star = new Star(data[0], x);
          SolarSys sys = new SolarSys(star);
          reg.addNewSystem(sys); 

        } else if (data[0].startsWith("-") && (data[0].charAt(1) != c)) {
          String planName = data[0].replaceFirst("-", "");
          long planRaduis = Long.parseLong(data[1]);
          long planOrbit = Long.parseLong(data[2]);
          planet = new Planet(planName, planRaduis, planOrbit);
          star.addPlanet(planet); 

        } else if (data[0].startsWith("--")) {
          String moonName = data[0].replaceFirst("--", "");
          long moonRaduis = Long.parseLong(data[1]);
          long moonOrbit = Long.parseLong(data[2]);
          moon = new Moon(moonName, moonRaduis, moonOrbit);
          planet.addMoon(moon);
        }

      }

    } catch (NumberFormatException | IOException exception) {
      exception.printStackTrace();
    }
  }


}

