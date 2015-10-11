package com.worldpay.numbers;

import org.apache.log4j.Logger;

/**
 * This is a simple base numbers representation with value and label
 * for numbers from 1 to 19 and 20, 30, ... 80, 90
 */
public enum BaseNumbers {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SIXTEEN(16),
    SEVENTEEN(17),
    EIGHTEEN(18),
    NINETEEN(19),
    TWENTY(20),
    THIRTY(30),
    FORTY(40),
    FIFTY(50),
    SIXTY(60),
    SEVENTY(70),
    EIGHTY(80),
    NINETY(90);

    private static final Logger LOG = Logger.getLogger(BaseNumbers.class);

    private long value;

    BaseNumbers(final long aValue) {
        value = aValue;
    }

    public static BaseNumbers valueOf(final int aNumber) {
        if (aNumber > 19 && aNumber <= 90 && aNumber % 10 != 0) {
            LOG.error("There is no matching BaseNumber with value of " + aNumber);
            throw new IllegalArgumentException("There is no matching BaseNumber with value of " + aNumber);
        } else if (aNumber < 0 || aNumber > 90) {
            LOG.error("There is no matching BaseNumber with value of " + aNumber);
            throw new IllegalArgumentException("There is no matching BaseNumber with value of " + aNumber);
        }
        
        BaseNumbers number = null;
        switch (aNumber) {
            case 0: number = ZERO; break;
            case 1: number = ONE; break;
            case 2: number = TWO; break;
            case 3: number = THREE; break;
            case 4: number = FOUR; break;
            case 5: number = FIVE; break;
            case 6: number = SIX; break;
            case 7: number = SEVEN; break;
            case 8: number = EIGHT; break;
            case 9: number = NINE; break;
            case 10: number = TEN; break;
            case 11: number = ELEVEN; break;
            case 12: number = TWELVE; break;
            case 13: number = THIRTEEN; break;
            case 14: number = FOURTEEN; break;
            case 15: number = FIFTEEN; break;
            case 16: number = SIXTEEN; break;
            case 17: number = SEVENTEEN; break;
            case 18: number = EIGHTEEN; break;
            case 19: number = NINETEEN; break;
            case 20: number = TWENTY; break;
            case 30: number = THIRTY; break;
            case 40: number = FORTY; break;
            case 50: number = FIFTY; break;
            case 60: number = SIXTY; break;
            case 70: number = SEVENTY; break;
            case 80: number = EIGHTY; break;
            case 90: number = NINETY; break;
        }

        return number;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
