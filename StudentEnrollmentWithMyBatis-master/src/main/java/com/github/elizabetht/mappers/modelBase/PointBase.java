package com.github.elizabetht.mappers.modelBase;
import com.github.elizabetht.model.my.Point;

public class PointBase {
    int id;
    double lat;
    double lon;

    public PointBase( int lat, int lon) {

        this.lat = lat;
        this.lon = lon;
    }

    public PointBase( Point p) {

        this.lat = p.getLat();
        this.lon = p.getLon();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public double  getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}