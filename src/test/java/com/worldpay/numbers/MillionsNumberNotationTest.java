package com.worldpay.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MillionsNumberNotationTest {

    private Notation notation;

    @Before
    public void setUp() {
        notation = new MillionsNumberNotation();
    }

    @Test
    public void testOneMillionGeneration() {
        assertEquals("one million", notation.getName(1000000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValuedGenerationThrowsException() {
        assertEquals("one hundred", notation.getName(-10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValueThanBaseThrowsException() {
        assertEquals("one million", notation.getName(25));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCaseThrowsException() {
        notation.getName(0);
    }

    @Test
    public void testSingleDigitNumberMillionTriadGeneration() {
        assertEquals("one million", notation.getName(1000000));
        assertEquals("five million", notation.getName(5000000));
        assertEquals("nine million", notation.getName(9000000));
    }

    @Test
    public void testMillionsWithDecimalNumberGeneration() {
        assertEquals("one million", notation.getName(1000011));
        assertEquals("five million", notation.getName(5000015));
        assertEquals("twenty million", notation.getName(20000020));
        assertEquals("one hundred million", notation.getName(100000030));
    }

    @Test
    public void testDecimalNumberInMillionsTriadGeneration() {
        assertEquals("one hundred and seventy five million", notation.getName(175000002));
        assertEquals("five hundred and sixty three million", notation.getName(563000034));
        assertEquals("one hundred and ten million", notation.getName(110000456));
        assertEquals("one hundred and five million", notation.getName(105000001));
        assertEquals("four hundred and thirty million", notation.getName(430000100));
        assertEquals("nine hundred and ninety nine million", notation.getName(999000020));
    }
}
