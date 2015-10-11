package com.worldpay.generator;

import com.worldpay.factory.NumberNotationFactory;
import com.worldpay.numbers.Notation;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;

public class NumberWordifierTest {

    private NumberWordifier wordifier;

    @Before
    public void setUp() {
        NumberNotationFactory notationFactory = new NumberNotationFactory();

        LinkedHashSet<Notation> notations = new LinkedHashSet<Notation>();
        notations.add(notationFactory.get(NumberNotationFactory.HUNDREDS_NOTATION));
        notations.add(notationFactory.get(NumberNotationFactory.THOUSANDS_NOTATION));
        notations.add(notationFactory.get(NumberNotationFactory.MILLIONS_NOTATION));

        wordifier = new NumberWordifier(notations);
    }

    @Test
    public void testBasicWordifierFunctionality() {
        assertEquals("zero", wordifier.wordify(0));
        assertEquals("one", wordifier.wordify(1));
        assertEquals("twenty one", wordifier.wordify(21));
        assertEquals("one hundred and five", wordifier.wordify(105));
        assertEquals("one hundred and twenty three", wordifier.wordify(123));
        assertEquals("one hundred and twenty three", wordifier.wordify(123));
        assertEquals("one thousand and five", wordifier.wordify(1005));
        assertEquals("one thousand and forty two", wordifier.wordify(1042));
        assertEquals("one thousand one hundred and five", wordifier.wordify(1105));
        assertEquals("one hundred and ten thousand two hundred and five", wordifier.wordify(110205));
        assertEquals("seven million one hundred and thirteen thousand five hundred and seventy five",
                wordifier.wordify(7113575));
        assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
                wordifier.wordify(56945781));
        assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
                wordifier.wordify(999999999));
    }

    @Test
    public void testNegativeValuedGenerationThrowsException() {
        String result = wordifier.wordify(-10);
        System.out.println(result);
    }
}
