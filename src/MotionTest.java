import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.Motion;

public class MotionTest {

    private static final double DELTA = 1e-5; // tolerance for floating point comparisons

    @Test
    void testFinalVelocityUsingTime() {
        double result = Motion.finalVelocity(10, 5, 2);
        assertEquals(20, result, DELTA, "Expected final velocity with initial velocity 10, time 5, and acceleration 2");
    }

    @Test
    void testFinalVelocityUsingDisplacement() {
        double result = Motion.finalVelocity(10, 5, 2);
        assertEquals(12.2474487139, result, DELTA, "Expected final velocity with initial velocity 10, displacement 5, and acceleration 2");
    }

    @Test
    void testDisplacementUsingTime() {
        double result = Motion.displacement(10, 5, 2);
        assertEquals(35, result, DELTA, "Expected displacement with initial velocity 10, time 5, and acceleration 2");
    }

    @Test
    void testDisplacementUsingFinalVelocity() {
        double result = Motion.displacement(10, 20, 2);
        assertEquals(75, result, DELTA, "Expected displacement with initial velocity 10, final velocity 20, and acceleration 2");
    }

    @Test
    void testAccelerationUsingTime() {
        double result = Motion.acceleration(20, 10, 5);
        assertEquals(2, result, DELTA, "Expected acceleration with final velocity 20, initial velocity 10, and time 5");
    }

    @Test
    void testAccelerationUsingDisplacement() {
        double result = Motion.acceleration(100, 10, 5);
        assertEquals(4, result, DELTA, "Expected acceleration with displacement 100, initial velocity 10, and time 5");
    }

    @Test
    void testTime() {
        double result = Motion.time(10, 20, 2);
        assertEquals(5, result, DELTA, "Expected time with initial velocity 10, final velocity 20, and acceleration 2");
    }

    @Test
    void testAverageVelocity() {
        double result = Motion.averageVelocity(10, 20);
        assertEquals(15, result, DELTA, "Expected average velocity with initial velocity 10 and final velocity 20");
    }

    @Test
    void testRotationalVelocity() {
        double result = Motion.rotationalVelocity(5, 10, 2);
        assertEquals(25, result, DELTA, "Expected rotational velocity with angular velocity 5, time 10, and angular acceleration 2");
    }
}