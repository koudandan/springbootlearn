package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.dao.provider.ShopCategoryProvider;
import com.chinamobile.cmss.tbd.entity.ShopCategory;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hjb on 2018/2/11.
 */
@Mapper
public interface ShopCategoryMapper {

    @Results(id = "shopCategoryMap",value = {
            @Result(column = "shop_category_id",property = "shopCategoryId",javaType = Long.class),
            @Result(column = "shop_category_name",property = "shopCategoryName",javaType = String.class),
            @Result(column = "shop_category_desc",property = "shopCategoryDesc",javaType = String.class),
            @Result(column = "priority",property = "priority",javaType = Integer.class),
            @Result(column = "create_time",property = "createTime",javaType = Date.class),
            @Result(column = "last_update_time",property = "lastUpdateTime",javaType = Date.class),
            @Result(column = "parent_id",property = "parentId",javaType = Long.class)
    })
    @SelectProvider(type = ShopCategoryProvider.class,method = "queryShopCategory")
    ShopCategory queryShopCategory(ShopCategory shopCategoryCondition);

    @Select("select * from ps_shop_category where shop_category_id = #{shopCategoryId}")
    @ResultMap("shopCategoryMap")
    ShopCategory queryShopCategoryById(Long shopCategoryId);

    @SelectProvider(type = ShopCategoryProvider.class,method = "queryShopCategoryList")
    @ResultMap("shopCategoryMap")
    List<ShopCategory> queryShopCategoryList(ShopCategory shopCategoryCondition);

    @Insert("insert into ps_shop_category(shop_category_name,shop_category_desc,priority,create_time,last_update_time,parent_id) values(#{shopCategoryName},#{shopCategoryDesc},#{priority},now(),now(),#{parentId})")
    @Options(useGeneratedKeys = true,keyProperty = "shopCategoryId",keyColumn = "shop_categroy_id")
    int insert(ShopCategory shopCategory);

    @UpdateProvider(type = ShopCategoryProvider.class,method = "update")
    int update(ShopCategory shopCategory);

    @Delete("delete from ps_shop_category where shop_category_id = #{shopCategoryId}")
    int deleteById(Long shopCategoryId);

}
