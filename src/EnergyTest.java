import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.Energy;

public class EnergyTest {

    private static final double DELTA = 1e-6; // Tolerance for floating-point comparisons

    @Test
    void testKineticEnergy() {
        assertEquals(50.0, Energy.kineticEnergy(5, 4), DELTA, "Expected kinetic energy with mass 5 kg and velocity 4 m/s");
        assertEquals(0.0, Energy.kineticEnergy(0, 10), DELTA, "Expected kinetic energy to be 0 when mass is 0");
        assertEquals(18.0, Energy.kineticEnergy(3, 4), DELTA, "Expected kinetic energy with mass 3 kg and velocity 4 m/s");
    }

    @Test
    void testPotentialEnergy() {
        assertEquals(98.1, Energy.potentialEnergy(10, 1, 9.81), DELTA, "Expected potential energy with mass 10 kg, height 1 m, and gravity 9.81 m/s^2");
        assertEquals(0.0, Energy.potentialEnergy(5, 0, 9.81), DELTA, "Expected potential energy to be 0 when height is 0");
        assertEquals(196.2, Energy.potentialEnergy(10, 2, 9.81), DELTA, "Expected potential energy with mass 10 kg, height 2 m");
    }

    @Test
    void testGravitationalPotentialEnergy() {
        assertEquals(-6.6743e-11, Energy.gravitationalPotentialEnergy(1, 1, 1), 1e-15, "Expected gravitational potential energy for two 1 kg masses 1 m apart");
        assertEquals(0.0, Energy.gravitationalPotentialEnergy(1, 1, Double.POSITIVE_INFINITY), 1e-15, "Expected 0 gravitational potential energy at infinite distance");
        assertEquals(-1.33486e-9, Energy.gravitationalPotentialEnergy(2, 1, 1), 1e-15, "Expected gravitational potential energy with mass 2 kg and 1 kg at 1m distance");
    }

    @Test
    void testElasticPotentialEnergy() {
        assertEquals(25.0, Energy.elasticPotentialEnergy(50, 1), DELTA, "Expected elastic potential energy with spring constant 50 N/m and displacement 1 m");
        assertEquals(0.0, Energy.elasticPotentialEnergy(50, 0), DELTA, "Expected elastic potential energy to be 0 when displacement is 0");
        assertEquals(200.0, Energy.elasticPotentialEnergy(50, 2), DELTA, "Expected elastic potential energy with spring constant 50 N/m and displacement 2 m");
    }

    @Test
    void testWorkDone() {
        assertEquals(70.71, Energy.workDone(100, 1, 45), 1e-2, "Expected work done with force 100 N, displacement 1 m, and angle 45 degrees");
        assertEquals(0.0, Energy.workDone(0, 10, 45), 1e-2, "Expected work done to be 0 when force is 0");
        assertEquals(100.0, Energy.workDone(100, 1, 0), 1e-2, "Expected work done when force and displacement are in same direction");
    }

    @Test
    void testPower() {
        assertEquals(5.0, Energy.power(50, 10), DELTA, "Expected power with work done 50 J and time 10 s");
        assertEquals(Double.POSITIVE_INFINITY, Energy.power(50, 0), DELTA, "Expected infinite power when time is 0");
        assertEquals(0.0, Energy.power(0, 10), DELTA, "Expected power to be 0 when work done is 0");
    }

    @Test
    void testPowerUsingForce() {
        assertEquals(200.0, Energy.powerUsingForce(50, 4), DELTA, "Expected power with force 50 N and velocity 4 m/s");
        assertEquals(0.0, Energy.powerUsingForce(50, 0), DELTA, "Expected power to be 0 when velocity is 0");
        assertEquals(-200.0, Energy.powerUsingForce(-50, 4), DELTA, "Expected negative power when force is negative");
    }

    @Test
    void testMechanicalEnergy() {
        assertEquals(150.0, Energy.mechanicalEnergy(100, 50), DELTA, "Expected mechanical energy as sum of 100 J kinetic and 50 J potential energy");
        assertEquals(0.0, Energy.mechanicalEnergy(0, 0), DELTA, "Expected mechanical energy to be 0 when both kinetic and potential energy are 0");
        assertEquals(500.0, Energy.mechanicalEnergy(250, 250), DELTA, "Expected mechanical energy with 250 J kinetic and 250 J potential energy");
    }
}
