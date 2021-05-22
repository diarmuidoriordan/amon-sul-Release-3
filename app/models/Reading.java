/**
 * @author Dermot O'Riordan
 */
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

/**
 * This class creates a Reading and includes a constructor to
 * initialise all of the class variable fields.
 * @author Dermot O'Riordan
 */
@Entity
public class Reading extends Model {

  /**
   * The date and time the reading was taken in "yyy/MM/dd HH:MM:SS" String format.
   */
  public String date;

  /**
   * The current weather conditions code value for the Reading.
   */
  public int code;

  /**
   * The temperature value for the Reading in degrees Celcius.
   */
  public double temperature;

  /**
   * The wind speed value for the Reading in Km/h.
   */
  public double windSpeed;

  /**
   * The wind direction value for the Reading in degrees.
   */
  public int windDirection;

  /**
   * The pressure value for the Reading in hPa.
   */
  public int pressure;

  /**
   * This is the Constructor to create a new instance of the
   * Reading class.
   *
   * All Reading variables are passed through this constructor.
   * @param date The date and time the reading was taken in "yyy/MM/dd HH:MM:SS" String format.
   * @param code The current weather conditions code value for the Reading.
   * @param temperature The temperature value for the Reading in degrees Celcius.
   * @param windSpeed The wind speed value for the Reading in Km/h.
   * @param windDirection The wind direction value for the Reading in degrees.
   * @param pressure The pressure value for the Reading in hPa.
   */
  public Reading(String date, int code, double temperature, double windSpeed, int windDirection, int pressure) {
    this.date = date;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }
}
