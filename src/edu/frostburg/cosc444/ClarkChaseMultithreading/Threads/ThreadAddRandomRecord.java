package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.StringGenerator;

public class ThreadAddRandomRecord implements Runnable {
    private NetflixDatabase _db;


    public ThreadAddRandomRecord(NetflixDatabase db) {
        _db = db;
    }

    @Override
    public void run() {
        // generate random data and add a record to the database, then repeat a couple times
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                // generate a record from 7 random string values
                boolean result = _db.addRecord(StringGenerator.StringWithLength(5),StringGenerator.StringWithLength(5),
                        StringGenerator.StringWithLength(5),StringGenerator.StringWithLength(5),
                        StringGenerator.RandomReleaseYear(),StringGenerator.RandomRating(),
                        StringGenerator.RandomDuration());
                if(result){
                    System.out.println("(2)ThreadAddRandomRecord: 1 random record was added to the database.");
                }
                else{
                    System.out.println("(2)ThreadAddRandomRecord: failed to add record to the database.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
