package com.worldpay.generator;

import com.worldpay.numbers.Notation;

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
public interface Wordifier {

    /**
     * Converts long number to words.
     * @param number number to be processed
     * @return words version of the number
     */
    String wordify(long number);
}
