package com.worldpay.numbers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HundredsNumberNotationTest {

    private Notation notation;

    @Before
    public void setUp() {
        notation = new HundredsNumberNotation();
    }

    @Test
    public void testOneHundredGeneration() {
        assertEquals("one hundred", notation.getName(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValuedGenerationThrowsException() {
        notation.getName(-10);
    }

    @Test
    public void testSingleDigitNumberGeneration() {
        assertEquals("zero", notation.getName(0));
        assertEquals("five", notation.getName(5));
        assertEquals("nine", notation.getName(9));
    }

    @Test
    public void testDecimalNumberGeneration() {
        assertEquals("eleven", notation.getName(11));
        assertEquals("fifteen", notation.getName(15));
        assertEquals("twenty", notation.getName(20));
        assertEquals("thirty", notation.getName(30));
        assertEquals("thirty five", notation.getName(35));
        assertEquals("ninety nine", notation.getName(99));
    }

    @Test
    public void testHundredsAndDecimalNumberGeneration() {
        assertEquals("one hundred and seventy five", notation.getName(175));
        assertEquals("five hundred and sixty three", notation.getName(563));
        assertEquals("one hundred and ten", notation.getName(110));
        assertEquals("one hundred and five", notation.getName(105));
        assertEquals("four hundred and thirty", notation.getName(430));
        assertEquals("nine hundred and ninety nine", notation.getName(999));
    }

    @Test
    public void testThousandsNumberPassedGeneratesCorrectHundredsNotation() {
        assertEquals("and twenty five", notation.getName(1025));
        assertEquals("and five", notation.getName(23005));
        assertEquals("and fifty five", notation.getName(21023055));
    }
}
