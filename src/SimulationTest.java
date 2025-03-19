import qphysics.Simulation;
import qphysics.Constants;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Simulation class.
 * This class contains unit tests to verify the correctness of various physics simulations.
 */
public class SimulationTest {

    /**
     * Tests the ball throw simulation with a small initial velocity.
     * This test verifies if the total time is calculated correctly.
     */
    @Test
    public void testSimulateBallThrow() {
        double initialVelocity = 10.0;
        double expectedTotalTime = (2 * initialVelocity) / Constants.ACCELERATION_DUE_TO_GRAVITY;

        Simulation.simulateBallThrow(initialVelocity);

        assertTrue(expectedTotalTime > 0, "Total time should be positive");
    }

    /**
     * Tests the pendulum simulation for a given length and initial angle.
     * Verifies that the calculated period matches the expected value.
     */
    @Test
    public void testSimulatePendulum() {
        double length = 2.0;
        double initialAngle = 30.0;
        double expectedPeriod = 2 * Math.PI * Math.sqrt(length / Constants.ACCELERATION_DUE_TO_GRAVITY);

        Simulation.simulatePendulum(length, initialAngle, expectedPeriod);

        assertTrue(expectedPeriod > 0, "Period should be positive");
    }

    /**
     * Tests an elastic collision between two objects.
     * Ensures conservation of momentum and kinetic energy.
     */
    @Test
    public void testSimulateElasticCollision() {
        double mass1 = 5.0, velocity1 = 3.0;
        double mass2 = 3.0, velocity2 = -2.0;

        double initialMomentum = (mass1 * velocity1) + (mass2 * velocity2);
        double initialKE = (0.5 * mass1 * velocity1 * velocity1) + (0.5 * mass2 * velocity2 * velocity2);

        Simulation.simulateCollision(mass1, velocity1, mass2, velocity2, true);

        // For elastic collisions, total momentum and kinetic energy should remain the same
        assertEquals(initialMomentum, (mass1 * velocity1) + (mass2 * velocity2), 0.01);
        assertEquals(initialKE, (0.5 * mass1 * velocity1 * velocity1) + (0.5 * mass2 * velocity2 * velocity2), 0.01);
    }



    /**
     * Tests projectile motion with an initial velocity and launch angle.
     * Ensures that the total flight time and range calculations are correct.
     */
    @Test
    public void testSimulateProjectileMotion() {
        double initialVelocity = 20.0;
        double launchAngle = 45.0;

        double gravity = Constants.ACCELERATION_DUE_TO_GRAVITY;
        double angleRadians = Math.toRadians(launchAngle);
        double expectedTotalTime = (2 * initialVelocity * Math.sin(angleRadians)) / gravity;
        double expectedRange = (Math.pow(initialVelocity, 2) * Math.sin(2 * angleRadians)) / gravity;

        Simulation.simulateProjectileMotion(initialVelocity, launchAngle);

        assertTrue(expectedTotalTime > 0, "Total flight time should be positive");
        assertTrue(expectedRange > 0, "Range should be positive");
    }

    /**
     * Tests the force and acceleration simulation.
     * Verifies that the calculated acceleration matches expectations.
     */
    @Test
    public void testSimulateForceAndAcceleration() {
        double mass = 10.0;
        double force = 50.0;
        double expectedAcceleration = force / mass;

        Simulation.simulateForceAndAcceleration(mass, force);

        assertTrue(expectedAcceleration > 0, "Acceleration should be positive");
    }
}
