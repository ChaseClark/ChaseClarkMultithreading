package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

// this thread adds up the total amount of seasons in the duration col
public class ThreadTotalSeasons implements Runnable {
    private NetflixDatabase _db;

    public ThreadTotalSeasons(NetflixDatabase db){
        _db = db;
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int seasonsCount = 0;
            for (NetflixShow show: _db.getAllRecords()){
                var durationString = show.get_duration();
                // end of string is ether Season, Seasons, else we ignore
                var split = durationString.trim().split(" ");
                if(split.length>1){
                    if (split[1].contains("Season")){
                        seasonsCount+=Integer.parseInt(split[0]);
                    }
                }
            }
            if (seasonsCount > 0){
                System.out.println("(4)ThreadTotalSeasons: There are "+seasonsCount+" total seasons.");
            }
        }
    }
}
