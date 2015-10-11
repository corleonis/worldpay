package com.worldpay.numbers;

/**
 * Notation rule for parsing numbers from 0-999.
 * This rule has base of 1 but has zero rendering flag to true.
 */
public class HundredsNumberNotation extends NumberNotation {

    /**
     * Default constructor
     */
    public HundredsNumberNotation() {
        super("");
    }

    @Override
    public long getBase()
    {
        return 1;
    }

    @Override
    public boolean canRenderZero()
    {
        return true;
    }
}
