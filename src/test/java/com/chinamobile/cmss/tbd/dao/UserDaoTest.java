package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.entity.User;
import com.chinamobile.cmss.tbd.util.DESUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hjb on 2018/2/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Ignore
    public void insert() throws Exception{

        User user = new User();
        user.setName("郝敬彬");
        user.setPassword(DESUtils.getEncryptString("skj4942735"));
        user.setAge(29);
        user.setAddress("苏州高新区瞰湖花园三期");
        user.setGender("男");
        user.setPhone("18896724284");
        user.setRole(0);
        user.setState(1);
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());

        int num = userMapper.insertUser(user);
        assertEquals(1,num);
        assertEquals(new Long(1),user.getUserId());
    }

    @Test
    @Ignore
    public void delete() throws Exception{
        int num = userMapper.deleteById(1L);
        assertEquals(1,num);
    }

    @Test
    @Ignore
    public void update() throws Exception{
        User user = new User();
        user.setUserId(2L);
        user.setName("郝敬彬");
        user.setAddress("苏州高新区瞰湖花园三期");
        user.setLastUpdateTime(new Date());
        int num = userMapper.update(user);
        assertEquals(1,num);
    }

    @Test
    @Ignore
    public void queryUser() throws Exception{
        User user = new User();
        user.setUserId(1L);
        user.setName("郝敬彬");
        user = userMapper.queryUser(user);
        assertEquals(new Long(1),user.getUserId());
        assertEquals("苏州高新区瞰湖花园三期",user.getAddress());
    }

    @Test
    @Ignore
    public void queryUserList() throws Exception{
        User user = new User();
        user.setState(1);
        List<User> users = userMapper.queryUserList(user);
        assertEquals(1,users.size());
        assertEquals("苏州高新区瞰湖花园三期",users.get(0).getAddress());
    }

}
