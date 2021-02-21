package edu.frostburg.cosc444.ClarkChaseMultithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 This is a utility class for holding the database of netflix shows.
 Also, provides methods for modifying the database.
 */
public class NetflixDatabase {
    private ArrayList<NetflixShow> _db;
    private final String _path = "./netflix_titles.csv";
    private int _currentID = 1;

    // move thread locking logic into this class


    public NetflixDatabase() {
        _db = new ArrayList<NetflixShow>();
        insertRecordsFromFile(_path);
    }

    /**
     * parses text file and adds records to db.
     * @param path of text file
     */
    private void insertRecordsFromFile(String path) {
        try {
            List<String> allLines = Files.readAllLines(Path.of(path));
            for (String line: allLines) {
                if (!line.isEmpty())
                {
                    String[] lineArr = line.split(","); // comma delimited
                    // we only want to parse lines with exactly 7 values
                    if (lineArr.length == 7) {
                        // lineArr[0] = "type columm" ... lineArr[6] = "duration col"
                        addRecord(lineArr[0], lineArr[1], lineArr[2], lineArr[3], lineArr[4], lineArr[5], lineArr[6]);
                    }
                }
            }
            System.out.println(_currentID+" records inserted into database from file");
        } catch (IOException e) {
            System.out.println("error finding file at: "+ path);
            e.printStackTrace();
        }
    }

    // adds a record to the database
    public boolean addRecord(String type, String title, String director, String dateAdded,
                             String releaseYear, String rating, String duration){
        try {
            NetflixShow newShow = new NetflixShow(_currentID,type,title,director,dateAdded,releaseYear,rating,duration);
            // testing
            //System.out.println(newShow.toString());
            _db.add(newShow);
            _currentID++;
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // delete random record, returns true if sucessful
    public boolean removeRandomRecord(){
        try {
            // need to check if record is currently locked or not
            Random random = new Random();
            NetflixShow show = _db.get(random.nextInt(_db.size()));
            if (show.is_locked()) {
                return false;
            }
            else {
                show.set_locked("ThreadDeleteRandomRecord");
                _db.remove(show);
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // returns the number of records
    public int getCount(){
        return _db.size();
    }
}
