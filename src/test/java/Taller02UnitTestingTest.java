import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class Taller02UnitTestingTest {
    private Taller02UnitTesting t;
    private double[][] sensor;

    @Before
    public void setUp() throws Exception {
        t = new Taller02UnitTesting();
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }
}