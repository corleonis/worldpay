package com.worldpay.numbers;

/**
 * Notation rule for parsing numbers from 1000000-999999999.
 * This rule has base of 1 million and cannot render zeros.
 */
public class MillionsNumberNotation extends NumberNotation {

    public MillionsNumberNotation() {
        super("million");
    }

    @Override
    public long getBase() {
        return 1000000;
    }

    @Override
    public boolean canRenderZero() {
        return false;
    }
}
