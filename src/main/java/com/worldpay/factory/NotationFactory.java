package com.worldpay.factory;

import com.worldpay.numbers.Notation;

/**
 * Notation factory interface for generating a number notation rule.
 */
public interface NotationFactory {

    /**
     * Base method for generating a number notation for given type.
     * @param type type
     * @return number notation
     */
    Notation get(final int type);
}
