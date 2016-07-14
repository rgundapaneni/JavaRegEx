/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.word.regex;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AreteWordExtractor {

    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {

        String outputFileName = getContainingDir(FILE_NAME).
                toAbsolutePath().toString() + File.separator + "arete-words.csv";

        String input = readAllFileContent(FILE_NAME);

        parseAllTextAndPrintToFile(input, outputFileName);
    }

    private static void parseAllTextAndPrintToFile(String rawData, String outputFileName) {

        String regex = getHtmlRegex() + "qWord" + getHtmlRegex() + "(\\w+)</span>";
        regex += getHtmlRegex() + "qDef" + getHtmlRegex() + getDefRegex() + "</span>\\s+?</p>";

        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(rawData);
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {

            System.out.println(outputFileName);

            int counter = 1;

            while (matcher.find()) {
                writer.println(String.format("%d,%s,%s", counter, matcher.group(1), matcher.group(2)));
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getHtmlRegex() {

        return "[\\w\\s<>=\"\\-/]+?";
    }

    private static String getDefRegex() {

        return "([\"\\?\\w;\\s)(\\-\\.:/',\\\\`+=&!*]+?)";
    }

    private static String readAllFileContent(String fileName) {

        StringBuffer sb = new StringBuffer();

        try {
            Path sampleFilePath = Paths.get((new AreteWordExtractor()).getClass().getResource(fileName).toURI());
            List<String> allLines = Files.readAllLines(sampleFilePath, Charset.defaultCharset());

            for(String line : allLines) {
                sb.append(line);
            }
        } catch (URISyntaxException|IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    private static Path getContainingDir(String fileName) {

        Path parent = null;

        try {
            parent = Paths.get((new AreteWordExtractor()).getClass().getResource(fileName).toURI()).getParent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return parent;
    }
}