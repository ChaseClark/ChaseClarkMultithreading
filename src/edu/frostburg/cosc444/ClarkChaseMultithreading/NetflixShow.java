package edu.frostburg.cosc444.ClarkChaseMultithreading;

/*
* Model class to hold information about a Netflix show
* */
public class NetflixShow {
    private int _id; // auto incremented in java code
    private String _type;
    private String _title;
    private String _director;
    private String _dateAdded;
    private String _releaseYear;
    private String _rating;
    private String _duration;
    private boolean _locked = false; // default to unlocked

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_director() {
        return _director;
    }

    public void set_director(String _director) {
        this._director = _director;
    }

    public String get_dateAdded() {
        return _dateAdded;
    }

    public void set_dateAdded(String _dateAdded) {
        this._dateAdded = _dateAdded;
    }

    public String get_releaseYear() {
        return _releaseYear;
    }

    public void set_releaseYear(String _releaseYear) {
        this._releaseYear = _releaseYear;
    }

    public String get_rating() {
        return _rating;
    }

    public void set_rating(String _rating) {
        this._rating = _rating;
    }

    public String get_duration() {
        return _duration;
    }

    public void set_duration(String _duration) {
        this._duration = _duration;
    }

    public boolean is_locked() {
        return _locked;
    }

    public boolean set_locked(String requester) {
        // if not locked already, set to locked and then print which Thread currently holds the lock
        if (is_locked())
            return false; // already locked
        else if (!is_locked()){
            _locked = true;
            System.out.println("Record " +_id+" has been locked by "+requester);
            return true;
        }
        return false; // error case
    }

    public NetflixShow(int _id, String _type, String _title, String _director, String _dateAdded, String _releaseYear, String _rating, String _duration) {
        this._id = _id;
        this._type = _type;
        this._title = _title;
        this._director = _director;
        this._dateAdded = _dateAdded;
        this._releaseYear = _releaseYear;
        this._rating = _rating;
        this._duration = _duration;
    }



}
