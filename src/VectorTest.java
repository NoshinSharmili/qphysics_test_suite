import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import qphysics.Vector;
import qphysics.VectorCalculations;


public class VectorTest {

    private static final double DELTA = 1e-5; // tolerance for floating-point comparisons

    @Test
    void testVectorAdditionTwoVectors() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        Vector result = VectorCalculations.vectorAddition(v1, v2);
        assertEquals(5, result.getX(), DELTA, "Expected x component of vector addition");
        assertEquals(7, result.getY(), DELTA, "Expected y component of vector addition");
        assertEquals(9, result.getZ(), DELTA, "Expected z component of vector addition");
    }

    @Test
    void testVectorAdditionThreeVectors() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        Vector v3 = new Vector(7, 8, 9);
        Vector result = VectorCalculations.vectorAddition(v1, v2, v3);
        assertEquals(12, result.getX(), DELTA, "Expected x component of three-vector addition");
        assertEquals(15, result.getY(), DELTA, "Expected y component of three-vector addition");
        assertEquals(18, result.getZ(), DELTA, "Expected z component of three-vector addition");
    }

    @Test
    void testVectorSubtraction() {
        Vector v1 = new Vector(5, 7, 9);
        Vector v2 = new Vector(2, 4, 6);
        Vector result = VectorCalculations.vectorSubtraction(v1, v2);
        assertEquals(3, result.getX(), DELTA, "Expected x component of vector subtraction");
        assertEquals(3, result.getY(), DELTA, "Expected y component of vector subtraction");
        assertEquals(3, result.getZ(), DELTA, "Expected z component of vector subtraction");
    }

    @Test
    void testDotProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        double result = VectorCalculations.dotProduct(v1, v2);
        assertEquals(32, result, DELTA, "Expected result of dot product");
    }

    @Test
    void testCrossProduct() {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);
        Vector result = VectorCalculations.crossProduct(v1, v2);
        assertEquals(0, result.getX(), DELTA, "Expected x component of cross product");
        assertEquals(0, result.getY(), DELTA, "Expected y component of cross product");
        assertEquals(1, result.getZ(), DELTA, "Expected z component of cross product");
    }

    @Test
    void testMagnitude() {
        Vector v = new Vector(3, 4, 0);
        double result = v.magnitude();
        assertEquals(5, result, DELTA, "Expected magnitude of vector");
    }

    @Test
    void testUnitVector() {
        Vector v = new Vector(3, 4, 0);
        Vector unitVector = v.unitVector();
        assertEquals(0.6, unitVector.getX(), DELTA, "Expected x component of unit vector");
        assertEquals(0.8, unitVector.getY(), DELTA, "Expected y component of unit vector");
        assertEquals(0.0, unitVector.getZ(), DELTA, "Expected z component of unit vector");
    }

    @Test
    void testAngleBetweenVectors() {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);
        double result = VectorCalculations.angleBetweenVectors(v1, v2);
        assertEquals(Math.PI / 2, result, DELTA, "Expected angle between perpendicular vectors");
    }

    @Test
    void testScalarMultiplication() {
        Vector v = new Vector(1, 2, 3);
        double scalar = 2;
        Vector result = VectorCalculations.scalarMultiplication(v, scalar);
        assertEquals(2, result.getX(), DELTA, "Expected x component after scalar multiplication");
        assertEquals(4, result.getY(), DELTA, "Expected y component after scalar multiplication");
        assertEquals(6, result.getZ(), DELTA, "Expected z component after scalar multiplication");
    }

    @Test
    void testProjection() {
        Vector v1 = new Vector(3, 4, 0);
        Vector v2 = new Vector(5, 0, 0);
        Vector result = VectorCalculations.projection(v1, v2);
        assertEquals(3, result.getX(), DELTA, "Expected x component of projection");
        assertEquals(0, result.getY(), DELTA, "Expected y component of projection");
        assertEquals(0, result.getZ(), DELTA, "Expected z component of projection");
    }
}
