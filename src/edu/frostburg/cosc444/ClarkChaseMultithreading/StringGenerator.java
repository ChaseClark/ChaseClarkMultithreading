package edu.frostburg.cosc444.ClarkChaseMultithreading;

import java.util.Random;

public class StringGenerator {

    /**
     * Generates a string with randomized letters with the specified length.
     * @param length
     */
    public static String StringWithLength(int length){
        String possibleValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        if (length < 1) return null;
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(possibleValues.charAt(rand.nextInt(possibleValues
                    .length())));
        }

        return sb.toString();
    }
}
