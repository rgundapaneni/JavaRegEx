/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SSNRegex {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                                "123456789",
                                "9876-5-4321",
                                "987-65-4321 (attack)",
                                "987-65-4321 ",
                                "192-83-7465");


        Pattern regEx = Pattern.compile("^(\\d{3})-?(\\d{2})-?(\\d{4})$");
        for (String word : words) {
            if(regEx.matcher(word).matches()) {
                System.out.println("SSN is in correct format: " + word);
            }
        }
    }
}
