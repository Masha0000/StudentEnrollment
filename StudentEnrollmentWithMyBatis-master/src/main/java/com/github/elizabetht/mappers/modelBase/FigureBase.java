package com.github.elizabetht.mappers.modelBase;

public class FigureBase {
    int id;
    String type;

    public FigureBase( String type) {

        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
