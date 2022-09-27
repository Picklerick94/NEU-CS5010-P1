import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the Person class.
 */
public class WeatherTest {

  private WeatherReading weather;

  @Before
  public void testConstructor() {
    try {
      weather = new WeatherReading(23, 25, 3, 12);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      weather = new WeatherReading(23, 12, -3, 12);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    try {
      weather = new WeatherReading(23, 12, 3, -12);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    weather = new WeatherReading(23, 12, 3, 12);
  }

  @Test
  public void testTemperature() {
    assertEquals(23, weather.getTemperature());
  }

  @Test
  public void testDewPoint() {
    assertEquals(12, weather.getDewPoint());
    System.out.println(weather.getHeatIndex());
  }

  @Test
  public void testWindSpeed() {
    assertEquals(3, weather.getWindSpeed());
  }

  @Test
  public void testRelativeHumidity() {
    assertEquals(45, weather.getRelativeHumidity());
  }

  @Test
  public void testTotalRain() {
    assertEquals(12, weather.getTotalRain());
  }

  @Test
  public void testHeatIndex() {
    assertEquals(12.0, 12, weather.getHeatIndex());
  }

  @Test
  public void testWindChill() {
    float f = 113.8435991116174F;
    double d = f;
    assertEquals(f, d, weather.getWindChill());
  }
}
