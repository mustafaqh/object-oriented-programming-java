package assignment4.view;

import assignment4.model.domain.SysRegistry;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * class to write(save) the data in file.
 */
public class Writer {

  /**
   * method to write the data to a specific file.
   *
   * @param reg      SysRegistry, instance of class SysRegistry.
   * @param fileName String, file path.
   */
  public void writeToFile(SysRegistry reg, String fileName) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
      bw.write(reg.writeToFile());
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
