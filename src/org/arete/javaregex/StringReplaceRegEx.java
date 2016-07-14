/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplaceRegEx {

    public static void main(String[] args) {

        String sampleText = "Following accounts are disabled: clientId=3456 and clientId=5492, please remove from DB";

        Pattern regEx = Pattern.compile("(clientId=)(\\d+)");
        Matcher matcher = regEx.matcher(sampleText);

        StringBuffer scrambledText = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(scrambledText, matcher.group(1) + "xxxxxx");
            //System.out.println("Look here -> " + scrambledText.toString());
        }
        matcher.appendTail(scrambledText);

        System.out.println("Original Text");
        System.out.println(sampleText);
        System.out.println("Scrambled Text");
        System.out.println(scrambledText.toString());
    }
}
