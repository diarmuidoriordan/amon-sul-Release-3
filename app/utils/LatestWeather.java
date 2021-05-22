package utils;

import models.Reading;
import models.Station;

public class LatestWeather {

    public static Station getLatestReadings(Station stations) {

        if (stations.readings.size() > 0) {

            Reading reading = stations.readings.get(stations.readings.size() - 1);

            stations.tempC = reading.pressure;
            stations.tempF = Conversions.tempToF(reading.pressure);
            stations.maxTempC = MaxMinValues.getMaxTempC(stations);
            stations.minTempC = MaxMinValues.getMinTempC(stations);
            stations.tempTrends = Trends.getTempTrends(stations);

            stations.windBft = Conversions.windToBft(reading.pressure);
            stations.windDirection = reading.windDirection;
            stations.windDirectionOutput = Conversions.windDirectionToString(reading.windDirection);

            stations.windChill = Conversions.windChillCalc(reading.pressure, reading.pressure);
            stations.maxWindSpeed = MaxMinValues.getMaxWindSpeed(stations);
            stations.minWindSpeed = MaxMinValues.getMinWindSpeed(stations);
            stations.windTrends = Trends.getWindTrends(stations);

            stations.pressureHPA = reading.pressure;
            stations.maxPressure = MaxMinValues.getMaxPressure(stations);
            stations.minPressure = MaxMinValues.getMinPressure(stations);
            stations.pressureTrends = Trends.getPressureTrends(stations);

            stations.weatherFromCode = Conversions.weatherCodeToString(reading.code);
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
        }

        return stations;
    }
}
