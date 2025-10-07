package assigs2025.assig2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTests {

    @Test
    void T1() {
        TaxCalculator2 calculator = new TaxCalculator2();
        double result = calculator.computeTax(50000, new int[]{});
        assertEquals(10000.0, result);
    }

    @Test
    void T2() {
        TaxCalculator2 calculator = new TaxCalculator2();
        double result = calculator.computeTax(120000, new int[]{4,6,7,8,19});
        assertEquals(15000.0, result);
    }

    @Test
    void T3() {
        TaxCalculator2 calculator = new TaxCalculator2();
        double result = calculator.computeTax(15000, new int[]{10,11,12});
        assertEquals(0.0, result);
    }

}

