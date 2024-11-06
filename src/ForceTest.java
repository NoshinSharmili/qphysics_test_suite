import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.Force;

public class ForceTest {

    private static final double DELTA = 1e-5; // Tolerance for floating-point comparisons

    @Test
    void testForce() {
        double result = Force.force(10, 9.81); // mass = 10 kg, acceleration = 9.81 m/s^2
        assertEquals(98.1, result, DELTA, "Expected force with mass 10 kg and acceleration 9.81 m/s^2");
    }

    @Test
    void testGravitationalForce() {
        double result = Force.gravitationalForce(5.972e24, 7.348e22, 384400000); // Earth and Moon
        assertEquals(1.982110729079252E20, result, DELTA, "Expected gravitational force between Earth and Moon");
    }

    @Test
    void testFriction() {
        double result = Force.friction(0.5, 100); // coefficient = 0.5, normal force = 100 N
        assertEquals(50, result, DELTA, "Expected frictional force with coefficient 0.5 and normal force 100 N");
    }

    @Test
    void testSpringForce() {
        double result = Force.springForce(200, 0.1); // spring constant = 200 N/m, displacement = 0.1 m
        assertEquals(-20, result, DELTA, "Expected spring force with spring constant 200 N/m and displacement 0.1 m");
    }

    @Test
    void testCentripetalForce() {
        double result = Force.centripetalForce(2, 10, 5); // mass = 2 kg, velocity = 10 m/s, radius = 5 m
        assertEquals(40, result, DELTA, "Expected centripetal force with mass 2 kg, velocity 10 m/s, and radius 5 m");
    }

    @Test
    void testElectrostaticForce() {
        double result = Force.electrostaticForce(1e-6, 2e-6, 0.05); // charges = 1e-6 C, 2e-6 C, distance = 0.05 m
        assertEquals(7.19004, result, DELTA, "Expected electrostatic force between two charges of 1e-6 C and 2e-6 C separated by 0.05 m");
    }

    @Test
    void testDragForce() {
        double result = Force.dragForce(0.47, 1.225, 10, 0.5); // drag coefficient = 0.47, fluid density = 1.225 kg/m^3, velocity = 10 m/s, area = 0.5 m^2
        assertEquals(14.39374, result, DELTA, "Expected drag force with coefficient 0.47, density 1.225 kg/m^3, velocity 10 m/s, and area 0.5 m^2");
    }

    @Test
    void testTorque() {
        double result = Force.torque(50, 2); // force = 50 N, distance = 2 m
        assertEquals(100, result, DELTA, "Expected torque with force 50 N and distance 2 m");
    }

    @Test
    void testNetForce() {
        double[] forces = {10, -5, 15, -3}; // Individual forces in newtons
        double result = Force.netForce(forces);
        assertEquals(17, result, DELTA, "Expected net force for forces {10, -5, 15, -3}");
    }
}
