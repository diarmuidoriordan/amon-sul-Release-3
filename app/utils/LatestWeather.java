/**
 * @author Dermot O'Riordan
 */
package utils;

import models.Reading;
import models.Station;

/**
 * This class contains a single static method to retrieve the most
 * recent Reading for a station and calculate and append additional
 * values of weather reporting for the Latest Weather summary cards.
 * @author Dermot O'Riordan
 */
public class LatestWeather {

    /**
     * This method calculates the most recent readings to display on the latest
     * weather cards in the Station summary panel.
     *
     * To calculate all fields accurately, this method draws on other static
     * methods in other classes in the utils package:
     *
     * (1) Conversions: A list of appropriate calculations and switches.
     *
     * (2) MaxMinValues: A class that contains methods to extract the maximum
     * or minimum values for a list of readings.
     *
     * (3) Trends: A class to hold methods for analysing recent weather trends.
     * @param stations Takes in the Station object to extract the readings from.
     * @return The Station is returned with all instance variable fields initialised.
     */
    public static Station getLatestReadings(Station stations) {

        if (stations.readings.size() > 0) {

            Reading reading = stations.readings.get(stations.readings.size() - 1);

            stations.tempC = reading.temperature;
            stations.tempF = Conversions.tempToF(reading.temperature);
            stations.maxTempC = MaxMinValues.getMaxTempC(stations);
            stations.minTempC = MaxMinValues.getMinTempC(stations);
            stations.tempTrends = Trends.getTempTrends(stations);

            stations.windBft = Conversions.windToBft(reading.windSpeed);
            stations.windDirection = reading.windDirection;
            stations.windDirectionOutput = Conversions.windDirectionToString(reading.windDirection);

            stations.windChill = Conversions.windChillCalc(reading.windSpeed, reading.temperature);
            stations.maxWindSpeed = MaxMinValues.getMaxWindSpeed(stations);
            stations.minWindSpeed = MaxMinValues.getMinWindSpeed(stations);
            stations.windTrends = Trends.getWindTrends(stations);

            stations.pressureHPA = reading.pressure;
            stations.maxPressure = MaxMinValues.getMaxPressure(stations);
            stations.minPressure = MaxMinValues.getMinPressure(stations);
            stations.pressureTrends = Trends.getPressureTrends(stations);

            stations.weatherFromCode = Conversions.weatherCodeToString(reading.code);
            stations.weatherIcon = Conversions.weatherIconFromCode(reading.code);
        }
        else {
            stations.tempC = 0;
            stations.tempF = 0;
            stations.maxTempC = 0;
            stations.minTempC = 0;
            stations.tempTrends = "";

            stations.windBft = 0;
            stations.windDirection = 0;
            stations.windDirectionOutput = "UNAVAILABLE";

            stations.windChill = 0;
            stations.maxWindSpeed = 0;
            stations.minWindSpeed = 0;
            stations.windTrends = "";

            stations.pressureHPA = 0;
            stations.maxPressure = 0;
            stations.minPressure = 0;
            stations.pressureTrends = "";

            stations.weatherFromCode = "UNAVAILABLE";
            stations.weatherIcon = "";
        }

        return stations;
    }
}
