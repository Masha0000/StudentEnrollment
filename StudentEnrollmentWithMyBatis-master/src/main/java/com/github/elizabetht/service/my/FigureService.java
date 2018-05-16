package com.github.elizabetht.service.my;

import com.github.elizabetht.mappers.modelBase.ListFigureWithPoint;
import com.github.elizabetht.model.my.BrokenLine;
import com.github.elizabetht.model.my.Point;
import com.github.elizabetht.model.my.Polygon;
import com.github.elizabetht.model.my.Figure;

import java.util.List;



/*Создайте класс интерфейса с именем StudentService.java внутри пакета
 com.github.elizabetht.service для поддержки операций уровня обслуживания.
* */

public interface FigureService {
    void insertFigure(Figure p);

   List<Figure> ReadModel();

  //  void deleteFigure(Figure id);
}
