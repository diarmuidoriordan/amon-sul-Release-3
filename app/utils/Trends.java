package utils;

import models.Reading;
import models.Station;

public class Trends {

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
