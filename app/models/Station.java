package models;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Station extends Model  {

  //  Station name & location details
  public String name;
  public double latitude;
  public double longitude;

  //  Current weather conditions from code
  public String weatherFromCode;

  //  Temperature info. & trends variables
  //  from readings & calculations
  public double tempC;
  public double tempF;
  public double maxTempC;
  public double minTempC;
  public String tempTrends;

  //  Wind info. & trends variables
  //  from readings & calculations
  public int windBft;
  public int windDirection;
  public String windDirectionOutput;
  public double windChill;
  public double maxWindSpeed;
  public double minWindSpeed;
  public String windTrends;

  //  Pressure info. & trends variables
  //  from readings & calculations
  public int pressureHPA;
  public int maxPressure;
  public int minPressure;
  public String pressureTrends;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}