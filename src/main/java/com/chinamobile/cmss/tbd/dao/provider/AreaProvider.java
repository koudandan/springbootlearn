package com.chinamobile.cmss.tbd.dao.provider;

import com.chinamobile.cmss.tbd.entity.Area;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by hjb on 2018/2/11.
 */
public class AreaProvider {

    public String queryArea(final Area areaCondition){
        return new SQL(){
            {
                SELECT("*");
                FROM("ps_area");
                if(null != areaCondition.getAreaId()){
                    WHERE("area_id = #{areaId}");
                }
                if(null != areaCondition.getAreaName()){
                    AND();
                    WHERE("area_name = #{areaName}");
                }
            }
        }.toString();
    }

    public String queryAreaList(final Area areaCondition){
        return new SQL(){
            {
                SELECT("*");
                FROM("ps_area");
                if(null != areaCondition.getAreaName()){
                    WHERE("area_name like '%"+areaCondition.getAreaName()+"%'");
                }
                ORDER_BY("priority");
            }
        }.toString();
    }

    public String update(final Area area) {
        return new SQL(){
            {
                UPDATE("ps_area");
                if(null != area.getAreaName()){
                    SET("area_name = #{areaName}");
                }
                if(null != area.getPriority()){
                    SET("priority = #{priority}");
                }
                if(null != area.getAreaDesc()){
                    SET("area_desc = #{areaDesc}");
                }
                SET("last_update_time = now()");
                WHERE("area_id = #{areaId}");
            }
        }.toString();
    }

}
