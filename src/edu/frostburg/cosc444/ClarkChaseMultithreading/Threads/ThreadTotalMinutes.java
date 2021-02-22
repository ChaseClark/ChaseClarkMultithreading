package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

public class ThreadTotalMinutes implements Runnable{
    private NetflixDatabase _db;


    public ThreadTotalMinutes(NetflixDatabase db){
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
            int minutesCount = 0;
            for (NetflixShow show: _db.getAllRecords()){
                var durationString = show.get_duration();
                // end of string is ether mins, else we ignore
                var split = durationString.trim().split(" ");
                if(split.length>1){
                    if (split[1].contains("min")){
                        minutesCount+=Integer.parseInt(split[0]);
                    }
                }
            }
            if (minutesCount > 0){
                System.out.println("(5)ThreadTotalMinutes: There are "+minutesCount+" total minutes in shows.");
            }
        }
    }
}
