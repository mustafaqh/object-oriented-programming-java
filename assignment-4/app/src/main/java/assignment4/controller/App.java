package assignment4.controller;

import assignment4.model.domain.FileLoader;
import assignment4.model.domain.SysRegistry;
import assignment4.view.MainMenu;
import assignment4.view.Writer;

/**
 * the main class o run the application.
 */
public class App {
  /**
   * main metohd to run the app.
   *
   * @param args .
   */
  public static void main(String[] args) {
    FileLoader fl = new FileLoader();
    SysRegistry reg = new SysRegistry();
    MainMenu mm = new MainMenu();
    Writer wr = new Writer();
    Controller cl = new Controller(fl, reg, mm, wr);
    cl.mainMenu();
  }

}
