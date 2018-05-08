package com.github.elizabetht.model.my;

import java.util.ArrayList;

public class Figure {
    String type;
    ArrayList<Point> list;

    public Figure(String type, ArrayList<Point> list) {
        this.type = type;
        this.list = list;
    }

    public Figure(FeatureJs f) {
        this.type = f.getType();
       for(int i=0;i<f.getSize();i++)
       {
           this.list.set(i,new Point (f.getCoordinates(i,0),f.getCoordinates(i,1)));
       }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Point> getList() {
        return list;
    }

    public void setList(ArrayList<Point> list) {
        this.list = list;
    }
   /* ArrayList <Point> pointList;
    ArrayList <Polygon> poligonList;
    ArrayList <BrokenLine> brockenList;

    public Figure(ArrayList<Point> pointList, ArrayList<Polygon> poligonList, ArrayList<BrokenLine> brockenList) {
        this.pointList = pointList;
        this.poligonList = poligonList;
        this.brockenList = brockenList;
    }

    public ArrayList<Point> getPointList() {
        return pointList;
    }

    public void setPointList(ArrayList<Point> pointList) {
        this.pointList = pointList;
    }

    public ArrayList<Polygon> getPoligonList() {
        return poligonList;
    }

    public void setPoligonList(ArrayList<Polygon> poligonList) {
        this.poligonList = poligonList;
    }

    public ArrayList<BrokenLine> getBrockenList() {
        return brockenList;
    }

    public void setBrockenList(ArrayList<BrokenLine> brockenList) {
        this.brockenList = brockenList;
    }
}
*/}