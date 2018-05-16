package com.github.elizabetht.mappers.modelBase;
import com.github.elizabetht.model.my.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PointBase extends Entity  {

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


}