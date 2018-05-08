package com.github.elizabetht.model.my;

public class Markers {
    private double [][] coord;
    int type;

    public Markers(double[][] coord, int type) {
        this.coord = coord;
        this.type = type;
    }

    public double[][] getCoord() {
        return coord;
    }

    public void setCoord(double[][] coord) {
        this.coord = coord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
