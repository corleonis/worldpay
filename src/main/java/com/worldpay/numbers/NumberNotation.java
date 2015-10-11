package com.worldpay.numbers;

import org.apache.log4j.Logger;

public abstract class NumberNotation implements Notation {

    private static final Logger LOG = Logger.getLogger(NumberNotation.class);

    private String numberNotationLabel;

    /**
     * @return number base that can be handled by this notation rule.
     */
    public abstract long getBase();

    /**
     * @return whether this rule can generate word versions for zero numbers
     */
    public abstract boolean canRenderZero();

    protected NumberNotation(final String aNumberNotationLabel) {
        numberNotationLabel = aNumberNotationLabel;
    }

    public String getName(final long aNumber) throws IllegalArgumentException
    {
        // if number is Zero and we can generate it skip rest of the steps
        if (aNumber == 0 && canRenderZero()) {
            return BaseNumbers.ZERO.toString();
        }

        validateNumber(aNumber);

        int number = (int) ((int) aNumber / getBase()) % 1000,
            primaryNumber = getPrimaryNumber(number),
            secondaryNumber = getSecondaryNumber(number),
            tertiaryNumber = getTertiaryNumber(number);

        StringBuilder sb = new StringBuilder();
        if (primaryNumber > 0) {
            sb.append(BaseNumbers.valueOf(primaryNumber))
                    .append(" ")
                    .append(getPrimaryNumberLabel());

            if (secondaryNumber > 0 || tertiaryNumber > 0) {
                sb.append(" ").append(getDelimitingWord()).append(" ");
            }
        }

        if (number < 100 && getBase() == 1 && primaryNumber == 0 && aNumber > 1000) {
            sb.append(getDelimitingWord()).append(" ");
        }

        if (secondaryNumber > 0) {
            sb.append(BaseNumbers.valueOf(secondaryNumber));
            if (tertiaryNumber > 0) {
                sb.append(" ");
            }
        }
        if (tertiaryNumber > 0) {
            sb.append(BaseNumbers.valueOf(tertiaryNumber));
        }
        if (!numberNotationLabel.isEmpty()) {
            sb.append(" ").append(numberNotationLabel);
        }
        return sb.toString();
    }

    public boolean canGenerateNotation(final long aNumber) {
        return aNumber >= getBase() || (aNumber == 0 && canRenderZero());
    }

    private void validateNumber(final long aNumber) {
        if (!canGenerateNotation(aNumber)) {
            LOG.error("Number notation cannot be generated for number " + aNumber
                    + " because it's lower than its base " + getBase());
            throw new IllegalArgumentException("Number notation cannot be generated for number " + aNumber
                    + " because it's lower than its base " + getBase());
        }
    }

    /**
     * Gives us the primary number from the group of
     * three numbers e.g.: (int) 934 / 100 = 9
     * @param aNumber number to be processed
     * @return primary number
     */
    private int getPrimaryNumber(final int aNumber) {
        return aNumber / 100;
    }

    /**
     * Gives us the secondary number as long as it's above or equal to 20
     * so we could generate n-ties range like 20, 30, 40 ... 80, 90
     * @param aNumber number to be processed
     * @return secondary number
     */
    private int getSecondaryNumber(final int aNumber) {
        int secondaryNumberMod = aNumber % 100;
        if (secondaryNumberMod >= 20) {
            return secondaryNumberMod / 10 * 10;
        }

        return 0;
    }

    /**
     * Gives us the last third number. If the Secondary number is zero
     * this means that last two digets are 1{0-9} and we need to generate
     * word for the whole number, e.g.: nineteen, fourteen, etc.
     * Otherwise if the Secondary number is higher than 19 this means we have
     * one word already generated like "thirty" ... and all we have to do is
     * generate last word for the number from {0-9}
     * @param aNumber number to be processed
     * @return tertiary number
     */
    private int getTertiaryNumber(final int aNumber) {
        int secondaryNumberMod = aNumber % 100;
        if (getSecondaryNumber(aNumber) == 0) {
            return secondaryNumberMod;
        }

        return secondaryNumberMod % 10;
    }

    private String getDelimitingWord()
    {
        return "and";
    }

    private String getPrimaryNumberLabel()
    {
        return "hundred";
    }
}
