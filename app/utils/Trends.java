/**
 * A class that contains static methods to produce the
 * appropriate Fomatic UI semantic code to generate an
 * UP or DOWN arrow icon to indicate the trend for that
 * element.
 * @author Dermot O'Riordan
 */
package utils;

import models.Reading;
import models.Station;

/**
 * A class to contain all of the methods used to analyse recent readings and
 * see if their values have been RISING or FALLING.
 * @author Dermot O'Riordan
 */
public class Trends {

    /**
     * This method accepts a Station object as a parameter and returns a String
     * with the Fomatic UI semantic code to generate an appropriate arrow icon
     * to indicate if the most recent 3 temperature readings were either RISING
     * or FALLING.
     *
     * If neither, then no icon is displayed on the Latest Weather temperature card.
     * @param stations The station whose readings are to be analysed.
     * @return A String with the Fomatic UI semantic code to generate an appropriate UP or DOWN arrow icon.
     */
    public static String getTempTrends(Station stations) {
        String tempTrends = "";

        if (stations.readings.size() >= 3) {
            Reading primary = stations.readings.get(stations.readings.size() - 1);
            Reading secondary = stations.readings.get(stations.readings.size() - 2);
            Reading tertiary = stations.readings.get(stations.readings.size() - 3);

            if ((primary.temperature > secondary.temperature) && (secondary.temperature > tertiary.temperature)) {
                tempTrends = "ui inverted orange big arrow alternate circle up icon";
            } else if ((primary.temperature < secondary.temperature) && (secondary.temperature < tertiary.temperature)) {
                tempTrends = "ui inverted blue big arrow alternate circle down icon";
            }
        }
        else {
            tempTrends = "";
        }
        return tempTrends;
    }

    /**
     * This method accepts a Station object as a parameter and returns a String
     * with the Fomatic UI semantic code to generate an appropriate arrow icon
     * to indicate if the most recent 3 wind speed readings were either RISING
     * or FALLING.
     *
     * If neither, then no icon is displayed on the Latest Weather temperature card.
     * @param stations The station whose wind speed readings are to be analysed.
     * @return A String with the Fomatic UI semantic code to generate an appropriate UP or DOWN arrow icon.
     */
    public static String getWindTrends(Station stations) {
        String windTrends = "";

        if (stations.readings.size() >= 3) {
            Reading primary = stations.readings.get(stations.readings.size() - 1);
            Reading secondary = stations.readings.get(stations.readings.size() - 2);
            Reading tertiary = stations.readings.get(stations.readings.size() - 3);

            if ((primary.windSpeed > secondary.windSpeed) && (secondary.windSpeed > tertiary.windSpeed)) {
                windTrends = "ui inverted grey big arrow alternate circle up icon";
            } else if ((primary.windSpeed < secondary.windSpeed) && (secondary.windSpeed < tertiary.windSpeed)) {
                windTrends = "ui inverted grey big arrow alternate circle down icon";
            }
        }
        else {
            windTrends = "";
        }
        return windTrends;
    }

    /**
     * This method accepts a Station object as a parameter and returns a String
     * with the Fomatic UI semantic code to generate an appropriate arrow icon
     * to indicate if the most recent 3 pressure readings were either RISING
     * or FALLING.
     *
     * If neither, then no icon is displayed on the Latest Weather pressure card.
     * @param stations The station whose pressure readings are to be analysed.
     * @return A String with the Fomatic UI semantic code to generate an appropriate UP or DOWN arrow icon.
     */
    public static String getPressureTrends(Station stations) {
        String pressureTrends = "";

        if (stations.readings.size() >= 3) {
            Reading primary = stations.readings.get(stations.readings.size() - 1);
            Reading secondary = stations.readings.get(stations.readings.size() - 2);
            Reading tertiary = stations.readings.get(stations.readings.size() - 3);

            if ((primary.pressure > secondary.pressure) && (secondary.pressure > tertiary.pressure)) {
                pressureTrends = "ui inverted green big arrow alternate circle up icon";
            } else if ((primary.pressure < secondary.pressure) && (secondary.pressure < tertiary.pressure)) {
                pressureTrends = "ui inverted pink big arrow alternate circle down icon";
            }
        }
        else {
            pressureTrends = "";
        }
        return pressureTrends;
    }
}
