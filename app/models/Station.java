/**
 * @author Dermot O'Riordan
 */
package models;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This class creates a Station and includes a constructor to
 * initialise some, but not all, of the class variable fields.
 * @author Dermot O'Riordan
 */
@Entity
public class Station extends Model  {

  /**
   * Station Name from user input or read from file.
   */
  public String name;

  /**
   * GPS Latitude co-ordinates in Decimal Decrees, from user input or read from file.
   */
  public double latitude;

  /**
   * GPS Longitude co-ordinates in Decimal Decrees from user input or read from file.
   */
  public double longitude;

  /**
   * Current weather conditions from code.
   */
  public String weatherFromCode;

  /**
   * String that contains Fomantic UI semantic code to set the appropriate current weather icon.
   */
  public String weatherIcon;

  /**
   * Temperature in degrees Celcius.
   */
  public double tempC;

  /**
   * Most recent temperature reading in degrees Fahrenheit.
   */
  public double tempF;

  /**
   * Highest temperature ever recorded for this Station.
   */
  public double maxTempC;

  /**
   * Lowest temperature ever recorded for this Station.
   */
  public double minTempC;

  /**
   * Are the three most recent temperature readings RISING or FALLING?
   */
  public String tempTrends;

  /**
   * Wind speed as a reading converted from Km/h to the Beaufort Scale (Bft).
   */
  public int windBft;

  /**
   * Direction the wind is blowing in, measured in degrees.
   */
  public int windDirection;

  /**
   * A destription in words of the direction the wind is blowing in.
   */
  public String windDirectionOutput;

  /**
   * The wind chill factor ("feels like") in degrees Celcius.
   */
  public double windChill;

  /**
   * Highest wind speed ever recorded for this Station.
   */
  public double maxWindSpeed;

  /**
   * Lowest wind speed ever recorded for this Station.
   */
  public double minWindSpeed;

  /**
   * Are the three most recent wind speed readings RISING or FALLING?
   */
  public String windTrends;

  /**
   * Pressure in hPa.
   */
  public int pressureHPA;

  /**
   * Highest pressure ever recorded for this Station.
   */
  public int maxPressure;

  /**
   * Lowest temperature ever recorded for this Station.
   */
  public int minPressure;

  /**
   * Are the three most recent pressure readings RISING or FALLING?
   */
  public String pressureTrends;

  /**
   * A List of all the Readings for this Station.
   */
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  /**
   * Constructor for the Station object. Accepts the name, latitude and longitude
   * information and initialises these class variable fields. Other fields are
   * initialised from another method in the utils.LatestWeather class.
   * @param name Station Name from user input or read from file.
   * @param latitude GPS Latitude co-ordinates in Decimal Decrees, from user input or read from file.
   * @param longitude GPS Longitude co-ordinates in Decimal Decrees from user input or read from file.
   */
  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}