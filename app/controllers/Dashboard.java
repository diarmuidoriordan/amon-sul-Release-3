/**
 * @author Dermot O'Riordan
 */
package controllers;

import models.Station;
import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.LatestWeather;

import java.util.List;

/**
 * This class generates and renders the Dashboard with the list of the user's Stations.
 * @author Dermot O'Riordan
 */
public class Dashboard extends Controller
{
  /**
   * Renders the Dashboard with the list of the user's Stations.
   */
  public static void index() {

    User user = Account.getLoggedInUser();
    List<Station> stations = user.stations;

    for (int i = 0; i < stations.size(); i++) {
      LatestWeather.getLatestReadings(stations.get(i));
    }

    Logger.info("Rendering Dashboard for User: " + user.email);

    render ("dashboard.html", stations);
  }
}
