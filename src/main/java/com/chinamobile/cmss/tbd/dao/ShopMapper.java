package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.dao.provider.ShopProvider;
import com.chinamobile.cmss.tbd.entity.Area;
import com.chinamobile.cmss.tbd.entity.Shop;
import com.chinamobile.cmss.tbd.entity.ShopCategory;
import com.chinamobile.cmss.tbd.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hjb on 2018/2/12.
 */
@Mapper
public interface ShopMapper {

    @Results(id = "shopMap",value = {
            @Result(column = "shop_id",property = "shopId",javaType = Long.class),
            @Result(column = "owner_id",property = "ownerId",javaType = Long.class),
            @Result(column = "area_id",property = "areaId",javaType = Long.class),
            @Result(column = "shop_category_id",property = "shopCategoryId",javaType = Long.class),
            @Result(column = "shop_name",property = "shopName",javaType = String.class),
            @Result(column = "phone",property = "phone",javaType = String.class),
            @Result(column = "shop_desc",property = "shopDesc",javaType = String.class),
            @Result(column = "adress",property = "adress",javaType = String.class),
            @Result(column = "priority",property = "priority",javaType = Integer.class),
            @Result(column = "status",property = "status",javaType = Integer.class),
            @Result(column = "create_time",property = "createTime",javaType = Date.class),
            @Result(column = "last_update_time",property = "lastUpdateTime",javaType = Date.class),
            @Result(column = "owner_id",property = "user",one = @One(select = "com.chinamobile.cmss.tbd.dao.UserMapper.queryUserById")),
            @Result(column = "area_id",property = "area",one = @One(select = "com.chinamobile.cmss.tbd.dao.AreaMapper.queryAreaById")),
            @Result(column = "shop_category_id",property = "shopCategory",one = @One(select = "com.chinamobile.cmss.tbd.dao.ShopCategoryMapper.queryShopCategoryById"))
    })
    @Select("select * from ps_shop where shop_id = #{shopId}")
    Shop queryShopById(Long shopId);

    @SelectProvider(type = ShopProvider.class,method = "queryShopList")
    @ResultMap("shopMap")
    List<Shop> queryShopList(Shop shopCondition);

    @UpdateProvider(type = ShopProvider.class,method = "update")
    int update(Shop shop);

    @Insert("insert into ps_shop(owner_id,area_id,shop_category_id,shop_name,phone,shop_desc,address,priority,status,create_time,last_update_time) values(#{ownerId},#{areaId},#{shopCategoryId},#{shopName},#{phone},#{shopDesc},#{address},#{priority},#{status},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "shopId",keyColumn = "shop_id")
    int insert(Shop shop);

    @Delete("delete from ps_shop where shop_id = #{shopId}")
    int delete(Shop shop);

}
