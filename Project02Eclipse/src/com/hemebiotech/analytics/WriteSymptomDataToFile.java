package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptoms and their occurrence count into result.out
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Writes symptoms to result.out in alphabetical order.
     * @param symptoms map of symptoms and their respective counts
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter("result.out");
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
