package com.chinamobile.cmss.tbd.dao.provider;

import com.chinamobile.cmss.tbd.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by hjb on 2018/2/2.
 */
public class UserProvider {

    public String queryUser(final User userCondition){
        return new SQL(){
            {
                SELECT("user_id,name,password,age,birthday,gender,address,phone,create_time,last_update_time,state,role");
                FROM("ps_user");
                if(userCondition.getUserId() != null){
                    WHERE("user_id = #{userId}");
                }
                if(userCondition.getName() != null){
                    AND();
                    WHERE("name = #{name}");
                }
                if(userCondition.getPhone() != null){
                    AND();
                    WHERE("phone = #{phone}");
                }
            }
        }.toString();
    }

    public String queryUserList(final User userCondition){
        return new SQL(){
            {
                SELECT("user_id,name,password,age,birthday,gender,address,phone,create_time,last_update_time,state,role");
                FROM("ps_user");
                if(userCondition.getState() != null){
                    WHERE("state = #{state}");
                }
            }
        }.toString();
    }

    public String update(final User user){
        return new SQL(){
            {
                UPDATE("ps_user");
                if(user.getName() != null){
                    SET("name = #{name}");
                }
                if(user.getPassword() != null){
                    SET("password = #{password}");
                }
                if(user.getAge() != null){
                    SET("age = #{age}");
                }
                if(user.getBirthday() != null){
                    SET("birthday = #{birthday}");
                }
                if(user.getGender() != null){
                    SET("gender = #{gender}");
                }
                if(user.getAddress() != null){
                    SET("address = #{address}");
                }
                if(user.getState() != null){
                    SET("state = #{state}");
                }
                SET("last_update_time = now()");
                WHERE("user_id = #{userId}");
            }
        }.toString();
    }


}
