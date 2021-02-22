package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

public class ThreadLongestShow implements Runnable{
    private NetflixDatabase _db;

    public ThreadLongestShow(NetflixDatabase _db) {
        this._db = _db;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int maxMinutes = 0;
        for (NetflixShow show: _db.getAllRecords()){
            var durationString = show.get_duration();
            var split = durationString.trim().split(" ");
            if(split.length>1){
                if (split[1].contains("min")){
                    maxMinutes = Math.max(maxMinutes,Integer.parseInt(split[0]));
                }
            }
        }
        if (maxMinutes > 0){
            System.out.println("(6)ThreadLongestShow: The longest show is "+maxMinutes+" minutes long.");
        }
    }
}
