/**
 * @author Dermot O'Riordan
 */
package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class controls various aspects of the Reading variables.
 *
 * This class contains 2 static methods for both ADDING and DELETING Readings
 * for the system.
 * @author Dermot O'Riordan
 */
public class ReadingCtrl extends Controller {

    /**
     * This method accepts the details of a Reading as input by the user, and
     * creates a new Reading that is added to the stations readings List, the
     * station is saved and the station dashboard webpage is launched.
     * @param id The user's ID, passed as a Long.
     * @param code The current weather conditions code value for the Reading.
     * @param temperature The temperature value for the Reading in degrees Celcius.
     * @param windSpeed The wind speed value for the Reading in Km/h.
     * @param windDirection The wind direction value for the Reading in degrees.
     * @param pressure The pressure value for the Reading in hPa.
     */
    public static void addReading(Long id, int code, double temperature, double windSpeed,
                                  int windDirection, int pressure) {

        DateFormat dform = new SimpleDateFormat("yyyy/MM/dd  @  HH:mm:ss");
        Date obj = new Date();
        String date = dform.format(obj);

        Reading reading = new Reading(date, code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);

        station.readings.add(reading);
        station.save();

        redirect("/stations/" + id);
    }

    /**
     * This method retrieves the individual Reading to be deleted, then deletes
     * the Reading, saves the update to the station and renders the Station again.
     * @param id The user's ID, passed as a Long.
     * @param readingid The ID for the Reading to be deleted, passed as a Long.
     */
    public static void deleteReading(Long id, Long readingid) {

        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);

        Logger.info("Deleting Reading " + readingid + "created on " + reading.date
                + " from Station: " + station.name);

        station.readings.remove(reading);
        station.save();
        reading.delete();

        StationCtrl.index(id);
    }
}
