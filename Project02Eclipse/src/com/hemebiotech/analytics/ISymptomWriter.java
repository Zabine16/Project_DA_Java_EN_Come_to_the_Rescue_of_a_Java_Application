package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptoms and their occurrence counts to an output.
 */

public interface ISymptomWriter {

    /**
     * Writes the final map of symptoms and counts.
     * @param symptoms map of symptom names and their counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
