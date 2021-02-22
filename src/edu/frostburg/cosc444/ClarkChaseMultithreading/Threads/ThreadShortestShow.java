package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

public class ThreadShortestShow implements Runnable{
    private NetflixDatabase _db;

    public ThreadShortestShow(NetflixDatabase _db) {
        this._db = _db;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int minMinutes = 10000;
        for (NetflixShow show: _db.getAllRecords()){
            var durationString = show.get_duration();
            var split = durationString.trim().split(" ");
            if(split.length>1){
                if (split[1].contains("min")){
                    minMinutes = Math.min(minMinutes,Integer.parseInt(split[0]));
                }
            }
        }
        if (minMinutes > 0){
            System.out.println("(7)ThreadShortestShow: The shortest show is "+minMinutes+" minutes long.");
        }
    }
}
