package com.chinamobile.cmss.tbd.dao.provider;

import com.chinamobile.cmss.tbd.entity.ShopCategory;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by hjb on 2018/2/11.
 */
public class ShopCategoryProvider {

    public String queryShopCategory(final ShopCategory shopCategoryCondition){
        return new SQL(){
            {
                SELECT("*");
                FROM("ps_shop_category");
                if(null != shopCategoryCondition.getShopCategoryId()){
                    WHERE("shop_category_id = #{shopCategoryId}");
                }
                if(null != shopCategoryCondition.getShopCategoryName()){
                    AND();
                    WHERE("shop_category_name = #{shopCategoryName}");
                }
            }
        }.toString();
    }

    public String queryShopCategoryList(final ShopCategory shopCategoryCondition){
        return new SQL(){
            {
                SELECT("*");
                FROM("ps_shop_category");
                if(null != shopCategoryCondition.getShopCategoryName()){
                    WHERE("shop_category_name like '%"+shopCategoryCondition.getShopCategoryName()+"%'");
                }
                if(null != shopCategoryCondition.getParentId()){
                    AND();
                    WHERE("parent_id = #{parentId}");
                }
                ORDER_BY("priority");
            }
        }.toString();
    }

    public String update(final ShopCategory shopCategoryCondition){
        return new SQL(){
            {
                UPDATE("ps_shop_category");
                if(null != shopCategoryCondition.getShopCategoryName()){
                    SET("shop_category_name = #{shopCategoryName}");
                }
                if(null != shopCategoryCondition.getShopCategoryDesc()){
                    SET("shop_category_desc = #{shopCategoryDesc}");
                }
                if(null != shopCategoryCondition.getPriority()){
                    SET("priority = #{priority}");
                }
                if(null != shopCategoryCondition.getParentId()){
                    SET("parent_id = #{parentId}");
                }
                SET("last_update_time = now()");
                WHERE("shop_category_id = #{shopCategoryId}");
            }
        }.toString();
    }
}
