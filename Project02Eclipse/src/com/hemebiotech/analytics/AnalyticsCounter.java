package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class handles the analytics process:
 * - reading symptoms
 * - counting occurrences of symptom
 * - sorting symptoms in order
 * - writing results to a file
 */
public class AnalyticsCounter {

    private ISymptomWriter writer;
    private ISymptomReader reader;

    /**
     * Creates a new AnalyticsCounter with a reader and a writer.
     *
     * @param writer an object that writes symptoms to an output file
     * @param reader an object that reads symptoms from an input file
     */
    public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    /**
     * Reads and returns the list of symptoms.
     *
     * @return a List of symptom strings
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Writes the final list of symptoms and their counts.
     *
     * @param symptoms a Map containing symptoms as keys and their frequency as values
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    /**
     * Counts how many times each symptom appears in the list.
     *
     * @param listOfSymptoms the list of symptoms read from the file
     * @return a Map with each symptom and its number of occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> listOfSymptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();

        for (String symptom : listOfSymptoms) {
            if (symptomCount.containsKey(symptom)) {
                symptomCount.put(symptom, symptomCount.get(symptom) + 1);
            } else {
                symptomCount.put(symptom, 1);
            }
        }
        return symptomCount;
    }

    /**
     * Sorts the symptoms alphabetically.
     *
     * @param symptoms an unsorted Map of symptoms and their counts
     * @return a TreeMap that contains the same data sorted by keys
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }



}
