package edu.frostburg.cosc444.ClarkChaseMultithreading;

public class Main {

    public static void main(String[] args) {

        // maybe make an extension of the thread class
        System.out.println("Chase Clark Multithreading Project");
        System.out.println("starting program...");
        System.out.println();
        // create a new thread controller and start the threads.
        ThreadController tc = new ThreadController();
        tc.go();
    }
}
