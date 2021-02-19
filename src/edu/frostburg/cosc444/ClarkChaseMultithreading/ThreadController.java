package edu.frostburg.cosc444.ClarkChaseMultithreading;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
  Creates a database from file then passes a reference to the database to the newly spawned threads
  so that they can perform actions on the database.
 */
public class ThreadController {


    // This method starts the 8 threads with a set delay in between each one.
    public void go() {
        System.out.println("Populating database from file...");
        NetflixDatabase db = new NetflixDatabase();

        System.out.println("Starting threads...");
    }
}
