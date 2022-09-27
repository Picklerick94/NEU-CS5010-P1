package weather;
import java.util.*;

public class WeatherReading {
  private int airTemp;
  private int dewTemp;
  private int windSpeed;
  private int rain;

  /**
   * Constructs a WeatherReading object and initializes it with 4 params.
   *
   * @param airTemp     the air temperature in Celsius
   * @param dewTemp     the dew point temperature in Celsius
   * @param windSpeed   the wind speed in miles per hour
   * @param rain        the total rain received in millimeters
   */
  public WeatherReading(int airTemp, int dewTemp, int windSpeed, int rain) throws IllegalArgumentException {
    if (dewTemp > airTemp) {
      throw new IllegalArgumentException("dew point temperature can't be greater than air temperature");
    }

    if (windSpeed < 0) {
      throw new IllegalArgumentException("wind speed must be non-negative");
    }

    if (rain < 0) {
      throw new IllegalArgumentException("rain must be non-negative");
    }

    this.airTemp = airTemp;
    this.dewTemp = dewTemp;
    this.windSpeed = Math.abs(windSpeed);
    this.rain = Math.abs(rain);
  }

  /**
   * Get the air temperature in Celsius.
   *
   * @return the air temperature in Celsius
   */
  public int getTemperature() {
    return this.airTemp;
  }

  /**
   * Get the dew point temperature in Celsius.
   *
   * @return the dew point temperature in Celsius
   */
  public int getDewPoint() { return this.dewTemp; }

  /**
   * Get the wind speed.
   *
   * @return the wind speed
   */
  public int getWindSpeed() { return this.windSpeed; }

  /**
   * Get the total rain.
   * @return the total rain
   */
  public int getTotalRain() {
    return this.rain;
  }

  /**
   * Get the relative humidity.
   * @return the relative humidity
   */
  public int getRelativeHumidity() {
    int relHumidity = 100 - ((this.airTemp - this.dewTemp) * 5);
    return relHumidity;
  };

  public double getHeatIndex() {
    double R = getRelativeHumidity();
    double T = this.airTemp;
    double heatIndex = -8.78469475556 + (1.61139411 * T) + (2.33854883889 * R) + (-0.14611605 * T * R) + (-0.012308094 * T * T) + (-0.0164248277778 * R * R) + (0.002211732 * T * T * R) + (0.00072546 * T * R * R) + (-0.000003582 * T * T * R * R);
    return heatIndex;
  };

  public double getWindChill() {
    double temp = this.airTemp;
    double tempF = ((temp*9)/5)+32;
    double windChill = 35.74 + (0.6215 * tempF) - (35.75 * Math.pow(this.windSpeed, 0.16)) + (0.4275 * tempF * Math.pow(this.windSpeed, 0.16));
    return windChill;
  }

  @Override
  public String toString() {
    return "Reading: " + "T" + " = " + this.airTemp + ", "  + "D" + " = " + this.dewTemp + ", "  + "v" + " = " + this.windSpeed + ", "  + "rain" + " = " + this.rain;
  }
}

