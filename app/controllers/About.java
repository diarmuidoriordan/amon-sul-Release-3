/**
 * @author Dermot O'Riordan
 */
package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

/**
 * The class that creates and renders the About web page.
 * @author Dermot O'Riordan
 */
public class About extends Controller
{
  /**
   * This method renders the About webpage.
   */
  public static void index() {
    Logger.info("Rendering About");
    render ("about.html");
  }
}
