package edu.frostburg.cosc444.ClarkChaseMultithreading.Threads;

import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixDatabase;
import edu.frostburg.cosc444.ClarkChaseMultithreading.NetflixShow;

public class ThreadRatingTotals implements Runnable{
    private NetflixDatabase _db;


    public ThreadRatingTotals(NetflixDatabase _db) {
        this._db = _db;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //var ratings = new String[]{"TV-Y","G","TV-G","TV-PG","PG","TV-Y7","PG-13","TV-14","TV-MA","R","NR","NC-17"};
            int tvY = 0;
            int G = 0;
            int tvG = 0;
            int tvPG = 0;
            int PG = 0;
            int tvY7 = 0;
            int PG13 = 0;
            int tv14 = 0;
            int tvMA = 0;
            int R = 0;
            int NR = 0;
            int NC17 = 0;

            for (NetflixShow show : _db.getAllRecords()){
                switch (show.get_rating()){
                    case "TV-Y":
                        tvY++;
                    case "G":
                        G++;
                    case "TV-G":
                        tvG++;
                    case "TV-PG":
                        tvPG++;
                    case "PG":
                        PG++;
                    case "TV-Y7":
                        tvY7++;
                    case "PG-13":
                        PG13++;
                    case "TV-14":
                        tv14++;
                    case "TV-MA":
                        tvMA++;
                    case "R":
                        R++;
                    case "NR":
                        NR++;
                    case "NC-17":
                        NC17++;
                    default:
                        break;
                }
            }
            System.out.println("(8)ThreadRatingTotals: TV-7: "+tvY+" G: "+G+" TV-G: "+tvG+" TV-PG: "+tvPG+" PG: "+PG+
                    " TV-Y7: "+tvY7+" PG-13: "+PG13+" TV-14: "+tv14+" TV-MA: "+tvMA+" R: "+R+" NR: "+NR+" NC-17: "+NC17);
        }
    }
}
