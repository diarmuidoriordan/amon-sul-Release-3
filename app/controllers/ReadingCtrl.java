package controllers;

import models.Station;
import models.Reading;
import models.User;
import play.Logger;
import play.mvc.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadingCtrl extends Controller {

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
