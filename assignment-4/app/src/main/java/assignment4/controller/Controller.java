package assignment4.controller;

import assignment4.view.MainMenu;

/**
 * class Controller to controll the main menu actions.
 */
public class Controller {
  private assignment4.model.domain.FileLoader fl;
  private assignment4.model.domain.SysRegistry reg;
  private assignment4.view.MainMenu mm;
  private assignment4.view.Writer wr;

  /**
   * constructor of the class controller.
   *
   * @param fl  FileLoader,instance of class FileLoader.
   * @param reg SysRegistry,instance of class SysRegistry.
   * @param mm  MainMenu, instance of class MainMenu.
   * @param wr  Writer, instance of class Writer.
   */
  public Controller(assignment4.model.domain.FileLoader fl,
      assignment4.model.domain.SysRegistry reg,
      assignment4.view.MainMenu mm, assignment4.view.Writer wr) {
    this.fl = fl;
    this.reg = reg;
    this.mm = mm;
    this.wr = wr;
  }

  /**
   * method to control the main menu.
   */
  public void mainMenu() {
    fl.fileReader(reg);
    boolean run = true;
    while (run) {
      MainMenu.TheMainMenu ch = mm.theMainMenu();
      switch (ch) {
        case CREATE:
          createMenu();
          break;
        case LIST:
          listingMenu();
          break;
        case DELETE:
          deletMenu();
          break;
        case EXIT:
          wr.writeToFile(reg, "solarsystems.data");
          run = false;
          break;
        default:
      }
    }
  }

  /**
   * method to control the create menu.
   */
  public void createMenu() {
    boolean run = true;
    while (run) {
      MainMenu.CreateSubMenu ch = mm.creatMenu();
      switch (ch) {
        case SOLAR:
          mm.createNewStar(reg);
          break;
        case PLANET:
          mm.createnewPlanet(reg);
          break;
        case MOON:
          mm.createNewMoon(reg);
          break;
        case EXIT:
          run = false;
          break;
        default:
      }
    }
  }

  /**
   * method to cntrol the listing menu.
   */
  public void listingMenu() {
    boolean run = true;
    while (run) {
      MainMenu.ListingMenu ch = mm.inforamtionSubMenu();
      switch (ch) {
        case LISTALL:
          mm.listTheSystems(reg);
          break;
        case LISTD_EATAILS_ORDED_BY_SIZE:
          mm.listDeatails("size", reg);
          break;
        case LIST_DEATAILS_ORDED_BY_ORBET:
          mm.listDeatails("orbit", reg);
          break;
        case EXIT:
          run = false;
          break;
        default:
      }
    }
  }

  /**
   * method to control the deleting menu.
   */
  public void deletMenu() {
    boolean run = true;
    while (run) {
      MainMenu.DeleteSubMenu ch = mm.deletingSubMenu();
      switch (ch) {
        case SOLAR:
          mm.deleteStar(reg);
          break;
        case PLANET:
          mm.deletePlanet(reg);
          break;
        case MOON:
          mm.deletMoon(reg);
          break;
        case EXIT:
          run = false;
          break;
        default:
      }
    }
  }

}
