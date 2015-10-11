package com.worldpay.factory;

import com.worldpay.numbers.HundredsNumberNotation;
import com.worldpay.numbers.MillionsNumberNotation;
import com.worldpay.numbers.Notation;
import com.worldpay.numbers.ThousandsNumberNotation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberNotationFactoryTest {

    @Test
    public void testValidNotationParserForHundreds() {
        Notation notation = (new NumberNotationFactory()).get(NumberNotationFactory.HUNDREDS_NOTATION);
        assertTrue(notation instanceof HundredsNumberNotation);
    }

    @Test
    public void testValidNotationParserForThousands() {
        Notation notation = (new NumberNotationFactory()).get(NumberNotationFactory.THOUSANDS_NOTATION);
        assertTrue(notation instanceof ThousandsNumberNotation);
    }

    @Test
    public void testValidNotationParserForMillions() {
        Notation notation = (new NumberNotationFactory()).get(NumberNotationFactory.MILLIONS_NOTATION);
        assertTrue(notation instanceof MillionsNumberNotation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNotationThrowsException() {
        (new NumberNotationFactory()).get(99);
    }
}
