/**
 * @author Dermot O'Riordan
 */
package utils;

import models.Reading;
import models.Station;

/**
 * A class to contain all of the methods used to analyse recent readings and
 * to return the MAXIMUM and MINIMUM values for each of the readings from the Station.
 * @author Dermot O'Riordan
 */
public class MaxMinValues {

    /**
     * This method analyses all temperature readings for a station and returns
     * the highest recorded temperature (in degrees Celcius) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The highest temperature reading in degrees Celcius.
     */
    public static double getMaxTempC(Station stations) {

        double max = Double.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.temperature > max) {
                max = reading.temperature;
            }
        }
        return max;
    }

    /**
     * This method analyses all temperature readings for a station and returns
     * the lowest recorded temperature (in degrees Celcius) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The lowest temperature reading in degrees Celcius.
     */
    public static double getMinTempC(Station stations) {

        double min = Double.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.temperature < min) {
                min = reading.temperature;
            }
        }
        return min;
    }

    /**
     * This method analyses all wind speed readings for a station and returns
     * the highest recorded wind speed (in Km/h) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The highest wind speed reading in Km/h.
     */
    public static double getMaxWindSpeed(Station stations) {

        double max = Double.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.windSpeed > max) {
                max = reading.windSpeed;
            }
        }
        return max;
    }

    /**
     * This method analyses all wind speed readings for a station and returns
     * the lowest recorded wind speed (in Km/h) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The lowest wind speed reading in Km/h.
     */
    public static double getMinWindSpeed(Station stations) {

        double min = Double.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.windSpeed < min) {
                min = reading.windSpeed;
            }
        }
        return min;
    }

    /**
     * This method analyses all pressure readings for a station and returns
     * the highest recorded pressure (in hPa) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The highest pressure reading in hPa.
     */
    public static int getMaxPressure(Station stations) {

        int max = Integer.MIN_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.pressure > max) {
                max = reading.pressure;
            }
        }
        return max;
    }

    /**
     * This method analyses all pressure readings for a station and returns
     * the lowest recorded pressure (in hPa) for that station.
     * @param stations The station whose readings are to be analysed.
     * @return The lowest pressure reading in hPa.
     */
    public static int getMinPressure(Station stations) {

        int min = Integer.MAX_VALUE;

        for (Reading reading : stations.readings) {
            if (reading.pressure < min) {
                min = reading.pressure;
            }
        }
        return min;
    }
}
