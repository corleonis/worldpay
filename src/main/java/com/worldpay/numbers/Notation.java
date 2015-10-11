package com.worldpay.numbers;

/**
 * Number notation rule that can render a words representation of
 * a given number for specific base. The base of the rule defines the
 * range of numbers that can be parsed by this rule, e.g.:
 * <ul>
 *     <li>1 - means that numbers from 1 / 999 can be rendered</li>
 *     <li>1000 - means that numbers from 1000 / 999999 can be rendered</li>
 *     <li>n - means that numbers from n / (n*1000)-1 can be rendered</li>
 * </ul>
 * <br />
 * If <code>canRenderZero()</code> returns true this instance can handle zero
 * generation, this is normally needed only for decimal numbers or up to hundreds.
 * If there is more than one notation that can render zeros this might generate
 * unexpected results.
 */
public interface Notation {

    /**
     * Reneder a number into words based on the given rules.
     * @param number number to be processed
     * @return words version of the number
     * @throws IllegalArgumentException if the rule cannot parse the
     *         number an exception will be thrown
     */
    String getName(long number) throws IllegalArgumentException;

    /**
     * Check if current rule can parse/generate the given number.
     * This method should be called right before calling <code>getName()</code>
     * to verify that the operation can be executed for the given number.
     * @param number number to be processed
     * @return whether a number can be processed
     */
    boolean canGenerateNotation(long number);

    /**
     * @return whether this rule can generate word versions for zero numbers
     */
    boolean canRenderZero();

    /**
     * @return number base that can be handled by this notation rule.
     */
    long getBase();
}
