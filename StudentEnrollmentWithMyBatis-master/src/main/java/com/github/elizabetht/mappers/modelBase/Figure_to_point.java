package com.github.elizabetht.mappers.modelBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Figure_to_point extends Entity {


    int id_figure;
    int id_point;
    int orderPoint;

    public Figure_to_point( int order, int id_figure, Integer id_point) {
       //
        this.orderPoint = order;
        this.id_figure = id_figure;
        this.id_point = id_point;
    }


}
