/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingStringRegEx {

    public static void main(String[] args) {

        String sample = "I have a cat, but I like my dog better.";

        Matcher matcher = Pattern.compile("mouse|cat|dog|wolf|bear|human").matcher(sample);

        StringJoiner animals = new StringJoiner(" : ", "( ", " )");
        while (matcher.find()) {

            System.out.println("Found a " + matcher.group());
            animals.add(matcher.group());
        }

        System.out.println(animals.toString());
    }
}
