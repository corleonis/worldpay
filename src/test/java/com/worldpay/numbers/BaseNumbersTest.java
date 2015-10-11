package com.worldpay.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseNumbersTest {

    @Test
    public void testNumberEnumHaveCorrectValues() {
        assertEquals(0, BaseNumbers.ZERO.getValue());
        assertEquals(1, BaseNumbers.ONE.getValue());
        assertEquals(2, BaseNumbers.TWO.getValue());
        assertEquals(3, BaseNumbers.THREE.getValue());
        assertEquals(4, BaseNumbers.FOUR.getValue());
        assertEquals(5, BaseNumbers.FIVE.getValue());
        assertEquals(6, BaseNumbers.SIX.getValue());
        assertEquals(7, BaseNumbers.SEVEN.getValue());
        assertEquals(8, BaseNumbers.EIGHT.getValue());
        assertEquals(9, BaseNumbers.NINE.getValue());
        assertEquals(10, BaseNumbers.TEN.getValue());
        assertEquals(11, BaseNumbers.ELEVEN.getValue());
        assertEquals(12, BaseNumbers.TWELVE.getValue());
        assertEquals(13, BaseNumbers.THIRTEEN.getValue());
        assertEquals(14, BaseNumbers.FOURTEEN.getValue());
        assertEquals(15, BaseNumbers.FIFTEEN.getValue());
        assertEquals(16, BaseNumbers.SIXTEEN.getValue());
        assertEquals(17, BaseNumbers.SEVENTEEN.getValue());
        assertEquals(18, BaseNumbers.EIGHTEEN.getValue());
        assertEquals(19, BaseNumbers.NINETEEN.getValue());

        assertEquals(20, BaseNumbers.TWENTY.getValue());
        assertEquals(30, BaseNumbers.THIRTY.getValue());
        assertEquals(40, BaseNumbers.FORTY.getValue());
        assertEquals(50, BaseNumbers.FIFTY.getValue());
        assertEquals(60, BaseNumbers.SIXTY.getValue());
        assertEquals(70, BaseNumbers.SEVENTY.getValue());
        assertEquals(80, BaseNumbers.EIGHTY.getValue());
        assertEquals(90, BaseNumbers.NINETY.getValue());
    }

    @Test
    public void testNumberEnumHaveCorrectLabels() {
        assertEquals("zero", BaseNumbers.ZERO.toString());
        assertEquals("one", BaseNumbers.ONE.toString());
        assertEquals("two", BaseNumbers.TWO.toString());
        assertEquals("three", BaseNumbers.THREE.toString());
        assertEquals("four", BaseNumbers.FOUR.toString());
        assertEquals("five", BaseNumbers.FIVE.toString());
        assertEquals("six", BaseNumbers.SIX.toString());
        assertEquals("seven", BaseNumbers.SEVEN.toString());
        assertEquals("eight", BaseNumbers.EIGHT.toString());
        assertEquals("nine", BaseNumbers.NINE.toString());
        assertEquals("ten", BaseNumbers.TEN.toString());
        assertEquals("eleven", BaseNumbers.ELEVEN.toString());
        assertEquals("twelve", BaseNumbers.TWELVE.toString());
        assertEquals("thirteen", BaseNumbers.THIRTEEN.toString());
        assertEquals("fourteen", BaseNumbers.FOURTEEN.toString());
        assertEquals("fifteen", BaseNumbers.FIFTEEN.toString());
        assertEquals("sixteen", BaseNumbers.SIXTEEN.toString());
        assertEquals("seventeen", BaseNumbers.SEVENTEEN.toString());
        assertEquals("eighteen", BaseNumbers.EIGHTEEN.toString());
        assertEquals("nineteen", BaseNumbers.NINETEEN.toString());

        assertEquals("twenty", BaseNumbers.TWENTY.toString());
        assertEquals("thirty", BaseNumbers.THIRTY.toString());
        assertEquals("forty", BaseNumbers.FORTY.toString());
        assertEquals("fifty", BaseNumbers.FIFTY.toString());
        assertEquals("sixty", BaseNumbers.SIXTY.toString());
        assertEquals("seventy", BaseNumbers.SEVENTY.toString());
        assertEquals("eighty", BaseNumbers.EIGHTY.toString());
        assertEquals("ninety", BaseNumbers.NINETY.toString());
    }

    @Test
    public void testStaticConstructorGeneratesCorrectNumberForLongNumber() {
        assertEquals("zero", BaseNumbers.valueOf(0).toString());
        assertEquals("one", BaseNumbers.valueOf(1).toString());
        assertEquals("two", BaseNumbers.valueOf(2).toString());
        assertEquals("three", BaseNumbers.valueOf(3).toString());
        assertEquals("four", BaseNumbers.valueOf(4).toString());
        assertEquals("five", BaseNumbers.valueOf(5).toString());
        assertEquals("six", BaseNumbers.valueOf(6).toString());
        assertEquals("seven", BaseNumbers.valueOf(7).toString());
        assertEquals("eight", BaseNumbers.valueOf(8).toString());
        assertEquals("nine", BaseNumbers.valueOf(9).toString());
        assertEquals("ten", BaseNumbers.valueOf(10).toString());
        assertEquals("eleven", BaseNumbers.valueOf(11).toString());
        assertEquals("twelve", BaseNumbers.valueOf(12).toString());
        assertEquals("thirteen", BaseNumbers.valueOf(13).toString());
        assertEquals("fourteen", BaseNumbers.valueOf(14).toString());
        assertEquals("fifteen", BaseNumbers.valueOf(15).toString());
        assertEquals("sixteen", BaseNumbers.valueOf(16).toString());
        assertEquals("seventeen", BaseNumbers.valueOf(17).toString());
        assertEquals("eighteen", BaseNumbers.valueOf(18).toString());
        assertEquals("nineteen", BaseNumbers.valueOf(19).toString());

        assertEquals("twenty", BaseNumbers.valueOf(20).toString());
        assertEquals("thirty", BaseNumbers.valueOf(30).toString());
        assertEquals("forty", BaseNumbers.valueOf(40).toString());
        assertEquals("fifty", BaseNumbers.valueOf(50).toString());
        assertEquals("sixty", BaseNumbers.valueOf(60).toString());
        assertEquals("seventy", BaseNumbers.valueOf(70).toString());
        assertEquals("eighty", BaseNumbers.valueOf(80).toString());
        assertEquals("ninety", BaseNumbers.valueOf(90).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValueOfBaseNumberThrowsException() {
        BaseNumbers.valueOf(21);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbove90ValueOfBaseNumberThrowsException() {
        BaseNumbers.valueOf(91);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValueOfBaseNumberThrowsException() {
        BaseNumbers.valueOf(-2);
    }
}
