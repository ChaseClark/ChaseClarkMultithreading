package edu.frostburg.cosc444.ClarkChaseMultithreading;


import edu.frostburg.cosc444.ClarkChaseMultithreading.Threads.ThreadAddRandomRecord;
import edu.frostburg.cosc444.ClarkChaseMultithreading.Threads.ThreadDeleteRandomRecord;
import edu.frostburg.cosc444.ClarkChaseMultithreading.Threads.ThreadRecordCount;

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
        System.out.println("Starting threads...");
        th1.start();
        th2.start();
        th3.start();
        // prevent deadlock
        try {
            th1.join(1000 * 20);
            th2.join(1000 * 20);
            th3.join(1000 * 20);

            System.out.println("All threads have finished.");
        } catch (Exception e) {
           //e.printStackTrace();
        }


    }
}
