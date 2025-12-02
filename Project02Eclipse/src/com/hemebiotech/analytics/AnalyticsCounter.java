package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String args[]) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt"));
        String line = reader.readLine();

        int headCount = 0;
        while (line != null) {
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headCount++;
                System.out.println("number of headaches: " + headCount);
            } else if (line.equals("rash")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();
        }
        reader.close();

        ISymptomWriter writer = new WriteSymptomDataToFile();
        Map<String, Integer> symptoms = new HashMap<>();
        symptoms.put("headache", headCount);
        symptoms.put("rash", rashCount);
        symptoms.put("dialated pupils", pupilCount);

        writer.writeSymptoms(symptoms);
    }
}
