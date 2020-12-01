import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Taller02UnitTestingTest {
    private Taller02UnitTesting t;
    private double[][] sensor;
    private double[][] esperado;

    @Before
    public void setUp() throws Exception {
        t = new Taller02UnitTesting();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testregistrarIntensidadMayorSismo01(){
        sensor = new double[2][24];
        sensor[0][0] = 3;
        sensor[0][1] = 5;
        sensor[0][2] = 6.5;
        sensor[0][3] = 4.5;
        sensor[1][0] = 3;
        sensor[1][1] = 7;
        sensor[1][2] = 4;
        assertEquals(7,t.registrarIntensidadMayorSismo(sensor),0.1);
    }

    @Test
    public void testregistrarDiaMayorSismo01(){
        sensor = new double[2][24];
        sensor[0][0] = 3;
        sensor[0][1] = 5;
        sensor[0][2] = 6.5;
        sensor[0][3] = 4.5;
        sensor[1][0] = 3;
        sensor[1][1] = 7;
        sensor[1][2] = 4;
        assertEquals(1,t.registrarDiaMayorSismo(sensor),0.1);
    }

    @Test
    public void testRegistrarHoraMayorSismo(){
        sensor = new double[2][24];
        sensor[0][0] = 3;
        sensor[0][1] = 5;
        sensor[0][2] = 6.5;
        sensor[0][3] = 4.5;
        sensor[1][0] = 3;
        sensor[1][1] = 4;
        sensor[1][2] = 7;
        assertEquals(2,t.registrarHoraMayorSismo(sensor),0.1);
    }
}