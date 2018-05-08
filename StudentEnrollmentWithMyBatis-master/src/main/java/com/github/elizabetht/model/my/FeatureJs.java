package com.github.elizabetht.model.my;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
//import ru.infoshell.parklook.persistence.model.user.MobileUserPosition;

@Data//@Data
//Все вместе сейчас: Ярлык для @ToString, @EqualsAndHashCode, @Getterна всех полях, и @Setterна всех не конечных полей, и @RequiredArgsConstructor!
@NoArgsConstructor//озданные конструкторы: генерирует конструкторы, которые не принимают никаких аргументов, один аргумент за окончательное / ненулевое поле или один аргумент для каждого поля.
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureJs {
    private String type;
    private Double [][] coordinates;

    public FeatureJs(String type, Double[][] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }


    public Double getCoordinates(int i,int j) {
        return coordinates[i][j];
    }

    public int getSize()
    {
        return this.coordinates.length;
    }

    public String getType()
    {
        return this.type;
    }
}
