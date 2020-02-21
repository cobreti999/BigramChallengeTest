package com.gohealth.main.business;

import java.util.LinkedHashMap;

public interface NGram {

    /**
     * Generates a n-gram for a given text.
     */
    LinkedHashMap<String, Integer> generate(String text);

    /**
     * Prints the histogram
     */
    void print(LinkedHashMap<String, Integer> histogram);
}
