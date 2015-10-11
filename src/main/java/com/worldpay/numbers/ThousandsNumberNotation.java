package com.worldpay.numbers;

/**
 * Notation rule for parsing numbers from 1000-999999.
 * This rule has base of 1 thousand and cannot render zeros.
 */
public class ThousandsNumberNotation extends NumberNotation {

    public ThousandsNumberNotation() {
        super("thousand");
    }

    @Override
    public long getBase() {
        return 1000;
    }

    @Override
    public boolean canRenderZero() {
        return false;
    }
}
