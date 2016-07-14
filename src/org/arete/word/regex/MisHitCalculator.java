/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.word.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MisHitCalculator {

    public static void main(String[] args) {

        Map<String, String> areteWords = loadFileContentsIntoMap("arete-words.csv");
        Map<String, String> dupAreteWords = loadFileContentsIntoMap("arete-words.csv");

        int counter = 1;
        for(String key : dupAreteWords.keySet()) {

            if(!areteWords.containsKey(key)) {
                System.out.println(counter + ": " + key);
                counter++;
            }
        }
    }

    private static Map<String, String> loadFileContentsIntoMap(String fileName) {

        Map<String, String> wordMap = new HashMap<>();

        try {
            BufferedReader reader = Files.newBufferedReader(
                    Paths.get((new MisHitCalculator()).getClass().getResource(fileName).toURI()));

            String line = reader.readLine();
            while (line != null) {

                processLine(line, wordMap);

                line = reader.readLine();
            }
        } catch (IOException|URISyntaxException ex) {
            ex.printStackTrace();
        }

        return wordMap;
    }

    private static void processLine(String line, Map<String, String> wordMap) {

        int index = line.indexOf(",");
        if(index < 0) return;

        line = line.substring(index+1);
        index = line.indexOf(",");
        if(index < 0) {
            if(line != null) {
                wordMap.put(line, "");
            }
            return;
        }

        index = 0;
        int index2 = line.indexOf(",");
        if(index2 < 0) {
            return;
        }
        String key = line.substring(index, index2);
        String value = line.substring(index2+1);

        wordMap.put(key, value);
    }
}
