/**
 * Copyright (c) aretelife.org, 2015. All Rights Reserved.
 */
package org.arete.javaregex;

import java.util.regex.Pattern;

public class LookAheadAndLookBehindRegEx {

    public static void main(String[] args) {

        lookAheadExample();
    }

    private static void lookAheadExample() {

        //Look ahead equality
        String expr = "^(?=.*[0-9].*[0-9])[A-Za-z0-9]{8,12}$";
        //Look ahead negation
        //String expr = "^(?!.*[0-9].*[0-9])[A-Za-z0-9]{8,12}$";

        String pwd2 = "p4ssw0rd";
        String pwd1 = "password";
        String pwd3 = "passw0rd";
        String pwd4 = "pass45word";


        Pattern pattern = Pattern.compile(expr);
        System.out.println(pwd1 + " is match: " + pattern.matcher(pwd1).matches());
        System.out.println(pwd2 + " is match: " + pattern.matcher(pwd2).matches());
        System.out.println(pwd3 + " is match: " + pattern.matcher(pwd3).matches());
        System.out.println(pwd4 + " is match: " + pattern.matcher(pwd4).matches());
    }
}
