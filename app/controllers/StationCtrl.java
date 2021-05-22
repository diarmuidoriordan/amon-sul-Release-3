/**
 * @author Dermot O'Riordan
 */
package controllers;

import models.Station;
import models.User;
import play.Logger;
import play.mvc.Controller;
import utils.LatestWeather;

/**
 * This class controls various aspects of the Station objects.
 *
 * This class contains 2 static methods for both ADDING and DELETING Stations
 * for the system.
 * @author Dermot O'Riordan
 */
public class StationCtrl extends Controller {

    /**
     * This method generates and renders the Station dashboard page
     * where the user can view all of the readings from their Station.
     * @param id The ID of the Station, passed as a Long.
     */
    public static void index(Long id) {

        Logger.info("Rendering Station Info.");

        Station stations = Station.findById(id);
        stations = LatestWeather.getLatestReadings(stations);

        Logger.info ("Station ID = " + id);
        render ("stations.html", stations);
    }

    /**
     * This method accepts the details of a Station as input by the user, and
     * creates a new Station that is added to the stations readings List, the
     * User is saved and the Station dashboard webpage is launched.
     * @param name The name of the Station, passed as a String.
     * @param latitude The Station's GPS latitude co-ordinates, in Decimal Degrees.
     * @param longitude The Station's GPS longitude co-ordinates, in Decimal Degrees.
     */
    public static void addStation(String name, double latitude, double longitude) {

        User user = new Account().getLoggedInUser();
        Station station = new Station(name, latitude, longitude);

        Logger.info("Adding a new Station called " + name + " for User: " + user.email);
        Logger.info("This station is located at:\n\t\tLAT: " + latitude + "\n\t\tLNG: " + longitude);

        user.stations.add(station);
        user.save();

        redirect ("/dashboard");
    }

    /**
     * This method DELETES a Station from esistence.
     * @param id The ID of the Station to be deleted.
     */
    public static void deleteStation(Long id) {

        User user = new Account().getLoggedInUser();
        Station station = Station.findById(id);

        Logger.info("Deleting Station " + station.name + " from User: " + user.email);

        user.stations.remove(station);
        user.save();
        station.delete();

        Dashboard.index();
    }
}
