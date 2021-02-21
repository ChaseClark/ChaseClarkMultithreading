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
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(possibleValues.charAt(random.nextInt(possibleValues
                    .length())));
        }

        return sb.toString();
    }

    // generates a random rating from a list of choices
    public static String RandomRating(){
        String rating = "";
        var ratings = new String[]{"TV-Y","G","TV-G","TV-PG","PG","TV-Y7","PG-13","TV-14","TV-MA","R","NR","NC-17"};
        Random random = new Random();
        rating = ratings[random.nextInt(ratings.length-1)];
        return rating;
    }

    // generates a random runtime of the show/movie in either minutes or seasons format
    public static String RandomDuration(){
        String duration = "";
        int choice = randomIntRange(0,100);
        if (choice >= 50){
            // duration in minutes
            duration = randomIntRange(29,170)+" min";
        } else {
            // duration in seasons
            duration = randomIntRange(2,7)+" Seasons";
        }
        return duration;
    }


    public static String RandomReleaseYear(){
        return Integer.toString(randomIntRange(1920,2021));
    }

    // returns an int in a specified range of numbers
    private static int randomIntRange(int min, int max) {
        return (int) ((Math.random() * (max-min)) + min);
    }
}
