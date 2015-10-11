package com.worldpay.generator;

import com.worldpay.numbers.Notation;
import org.apache.log4j.Logger;

import java.util.LinkedHashSet;

/**
 * This class is capable of rendering a given number into words in English.
 * It is following the grammatical rules and generates fully qualified number names.
 * <br />
 * The class takes as an init parameter a unique and ordered set of {@link Notation}s
 * that are used to apply different rules on the number and generate words representation.
 * <br />
 * The order of the {@link Notation}s is important and should be from small to big numbers,
 * e.g.: Hundreds, Thousands, Millions, Billions, etc.
 */
public class NumberWordifier implements Wordifier {

    private static final Logger LOG = Logger.getLogger(NumberWordifier.class);

    private LinkedHashSet<Notation> numberNotations;

    /**
     * Default constructor
     * @param aNumberNotation Unique and ordered set of notations to be used
     *                        to apply rules for number to word generation.
     * @throws IllegalArgumentException if notations set is empty
     */
    public NumberWordifier(final LinkedHashSet<Notation> aNumberNotation) throws IllegalArgumentException
    {
        if (aNumberNotation.isEmpty()) {
            LOG.error("Number notations set cannot be empty!");
            throw new IllegalArgumentException("Number notations set cannot be empty!");
        }

        numberNotations = aNumberNotation;
    }

    /**
     * This method transforms a given number into words.
     * @param number number to be processed.
     * @return word representation of the number
     */
    public String wordify(final long number) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        String numberNotation;
        for (Notation converter : numberNotations) {
            if (converter.canGenerateNotation(number)) {
                numberNotation = converter.getName(number);

                if (!first) {
                    sb.insert(0, " ");
                }
                sb.insert(0, numberNotation);
            }

            first = false;
        }

        return sb.toString();
    }
}
