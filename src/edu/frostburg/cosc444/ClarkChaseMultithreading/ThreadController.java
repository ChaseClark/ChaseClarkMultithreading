package edu.frostburg.cosc444.ClarkChaseMultithreading;


import edu.frostburg.cosc444.ClarkChaseMultithreading.Threads.*;

/*
  Creates a database from file then passes a reference to the database to the newly spawned threads
  so that they can perform actions on the database.
 */
public class ThreadController {
    // This method starts the 8 threads with a set delay in between each one.
    public void go() {
        System.out.println("Populating database from file...");
        NetflixDatabase db = new NetflixDatabase();
        Thread th1 = new Thread(new ThreadRecordCount(db));
        Thread th2 = new Thread(new ThreadAddRandomRecord(db));
        Thread th3 = new Thread(new ThreadDeleteRandomRecord(db));
        Thread th4 = new Thread(new ThreadTotalSeasons(db));
        Thread th5 = new Thread(new ThreadTotalMinutes(db));
        Thread th6 = new Thread(new ThreadLongestShow(db));
        Thread th7 = new Thread(new ThreadShortestShow(db));
        Thread th8 = new Thread(new ThreadRatingTotals(db));

        System.out.println("Starting threads...");
        System.out.println();
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();

        // prevent deadlock
        try {
            th1.join(1000 * 50);
            th2.join(1000 * 20);
            th3.join(1000 * 20);
            th4.join(1000 * 20);
            th5.join(1000 * 20);
            th6.join(1000 * 20);
            th7.join(1000 * 20);
            th8.join(1000 * 20);

            System.out.println();
            System.out.println("All threads have finished.");
        } catch (Exception e) {
           //e.printStackTrace();
        }


    }
}
