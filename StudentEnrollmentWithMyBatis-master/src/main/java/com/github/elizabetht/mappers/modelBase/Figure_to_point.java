package com.github.elizabetht.mappers.modelBase;

public class Figure_to_point {
    int id;
    int order;
    int id_figure;
    int id_point;

    public Figure_to_point( int order, int id_figure, Integer id_point) {
       //
        this.order = order;
        this.id_figure = id_figure;
        this.id_point = id_point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_figure() {
        return id_figure;
    }

    public void setId_figure(int id_figure) {
        this.id_figure = id_figure;
    }

    public int getId_point() {
        return id_point;
    }

    public void setId_point(int id_point) {
        this.id_point = id_point;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
