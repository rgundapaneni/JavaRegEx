/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

public class MatchEngineConfig {

    public static void main(String[] args) {

        ignoreCaseExample();
        printSeparator();
        configOptionsExample();
    }

    private static void ignoreCaseExample() {

        String regEx = "(?i)[a-z\\s]+";

        String withUpperCaseLetters  = "This String has upper case letters";
        String withAllLowerCase = "this string has all lower case letters";

        System.out.println(withAllLowerCase + ": " + withAllLowerCase.matches(regEx));
        System.out.println(withUpperCaseLetters + ": " + withUpperCaseLetters.matches(regEx));
    }

    private static void configOptionsExample() {

        String inputString = "My marker is Blue\n" +
                                "it is not red or green";

        boolean matchOnlyIfGreenExists = inputString.matches("(?=.*Green).*Blue.*");
        boolean matchOnlyIfGreenExistsIgnoreCase = inputString.matches("(?i)(?=.*Green).*Blue.*");
        boolean matchOnlyIfGreenExistsDotMatchesNewLine = inputString.matches("(?s)(?=.*Green).*Blue.*");
        boolean matchOnlyIfGreenExistsIgnoreCaseAndDotMatchesNewLine = inputString.matches("(?is)(?=.*Green).*Blue.*");

        System.out.println("Match Only If Green Exists: " + matchOnlyIfGreenExists);
        System.out.println("Match Only If Green Exists And Ignore Case: " + matchOnlyIfGreenExistsIgnoreCase);
        System.out.println("Match Only If Green Exists And Dot Matches New Line: " + matchOnlyIfGreenExistsDotMatchesNewLine);
        System.out.println("Match Only If Green Exists And Ignore Case And Dot Matches New Line: " + matchOnlyIfGreenExistsIgnoreCaseAndDotMatchesNewLine);

    }

    private static void printSeparator() {

        System.out.println("------------------------------------\n");
    }
}
