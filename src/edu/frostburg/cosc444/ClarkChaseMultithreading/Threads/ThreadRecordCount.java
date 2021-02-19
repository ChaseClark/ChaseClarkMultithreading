package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

import java.util.ArrayList;

/*
    This thread counts the total amount of records in the database and prints to console.
 */
public class ThreadRecordCount implements Runnable {
    private ArrayList<NetflixShow> _db;

    public ThreadRecordCount(ArrayList<NetflixShow> db) {
        _db = db;
    }

    @Override
    public void run() {
        try {
            while (true){ // run forever
                Thread.sleep(2000); // simulate work
                System.out.println("ThreadRecordCount: There are currently "+_db.size()+" records in the database.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
