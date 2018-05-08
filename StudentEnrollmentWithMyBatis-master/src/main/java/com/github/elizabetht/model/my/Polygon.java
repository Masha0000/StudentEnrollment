package com.github.elizabetht.model.my;

public class Polygon {
    private Point[] arrayCoordPoly;

    public Polygon(Point[] arrayCoord) {
        this.arrayCoordPoly = arrayCoord;
    }

    public Point[] getArrayCoord() {
        return arrayCoordPoly;
    }

    public Polygon(double[][] arrayCoord) {
        for (int i = 0; i < arrayCoord.length; i++)
            this.arrayCoordPoly[i] = new Point(arrayCoord[i][0], arrayCoord[i][1]);


    }

    public void setArrayCoordPoly(Point[] arrayCoordPoly) {
        this.arrayCoordPoly = arrayCoordPoly;
    }
}