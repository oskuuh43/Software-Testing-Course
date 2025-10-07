
package assigs2025.assig1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestsTask2 {

    @Test
    void T1() {
        new TaxCalculator(); // line only to cover "public class TaxCalculator" line in TaxCalculator.java 
        // test path: [1,2,3,4,11,12,14]
        double income = 0;
        int[] childAgeList = {};
        double expectedTax = 0;

        double result = TaxCalculator.computeTax(income, childAgeList);
        assertEquals(expectedTax, result);
    }

    @Test
    void T2() {
        // test path: [1,2,3,4,5,6,7,8,10,3,4,5,6,7,8,10,3,4,5,6,7,8,10,3,4,5,6,7,8,10,3,4,5,6,7,9,10,3,4,5,10,3,4,11,12,13]
        double income = 100000;
        int[] childAgeList = {1, 2, 3, 4, 5, 20}; // 5 minors
        double expectedTax = 2000;

        double result = TaxCalculator.computeTax(income, childAgeList);
        assertEquals(expectedTax, result);
    }
}

    