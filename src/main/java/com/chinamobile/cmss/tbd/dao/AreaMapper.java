package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.dao.provider.AreaProvider;
import com.chinamobile.cmss.tbd.entity.Area;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hjb on 2018/2/11.
 */
@Mapper
public interface AreaMapper {


    @SelectProvider(type = AreaProvider.class,method = "queryArea")
    @Results(id = "areaMap",value = {
            @Result(column="area_id", property="areaId", javaType = Long.class),
            @Result(column="area_name", property="areaName", javaType = String.class),
            @Result(column="area_desc", property="areaDesc", javaType = String.class),
            @Result(column="priority", property="priority", javaType = Integer.class),
            @Result(column="create_time", property="createTime", javaType = Date.class),
            @Result(column="last_update_time", property="lastUpdateTime", javaType = Date.class)
    })
    Area queryArea(Area areaCondition);

    @Select("select * from ps_area where area_id = #{areaId}")
    @ResultMap("areaMap")
    Area queryAreaById(Long areaId);

    @SelectProvider(type = AreaProvider.class,method = "queryAreaList")
    @ResultMap("areaMap")
    List<Area> queryAreaList(Area areaCondition);

    @Insert("insert into ps_area(area_name,area_desc,priority,create_time,last_update_time) values(#{areaName},#{areaDesc},#{priority},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "areaId",keyColumn = "area_id")
    int insertArea(Area area);

    @UpdateProvider(type = AreaProvider.class,method = "update")
    int update(Area area);

    @Delete("delete from ps_area where area_id = #{areaId}")
    int deleteById(Long areaId);


}
