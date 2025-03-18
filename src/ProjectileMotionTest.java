import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.ProjectileMotion;

public class ProjectileMotionTest {

    private static final double DELTA = 1e-5; // Tolerance for floating-point comparisons

    // Test Time of Flight
    @Test
    void testTimeOfFlightCase1() {
        double result = ProjectileMotion.timeOfFlight(10, 30);
        double expected = (2 * 10 * Math.sin(Math.toRadians(30))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected time of flight mismatch");
    }

    @Test
    void testTimeOfFlightCase2() {
        double result = ProjectileMotion.timeOfFlight(20, 45);
        double expected = (2 * 20 * Math.sin(Math.toRadians(45))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected time of flight mismatch");
    }

    @Test
    void testTimeOfFlightCase3() {
        double result = ProjectileMotion.timeOfFlight(50, 60);
        double expected = (2 * 50 * Math.sin(Math.toRadians(60))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected time of flight mismatch");
    }

    // Test Maximum Height
    @Test
    void testMaxHeightCase1() {
        double result = ProjectileMotion.maxHeight(10, 30);
        double expected = (10 * 10 * Math.pow(Math.sin(Math.toRadians(30)), 2)) / (2 * 9.8);
        assertEquals(expected, result, DELTA, "Expected max height mismatch");
    }

    @Test
    void testMaxHeightCase2() {
        double result = ProjectileMotion.maxHeight(20, 45);
        double expected = (20 * 20 * Math.pow(Math.sin(Math.toRadians(45)), 2)) / (2 * 9.8);
        assertEquals(expected, result, DELTA, "Expected max height mismatch");
    }

    @Test
    void testMaxHeightCase3() {
        double result = ProjectileMotion.maxHeight(50, 60);
        double expected = (50 * 50 * Math.pow(Math.sin(Math.toRadians(60)), 2)) / (2 * 9.8);
        assertEquals(expected, result, DELTA, "Expected max height mismatch");
    }

    // Test Total Range
    @Test
    void testTotalRangeCase1() {
        double result = ProjectileMotion.totalRange(10, 30);
        double expected = (10 * 10 * Math.sin(2 * Math.toRadians(30))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected total range mismatch");
    }

    @Test
    void testTotalRangeCase2() {
        double result = ProjectileMotion.totalRange(20, 45);
        double expected = (20 * 20 * Math.sin(2 * Math.toRadians(45))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected total range mismatch");
    }

    @Test
    void testTotalRangeCase3() {
        double result = ProjectileMotion.totalRange(50, 60);
        double expected = (50 * 50 * Math.sin(2 * Math.toRadians(60))) / 9.8;
        assertEquals(expected, result, DELTA, "Expected total range mismatch");
    }

    // Test Velocity at Time
    @Test
    void testVelocityAtTimeCase1() {
        double result = ProjectileMotion.velocityAtTime(10, 30, 1);
        double angleRad = Math.toRadians(30);
        double vx = 10 * Math.cos(angleRad);
        double vy = 10 * Math.sin(angleRad) - 9.8 * 1;
        double expected = Math.sqrt(vx * vx + vy * vy);
        assertEquals(expected, result, DELTA, "Expected velocity at time mismatch");
    }

    @Test
    void testVelocityAtTimeCase2() {
        double result = ProjectileMotion.velocityAtTime(20, 45, 2);
        double angleRad = Math.toRadians(45);
        double vx = 20 * Math.cos(angleRad);
        double vy = 20 * Math.sin(angleRad) - 9.8 * 2;
        double expected = Math.sqrt(vx * vx + vy * vy);
        assertEquals(expected, result, DELTA, "Expected velocity at time mismatch");
    }

    @Test
    void testVelocityAtTimeCase3() {
        double result = ProjectileMotion.velocityAtTime(50, 60, 3);
        double angleRad = Math.toRadians(60);
        double vx = 50 * Math.cos(angleRad);
        double vy = 50 * Math.sin(angleRad) - 9.8 * 3;
        double expected = Math.sqrt(vx * vx + vy * vy);
        assertEquals(expected, result, DELTA, "Expected velocity at time mismatch");
    }

    // Test Position at Time
    @Test
    void testPositionAtTimeCase1() {
        double[] result = ProjectileMotion.positionAtTime(10, 30, 1);
        double angleRad = Math.toRadians(30);
        double expectedX = 10 * Math.cos(angleRad) * 1;
        double expectedY = 10 * Math.sin(angleRad) * 1 - 0.5 * 9.8 * 1 * 1;
        assertEquals(expectedX, result[0], DELTA, "Expected x position mismatch");
        assertEquals(Math.max(expectedY, 0), result[1], DELTA, "Expected y position mismatch");
    }

    @Test
    void testPositionAtTimeCase2() {
        double[] result = ProjectileMotion.positionAtTime(20, 45, 2);
        double angleRad = Math.toRadians(45);
        double expectedX = 20 * Math.cos(angleRad) * 2;
        double expectedY = 20 * Math.sin(angleRad) * 2 - 0.5 * 9.8 * 2 * 2;
        assertEquals(expectedX, result[0], DELTA, "Expected x position mismatch");
        assertEquals(Math.max(expectedY, 0), result[1], DELTA, "Expected y position mismatch");
    }

    @Test
    void testPositionAtTimeCase3() {
        double[] result = ProjectileMotion.positionAtTime(50, 60, 3);
        double angleRad = Math.toRadians(60);
        double expectedX = 50 * Math.cos(angleRad) * 3;
        double expectedY = 50 * Math.sin(angleRad) * 3 - 0.5 * 9.8 * 3 * 3;
        assertEquals(expectedX, result[0], DELTA, "Expected x position mismatch");
        assertEquals(Math.max(expectedY, 0), result[1], DELTA, "Expected y position mismatch");
    }
}
