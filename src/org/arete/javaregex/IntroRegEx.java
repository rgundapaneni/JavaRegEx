/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntroRegEx {

    public static void main(String[] args) {

        matchWholeString();
        printSeparator();
        playWithNewLineString();
        printSeparator();
        findPartsOfJavaPackage();
    }

    private static void processString(String inputString) {

        Pattern regEx = Pattern.compile("I lost my:? (wallet|car|cell phone|marbles)");

        Matcher matcher = regEx.matcher(inputString);
        boolean result = matcher.matches();
        System.out.println(inputString + " - match result " + result);
        if (result) {
            System.out.println("Matched Word: " + matcher.group(1));
        }
    }

    private static void playWithNewLineString() {

        String withoutNewLine = "My Name is John Doe";
        System.out.println(withoutNewLine + " = " + withoutNewLine.matches(".+"));
        String withNewLine = "My Name is \n John Doe";
        System.out.println(withNewLine + " = " + withNewLine.matches(".+\\s.+"));
    }

    private static void findPartsOfJavaPackage() {

        Package packag = (new IntroRegEx()).getClass().getPackage();
        System.out.println("Package name: " + packag.getName());

        Matcher matcher = Pattern.compile("(\\w+)").matcher(packag.getName());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void printSeparator() {

        System.out.println("------------------------------------\n");
    }

    private static void matchWholeString() {

        processString("I lost my wallet");
        processString("I lost my wallets");
        processString("I lost my: car");
        processString("I lost my- car");
        processString("I lost my: cell");
        processString("I lost my: cell phone");
        processString("I lost my cell phone");
        processString("I lost my marbles");
    }
}
