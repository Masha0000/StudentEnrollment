package com.github.elizabetht.mappers;

import com.github.elizabetht.mappers.modelBase.FigureBase;
import com.github.elizabetht.mappers.modelBase.Figure_to_point;
import com.github.elizabetht.mappers.modelBase.PointBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.github.elizabetht.model.my.Figure;

import java.util.ArrayList;

public interface MarkersMapper {

         /*   @Insert("INSERT INTO your_database_name.your_table_name(column1_int, column2_str, column3_date, column4_time)","VALUES" +
                        "<foreach item='each_item_name' index='index' collection='theCollection' open='' separator=',' close=''>" +
                        "(" +
                        "#{each_item_name.column1,jdbcType=INTEGER},",
                "#{each_item_name.column2,jdbcType=VARCHAR},",
                "(SELECT SOME_DB_FUNCTION(#{each_item_name.column3,jdbcType=DATE})),",
                "#{each_item_name.period.start,jdbcType=TIME}" +
                        ")" +
                        "</foreach>;*/



    final String INSERTFIGURE = "insert into figure (type) values (#{type})";

    @Insert(INSERTFIGURE)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertFigure(FigureBase post);


    final String INSERTPOINTLIST ="INSERT INTO MARKERS.POINT(LAT,LON) VALUES <foreach collection='pointArr'" +
            "item='element' open='(' separator=','  close=')'> #{element.lat}, #{element.lon}";

    @Insert(INSERTPOINTLIST)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")


    void insertPoint(ArrayList<PointBase> pointArr);

        final String INSERTfiguretoPOINT ="INSERT INTO MARKERS.figure_to_point(figure_id,point_id,order) " +
                "VALUES <foreach collection='figureToPointList'" +
            "item='element' open='(' separator=','  close=')'> #{element.order}, #{element.id_figure}, #{element.id_point}";

    @Insert(INSERTfiguretoPOINT)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")





    void insert(ArrayList<Figure_to_point> figureToPointList);

    @Select("SELECT point.lat, point.lon, figure.id district from point join figure_to_point on figure_to_point.point_id=point.id join figure " +
            "figure_to_point.figure_id=figure.id order by figure_to_point.order")//WHERE id = #{id}")
    Figure selectFigure();//что делать с селектами


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

