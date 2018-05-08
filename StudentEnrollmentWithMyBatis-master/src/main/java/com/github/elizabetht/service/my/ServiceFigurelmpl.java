


    package com.github.elizabetht.service.my;

import com.github.elizabetht.mappers.MarkersMapper;

import com.github.elizabetht.mappers.modelBase.FigureBase;
import com.github.elizabetht.mappers.modelBase.Figure_to_point;
import com.github.elizabetht.mappers.modelBase.PointBase;
import com.github.elizabetht.model.my.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

    @Service("ServiceFigure")
    class ServiceFigurelmpl implements ServiceFigure {

        @Autowired
        private MarkersMapper markersMapper;

        @Transactional
        public void insertFigure(Figure figureList) {
            FigureBase figure = new FigureBase(figureList.getType());
            markersMapper.insertFigure(figure);
            int idFigire = figure.getId();
            ArrayList<Integer> idPoint = null;

            ArrayList<PointBase> pointArr = new ArrayList<PointBase>();
            for (int i = 0; i < figureList.getList().size(); i++) {
                pointArr.add(new PointBase(figureList.getList().get(i)));
            }
//        figureList.getList();//перевести точки в точку базу
            markersMapper.insertPoint(pointArr);
            for (PointBase elem : pointArr)
                idPoint.add(elem.getId());

            ArrayList<Figure_to_point> figureToPointList=null ;
            for (int i = 0; i < idPoint.size();i++){
                    figureToPointList.add(new Figure_to_point (i,idFigire,idPoint.get(i)));
            }

            markersMapper.insert(figureToPointList);


        }
       // void deleteFigure(Figure id){
         //   markersMapper.deleteMarkers(id);
        //}

        //добавить в таблицу промежутоную order(i+1),id

        public  Figure ReadModel(){
            return markersMapper.selectFigure();

        };

    }


