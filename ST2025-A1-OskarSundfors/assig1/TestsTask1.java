package assigs2025.assig1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestsTask1 {

    @Test
    void Tests1() {
        new Calendar(); // line only to cover "public class Calendar" line in Calender.java
        assertEquals(-1, Calendar.calculateDaysInMonth(0, 2024)); // month < 1
        assertEquals(-1, Calendar.calculateDaysInMonth(13, 2024)); // month > 12
        assertEquals(-1, Calendar.calculateDaysInMonth(5, -1)); // year < 0
        assertEquals(28, Calendar.calculateDaysInMonth(2, 2023)); // february, non leap year (28 days)
        assertEquals(29, Calendar.calculateDaysInMonth(2, 2024)); // february, leap year (29 days)
        assertEquals(28, Calendar.calculateDaysInMonth(2, 1900)); // february, non leap year (year % 100 == 0 && year % 400 != 0)
        assertEquals(29, Calendar.calculateDaysInMonth(2, 2000)); // february, leap year (year % 400)
        assertEquals(31, Calendar.calculateDaysInMonth(1, 2025)); // january days
        assertEquals(31, Calendar.calculateDaysInMonth(3, 2025)); // march days
        assertEquals(30, Calendar.calculateDaysInMonth(4, 2025)); // april days
        assertEquals(31, Calendar.calculateDaysInMonth(5, 2025)); // may days
        assertEquals(30, Calendar.calculateDaysInMonth(6, 2025)); // june days
        assertEquals(31, Calendar.calculateDaysInMonth(7, 2025)); // july days
        assertEquals(31, Calendar.calculateDaysInMonth(8, 2025)); // august days
        assertEquals(30, Calendar.calculateDaysInMonth(9, 2025)); // september days
        assertEquals(31, Calendar.calculateDaysInMonth(10, 2025)); // october days
        assertEquals(30, Calendar.calculateDaysInMonth(11, 2025)); // november days
        assertEquals(31, Calendar.calculateDaysInMonth(12, 2025)); // december days
    }
}