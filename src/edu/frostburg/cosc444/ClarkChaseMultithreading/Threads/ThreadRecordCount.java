package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;


/*
    This thread counts the total amount of records in the database and prints to console.
 */
public class ThreadRecordCount implements Runnable {
    private NetflixDatabase _db;

    public ThreadRecordCount(NetflixDatabase db) {
        _db = db;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadRecordCount starting...");
            while (true){ // run forever
                Thread.sleep(4000); // simulate work for 6 seconds
                System.out.println("(1)ThreadRecordCount: There are currently "+_db.getCount()+
                        " records in the database.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
