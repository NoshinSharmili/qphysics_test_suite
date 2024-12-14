import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.Conversion;

public class ConversionTest {

    private static final double DELTA = 1e-5; // Tolerance for floating-point comparisons

    // Length Conversions
    @Test
    void testMetersToKilometers() {
        double result = Conversion.metersToKilometers(1000);
        assertEquals(1, result, DELTA, "Expected 1000 meters to equal 1 kilometer");
    }

    @Test
    void testKilometersToMeters() {
        double result = Conversion.kilometersToMeters(1);
        assertEquals(1000, result, DELTA, "Expected 1 kilometer to equal 1000 meters");
    }

    @Test
    void testMetersToMiles() {
        double result = Conversion.metersToMiles(1609.34);
        assertEquals(1, result, DELTA, "Expected 1609.34 meters to equal 1 mile");
    }

    @Test
    void testMilesToMeters() {
        double result = Conversion.milesToMeters(1);
        assertEquals(1609.34, result, DELTA, "Expected 1 mile to equal 1609.34 meters");
    }

    // Temperature Conversions
    @Test
    void testCelsiusToFahrenheit() {
        double result = Conversion.celsiusToFahrenheit(0);
        assertEquals(32, result, DELTA, "Expected 0°C to equal 32°F");
    }

    @Test
    void testFahrenheitToCelsius() {
        double result = Conversion.fahrenheitToCelsius(32);
        assertEquals(0, result, DELTA, "Expected 32°F to equal 0°C");
    }

    // Energy Conversions
    @Test
    void testJoulesToCalories() {
        double result = Conversion.joulesToCalories(4.184);
        assertEquals(1, result, DELTA, "Expected 4.184 joules to equal 1 calorie");
    }

    @Test
    void testCaloriesToJoules() {
        double result = Conversion.caloriesToJoules(1);
        assertEquals(4.184, result, DELTA, "Expected 1 calorie to equal 4.184 joules");
    }

    // Force Conversions
    @Test
    void testNewtonsToPounds() {
        double result = Conversion.newtonsToPounds(10);
        assertEquals(2.24809, result, DELTA, "Expected 10 newtons to equal 2.24809 pounds-force");
    }

    @Test
    void testPoundsToNewtons() {
        double result = Conversion.poundsToNewtons(2.24809);
        assertEquals(10, result, DELTA, "Expected 2.24809 pounds-force to equal 10 newtons");
    }

    // Time Conversions
    @Test
    void testSecondsToMinutes() {
        double result = Conversion.secondsToMinutes(60);
        assertEquals(1, result, DELTA, "Expected 60 seconds to equal 1 minute");
    }

    @Test
    void testMinutesToSeconds() {
        double result = Conversion.minutesToSeconds(1);
        assertEquals(60, result, DELTA, "Expected 1 minute to equal 60 seconds");
    }

    // Angle Conversions
    @Test
    void testDegreesToRadians() {
        double result = Conversion.degreesToRadians(180);
        assertEquals(Math.PI, result, DELTA, "Expected 180 degrees to equal π radians");
    }

    @Test
    void testRadiansToDegrees() {
        double result = Conversion.radiansToDegrees(Math.PI);
        assertEquals(180, result, DELTA, "Expected π radians to equal 180 degrees");
    }
    @Test
    void testWattsToHorsePower() {
        double result = Conversion.wattsToHorsePower(745.7);
        assertEquals(1, result, DELTA, "Expected 745.7 watts to equal 1 horsepower");
    }

    @Test
    void testHorsePowerToWatts() {
        double result = Conversion.horsePowerToWatts(1);
        assertEquals(745.7, result, DELTA, "Expected 1 horsepower to equal 745.7 watts");
    }

    // Volume Conversions
    @Test
    void testLitersToGallons() {
        double result = Conversion.litersToGallons(3.78541);
        assertEquals(1, result, DELTA, "Expected 3.78541 liters to equal 1 gallon");
    }

    @Test
    void testGallonsToLiters() {
        double result = Conversion.gallonsToLiters(1);
        assertEquals(3.78541, result, DELTA, "Expected 1 gallon to equal 3.78541 liters");
    }

    // Mass Conversions
    @Test
    void testKilogramsToPounds() {
        double result = Conversion.kilogramsToPounds(1);
        assertEquals(2.20462, result, DELTA, "Expected 1 kilogram to equal 2.20462 pounds");
    }

    @Test
    void testPoundsToKilograms() {
        double result = Conversion.poundsToKilograms(2.20462);
        assertEquals(1, result, DELTA, "Expected 2.20462 pounds to equal 1 kilogram");
    }
}


