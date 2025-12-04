package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /**
     * Main application entry point.
     */
    public static void main(String args[]) throws Exception {

        ISymptomWriter writer = new WriteSymptomDataToFile();

        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");

        AnalyticsCounter counter = new AnalyticsCounter(writer, reader);

        List<String> symptoms = counter.getSymptoms();

        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);

        counter.writeSymptoms(sortedSymptoms);

        System.out.println("Symptoms successfully added to result.out");
    }
}
