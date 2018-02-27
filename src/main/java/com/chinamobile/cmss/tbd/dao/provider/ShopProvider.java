package com.chinamobile.cmss.tbd.dao.provider;

import com.chinamobile.cmss.tbd.entity.Shop;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by hjb on 2018/2/12.
 */
public class ShopProvider {

    public String queryShopList(final Shop shopCondition){
        return new SQL(){
            {
                SELECT("*");
                FROM("ps_shop");
                if(null != shopCondition.getOwnerId()){
                    WHERE("owner_id = #{ownerId}");
                }
                if(null != shopCondition.getAreaId()){
                    AND();
                    WHERE("area_id = #{areaId}");
                }
                if(null != shopCondition.getShopCategoryId()){
                    AND();
                    WHERE("shop_category_id = #{shopCategoryId}");
                }
                if(null != shopCondition.getShopName()){
                    AND();
                    WHERE("shop_name like '%"+shopCondition.getShopName()+"%'");
                }
                if(null != shopCondition.getStatus()){
                    AND();
                    WHERE("status = #{status}");
                }
                ORDER_BY("priority");
            }
        }.toString();
    }


    public String update(final Shop shop){
        return new SQL(){
            {
                UPDATE("ps_shop");
                if(null != shop.getShopName()){
                    SET("shop_name = #{shopName}");
                }
                if(null != shop.getShopName()){
                    SET("shop_desc = #{shopDesc}");
                }
                if(null != shop.getShopName()){
                    SET("phone = #{phone}");
                }
                if(null != shop.getShopName()){
                    SET("address = #{address}");
                }
                if(null != shop.getShopName()){
                    SET("priority = #{priority}");
                }
                if(null != shop.getShopName()){
                    SET("area_id = #{areaId}");
                }
                if(null != shop.getShopName()){
                    SET("owner_id = #{ownerId}");
                }
                if(null != shop.getShopName()){
                    SET("shop_category_id = #{shopCategoryId}");
                }
                SET("last_update_time = now()");
                WHERE("shop_id = #{shopId}");
            }
        }.toString();
    }
}
