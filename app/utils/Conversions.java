package utils;

public class Conversions {

    public static String weatherCodeToString(int code) {
        switch(code) {
            case 100:
                return "Clear";
            case 200:
                return "Partial\nClouds";
            case 300:
                return "Cloudy";
            case 400:
                return "Light\nShowers";
            case 500:
                return "Heavy\nShowers";
            case 600:
                return "Rain";
            case 700:
                return "Snow";
            case 800:
                return "Thunder";
            default:
                return "UNAVAILABLE";
        }
    }

    public static double tempToF(double temperature) {
        double tempF = (((temperature * 9) / 5) +32);
        tempF = (Math.round(tempF * 10.0) / 10.0);
        return tempF;
    }

    public static double windChillCalc(double windSpeed, double temperature) {
        double windChill = (13.12 + (0.6215 * temperature)) - (11.37 * (Math.pow(windSpeed, 0.16)))
                + ((0.3965 * temperature) * (Math.pow(windSpeed, 0.16)));
        windChill = (Math.round(windChill * 100.0) / 100.0);
        return windChill;
    }

    public static int windToBft(double windSpeed) {

        int windBft;

        if (windSpeed <= 1) {
            windBft = 0;
        }
        else if ((windSpeed > 1) && (windSpeed < 6)) {
            windBft = 1;
        }
        else if ((windSpeed >= 6) && (windSpeed < 12)) {
            windBft = 2;
        }
        else if ((windSpeed >= 12) && (windSpeed < 20)) {
            windBft = 3;
        }
        else if ((windSpeed >= 20) && (windSpeed < 29)) {
            windBft = 4;
        }
        else if ((windSpeed >= 29) && (windSpeed < 39)) {
            windBft = 5;
        }
        else if ((windSpeed >= 39) && (windSpeed < 50)) {
            windBft = 6;
        }
        else if ((windSpeed >= 50) && (windSpeed < 62)) {
            windBft = 7;
        }
        else if ((windSpeed >= 62) && (windSpeed < 75)) {
            windBft = 8;
        }
        else if ((windSpeed >= 75) && (windSpeed < 89)) {
            windBft = 9;
        }
        else if ((windSpeed >= 89) && (windSpeed < 103)) {
            windBft = 10;
        }
        else {
            windBft = 11;
        }

        return windBft;
    }

    public static String windDirectionToString(int windDirection) {
        if (((windDirection >= 348.75) && (windDirection <= 360))
                || ((windDirection >= 0) && (windDirection < 11.25))) {
            return "North";
        }
        else if ((windDirection >= 11.25) && (windDirection < 33.75)) {
            return "North North East";
        }
        else if ((windDirection >= 33.75) && (windDirection < 56.25)) {
            return "North East";
        }
        else if ((windDirection >= 56.25) && (windDirection < 78.75)) {
            return "East North East";
        }
        else if ((windDirection >= 78.75) && (windDirection < 101.25)) {
            return "East";
        }
        else if ((windDirection >= 101.25) && (windDirection < 123.75)) {
            return "East South East";
        }
        else if ((windDirection >= 123.75) && (windDirection < 146.25)) {
            return "South East";
        }
        else if ((windDirection >= 146.25) && (windDirection < 168.75)) {
            return "South South East";
        }
        else if ((windDirection >= 168.75) && (windDirection < 191.25)) {
            return "South";
        }
        else if ((windDirection >= 191.25) && (windDirection < 213.75)) {
            return "South South West";
        }
        else if ((windDirection >= 213.75) && (windDirection < 236.25)) {
            return "South West";
        }
        else if ((windDirection >= 236.25) && (windDirection < 258.75)) {
            return "West South West";
        }
        else if ((windDirection >= 258.75) && (windDirection < 281.25)) {
            return "West";
        }
        else if ((windDirection >= 281.25) && (windDirection < 303.75)) {
            return "West North West";
        }
        else if ((windDirection >= 303.75) && (windDirection < 326.25)) {
            return "North West";
        }
        else if ((windDirection >= 326.25) && (windDirection < 348.75)) {
            return "North North West";
        }
        else {
            return "ERROR";
        }
    }

    public static String weatherIconFromCode(int code) {
        switch(code) {
            case 100:
                //  Clear
                return "yellow huge sun outline icon";
            case 200:
                //  Partial Clouds
                return "ui inverted yellow huge cloud sun icon";
            case 300:
                //  Cloudy
                return "ui inverted purple huge cloud icon";
            case 400:
                //  Light Showers
                return "ui inverted primary huge cloud sun rain icon";
            case 500:
                //  Heavy Showers
                return "grey huge cloud showers heavy icon";
            case 600:
                //  Rain
                return "blue huge cloud rain icon";
            case 700:
                //  Snow
                return "ui inverted white huge snowflake outline icon";
            //  Thunder
            case 800:
                return "red huge poo storm icon";
            default:
                return "UNAVAILABLE";
        }
    }
}
