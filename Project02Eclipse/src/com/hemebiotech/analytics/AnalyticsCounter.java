package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomWriter writer;
    private ISymptomReader reader;

    public AnalyticsCounter(ISymptomWriter writer, ISymptomReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }


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

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }



}
