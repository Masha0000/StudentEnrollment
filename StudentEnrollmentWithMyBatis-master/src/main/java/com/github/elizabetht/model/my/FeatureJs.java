package com.github.elizabetht.model.my;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.elizabetht.DTO.CoordinateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
//import ru.infoshell.parklook.persistence.model.user.MobileUserPosition;

@Data//@Data
//Все вместе сейчас: Ярлык для @ToString, @EqualsAndHashCode, @Getterна всех полях, и @Setterна всех не конечных полей, и @RequiredArgsConstructor!
@NoArgsConstructor//озданные конструкторы: генерирует конструкторы, которые не принимают никаких аргументов, один аргумент за окончательное / ненулевое поле или один аргумент для каждого поля.
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureJs  implements Serializable {
    @JsonProperty("coord")
    private ArrayList<CoordinateDTO> coord;

    @JsonProperty("name")
    private String name;

    public Double getCoordinatesLat(int i) {
        return coord.get(i).getLat();
    }
    public Double getCoordinatesLon(int i) {
        return coord.get(i).getLon();
    }
    public int getSize()
    {
        return this.coord.size();
    }

    public String getType()
    {
        return this.name;
    }
}
