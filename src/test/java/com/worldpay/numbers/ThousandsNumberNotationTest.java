package com.worldpay.numbers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ThousandsNumberNotationTest {

    private Notation notation;

    @Before
    public void setUp() {
        notation = new ThousandsNumberNotation();
    }

    @Test
    public void testOneThousandGeneration() {
        assertEquals("one thousand", notation.getName(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValuedGenerationThrowsException() {
        notation.getName(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValueThanBaseThrowsException() {
        assertEquals("one thousand", notation.getName(25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCaseThrowsException() {
        notation.getName(0);
    }

    @Test
    public void testSingleDigitNumberThousandTriadGeneration() {
        assertEquals("one thousand", notation.getName(1000));
        assertEquals("five thousand", notation.getName(5000));
        assertEquals("nine thousand", notation.getName(9000));
    }

    @Test
    public void testThousandsWithDecimalNumberGeneration() {
        assertEquals("one thousand", notation.getName(1011));
        assertEquals("five thousand", notation.getName(5015));
        assertEquals("twenty thousand", notation.getName(20020));
        assertEquals("one hundred thousand", notation.getName(100030));
    }

    @Test
    public void testDecimalNumberInThousandsTriadGeneration() {
        assertEquals("one hundred and seventy five thousand", notation.getName(175002));
        assertEquals("five hundred and sixty three thousand", notation.getName(563034));
        assertEquals("one hundred and ten thousand", notation.getName(110456));
        assertEquals("one hundred and five thousand", notation.getName(105001));
        assertEquals("four hundred and thirty thousand", notation.getName(430100));
        assertEquals("nine hundred and ninety nine thousand", notation.getName(999020));
    }
}
