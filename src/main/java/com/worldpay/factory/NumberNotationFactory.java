package com.worldpay.factory;

import com.worldpay.numbers.HundredsNumberNotation;
import com.worldpay.numbers.MillionsNumberNotation;
import com.worldpay.numbers.Notation;
import com.worldpay.numbers.ThousandsNumberNotation;
import org.apache.log4j.Logger;

/**
 * A number notation factory that generates notations for
 * {@link com.worldpay.numbers.HundredsNumberNotation},
 * {@link com.worldpay.numbers.ThousandsNumberNotation}
 * and {@link com.worldpay.numbers.MillionsNumberNotation}
 */
public class NumberNotationFactory implements NotationFactory {

    private static final Logger LOG = Logger.getLogger(NumberNotationFactory.class);

    public static final int HUNDREDS_NOTATION = 0;
    public static final int THOUSANDS_NOTATION = 1;
    public static final int MILLIONS_NOTATION = 2;

    public Notation get(final int type) {
        switch (type) {
            case HUNDREDS_NOTATION: return new HundredsNumberNotation();
            case THOUSANDS_NOTATION: return new ThousandsNumberNotation();
            case MILLIONS_NOTATION: return new MillionsNumberNotation();
            default:
                LOG.error("Invalid number notation type " + type);
                throw new IllegalArgumentException("Invalid number notation type " + type);
        }
    }
}
