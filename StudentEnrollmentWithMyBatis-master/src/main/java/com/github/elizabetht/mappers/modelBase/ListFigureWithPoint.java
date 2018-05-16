package com.github.elizabetht.mappers.modelBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFigureWithPoint extends Entity {
    String type;

    double lat;
    double lon;
}
