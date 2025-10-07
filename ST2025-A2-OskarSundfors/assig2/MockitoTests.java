package assigs2025.assig2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    Exemption exemptionMock; // mock instance of exemption

    @InjectMocks
    TaxCalculator2 calculator; // inject to taxcalculator2


    // 4 children (2 under 18)
    // When there are 4 children with ages 10, 12, 18, 20, the mock is called twice
    @Test
    public void test1() {
        int[] ages = {10, 12, 18, 20};
        double income = 80000;
        // 2 children -> expected getExemptionValue 1, 2
        when(exemptionMock.getExemptionValue(1)).thenReturn(5000.0);
        when(exemptionMock.getExemptionValue(2)).thenReturn(5000.0);

        double result = calculator.computeTax(income, ages);
        double expectedTax = 80000 * 0.2 - (5000 + 5000); // 16 000 - 10 000 = 6000
        expectedTax = Math.max(0, expectedTax);
        assertEquals(expectedTax, result);

        InOrder inOrder = inOrder(exemptionMock); // verify correct order
        inOrder.verify(exemptionMock).getExemptionValue(1);
        inOrder.verify(exemptionMock).getExemptionValue(2);
        verifyNoMoreInteractions(exemptionMock); // check no more calls to the mock happened
    }

    // 5 children (4 under 18)
    // When there are 5 children with ages 7, 11, 13, 15, 19 the method is called 4 times
    @Test
    public void test2() {
        int[] ages = {7, 11, 13, 15, 19};
        double income = 80000;
        // 4 children = 5000 * 3 + 6000
        when(exemptionMock.getExemptionValue(1)).thenReturn(5000.0);
        when(exemptionMock.getExemptionValue(2)).thenReturn(5000.0);
        when(exemptionMock.getExemptionValue(3)).thenReturn(5000.0);
        when(exemptionMock.getExemptionValue(4)).thenReturn(6000.0);

        double result = calculator.computeTax(income, ages);
        double expectedTax = 80000 * 0.2 - (5000 * 3) - 6000; // 16 000 - 21 000 = -5000 -> 0
        expectedTax = Math.max(0, expectedTax);
        assertEquals(expectedTax, result);

        InOrder inOrder = inOrder(exemptionMock);
        inOrder.verify(exemptionMock).getExemptionValue(1);
        inOrder.verify(exemptionMock).getExemptionValue(2);
        inOrder.verify(exemptionMock).getExemptionValue(3);
        inOrder.verify(exemptionMock).getExemptionValue(4);
        verifyNoMoreInteractions(exemptionMock);
    }

    // 3 children all over 18
    // Three children of ages 19, 22, 24 and check that getExemptionValue() is never called.
    @Test
    public void test3() {
        int[] ages = {19, 22, 24}; // all over 18
        double income = 80000;
        double result = calculator.computeTax(income, ages);

        double expectedTax = 80000 * 0.2; // 16 000
        assertEquals(expectedTax, result);

        verifyNoInteractions(exemptionMock); // check no interactions with mock happened
    }
}
