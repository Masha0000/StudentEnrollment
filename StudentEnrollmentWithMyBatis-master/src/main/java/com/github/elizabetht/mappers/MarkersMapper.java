package com.github.elizabetht.mappers;

import com.github.elizabetht.mappers.modelBase.FigureBase;
import com.github.elizabetht.mappers.modelBase.Figure_to_point;
import com.github.elizabetht.mappers.modelBase.ListFigureWithPoint;
import com.github.elizabetht.mappers.modelBase.PointBase;
import com.github.elizabetht.model.my.Figure;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;


public interface MarkersMapper {

    final String INSERTFIGURE = "Insert into figure (type)  value (#{type})";
    @Insert(INSERTFIGURE)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertFigure(FigureBase post);


    @Insert("insert into Point (lat, lon) values (#{lat}, #{lon})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertPoint(PointBase pointArr);


    @Insert("INSERT INTO figure_to_point(figure_id,point_id,orderPoint) " +
            "VALUES (#{id_figure},#{id_point},#{orderPoint})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Figure_to_point figureToPointList);

    String SELECT_BY_VALUE="select f.id, f.type, p.lat, p.lon from figure f join figure_to_point ftp on f.id = ftp.figure_id join point p on ftp.point_id = p.id  order by  order by f.id,ftp.orderPoint;";

    @Select(SELECT_BY_VALUE)
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "lat", column = "lat"),
            @Result(property = "lon", column = "lon")})
    List<ListFigureWithPoint> selectFigure();//что делать с селектами


    // void insertBatchSomething(@Param("theCollection") List<Something> theCollection);

/*public interface VillageMapper {
	@Results({
          @Result(property = "vid", column = "id"),
          @Result(property = "villageName", column = "name"),
          @Result(property = "district", column = "district")
        })
	@Select("SELECT id, name, district from village WHERE id = #{id}")
	Village selectVillage(int id);

	@Insert("INSERT into village(name,district) VALUES(#{villageName}, #{district})")
	void insertVillage(Village village);

	@Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
	void updateVillage(Village village);

	@Delete("DELETE FROM village WHERE id =#{id}")
	void deleteVillage(int id);
} */


}

