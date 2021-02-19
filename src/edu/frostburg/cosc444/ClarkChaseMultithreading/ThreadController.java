package edu.frostburg.cosc444.ClarkChaseMultithreading;


import edu.frostburg.cosc444.ClarkChaseMultithreading.Threads.ThreadRecordCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
  Creates a database from file then passes a reference to the database to the newly spawned threads
  so that they can perform actions on the database.
 */
public class ThreadController {
    private ExecutorService _pool;

    // This method starts the 8 threads with a set delay in between each one.
    public void go() {
        System.out.println("Populating database from file...");
        NetflixDatabase db = new NetflixDatabase();

        System.out.println("Starting threads...");
        _pool = Executors.newFixedThreadPool(8);
        // use ExecutorService to start threads safely
        _pool.execute(new ThreadRecordCount(db));

    }
}
