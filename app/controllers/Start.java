/**
 * @author Dermot O'Riordan
 */
package controllers;

import play.Logger;
import play.mvc.Controller;

/**
 * This class renders and launches the Home Page.
 * @author Dermot O'Riordan
 */
public class Start extends Controller {

  /**
   * Renders the Home Page.
   */
  public static void index() {
    Logger.info("Rendering Start");
    render ("start.html");
  }
}
