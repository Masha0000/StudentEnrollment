package com.github.elizabetht.service.my;

import com.github.elizabetht.mappers.MarkersMapper;
import com.github.elizabetht.mappers.modelBase.FigureBase;
import com.github.elizabetht.mappers.modelBase.Figure_to_point;
import com.github.elizabetht.mappers.modelBase.ListFigureWithPoint;
import com.github.elizabetht.mappers.modelBase.PointBase;
import com.github.elizabetht.model.my.Figure;
import com.github.elizabetht.model.my.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
class FigureServiceImpl implements FigureService {

    @Autowired
    private MarkersMapper markersMapper;

    @Transactional
    public void insertFigure(Figure figureList) {
        //добавление фигуры
        FigureBase figure = new FigureBase(figureList.getType());
        System.out.print(figure.getType().toString());
        markersMapper.insertFigure(figure);
        int idFigire = figure.getId();
        ArrayList<Integer> idPoint = new ArrayList<Integer>();

        ArrayList<PointBase> pointArr = new ArrayList<PointBase>();//получение ид фигуры
        //  for (int i = 0; i < figureList.getList().size(); i++) {
        for (int i = 0; i < figureList.getList().size(); i++) {
        pointArr.add(new PointBase(figureList.getList().get(i)));
    }
//добавление точек в базу
        for (PointBase elem : pointArr){
        markersMapper.insertPoint(elem);
        idPoint.add(elem.getId());
        }

        ArrayList<Figure_to_point> figureToPointList = new ArrayList<Figure_to_point>();
        for (int i = 0; i < idPoint.size(); i++) {
            figureToPointList.add(new Figure_to_point(i+1, idFigire, idPoint.get(i)));
        }

        //добавление связи фигура к точке

        for (Figure_to_point elem : figureToPointList) {
            markersMapper.insert(elem);
          //  System.out.println(elem.getId());
        }


    }
    // void deleteFigure(Figure id){
    //   markersMapper.deleteMarkers(id);
    //}

    //добавить в таблицу промежутоную order(i+1),id

    public List<Figure> ReadModel()
    {
        List<Figure> listFeature=new ArrayList<Figure>();
        List<ListFigureWithPoint> resultList=markersMapper.selectFigure();

        Map<Integer, List<ListFigureWithPoint>> groupedFeatures = new HashMap<Integer, List<ListFigureWithPoint>>();
        for (ListFigureWithPoint elem: resultList) {
            Integer key = elem.getId();
            if (groupedFeatures.get(key) == null) {
                groupedFeatures.put(key, new ArrayList<ListFigureWithPoint>());
            }
            groupedFeatures.get(key).add(elem);
        }







        return listFeature;
    }



}


