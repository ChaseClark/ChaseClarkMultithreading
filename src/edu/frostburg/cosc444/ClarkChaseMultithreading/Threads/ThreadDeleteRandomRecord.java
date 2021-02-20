package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.StringGenerator;

import java.util.Random;

public class ThreadDeleteRandomRecord implements Runnable {
    private NetflixDatabase _db;

    public ThreadDeleteRandomRecord(NetflixDatabase db) {
        _db = db;
    }

    @Override
    public void run() {
        // periodically delete a random record from the database
        Random rand = new Random();
        while (true) {
            try {
                Thread.sleep(6000);
                boolean result = _db.removeRandomRecord();
                if (result) {
                    System.out.println("(3)ThreadDeleteRandomRecord: 1 random record was deleted.");
                } else {
                    System.out.println("(3)ThreadDeleteRandomRecord: record is locked and will not be deleted.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
