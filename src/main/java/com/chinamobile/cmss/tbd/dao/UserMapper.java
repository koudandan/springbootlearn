package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.dao.provider.UserProvider;
import com.chinamobile.cmss.tbd.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hjb on 2018/2/2.
 */
@Mapper
public interface UserMapper {

    @SelectProvider(type = UserProvider.class,method = "queryUser")
    @Results(id = "userMap",value = {
            @Result(column="user_id", property="userId", javaType = Long.class),
            @Result(column="name", property="name", javaType = String.class),
            @Result(column="password", property="password", javaType = String.class),
            @Result(column="age", property="age", javaType = Integer.class),
            @Result(column="birthday", property="birthday", javaType = Date.class),
            @Result(column="gender", property="gender", javaType = String.class),
            @Result(column="address", property="address", javaType = String.class),
            @Result(column="phone", property="phone", javaType = String.class),
            @Result(column="create_time", property="createTime", javaType = Date.class),
            @Result(column="last_update_time", property="lastUpdateTime", javaType = Date.class),
            @Result(column="state", property="state", javaType = Integer.class),
            @Result(column="role", property="role", javaType = Integer.class)
    })
    User queryUser(User userCondition);

    @Select("select * from ps_user where user_id = #{userId}")
    @ResultMap("userMap")
    User queryUserById(Long userId);


    @SelectProvider(type = UserProvider.class,method = "queryUserList")
    @ResultMap("userMap")
    List<User> queryUserList(User userCondition);

    @Insert("insert into ps_user(name,password,age,birthday,gender,address,phone,create_time,last_update_time,state,role) values(#{name},#{password},#{age},#{birthday},#{gender},#{address},#{phone},now(),now(),#{state},#{role})")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    int insertUser(User user);

    @Delete("delete from ps_user where user_id = #{userId}")
    int deleteById(@Param("userId") Long userId);

    @UpdateProvider(type = UserProvider.class,method = "update")
    int update(User user);

}
