package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hjb on 2018/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    @Ignore
    public void insertTest() throws Exception{

        Area area = new Area();
        area.setAreaName("自卖自夸");
        area.setAreaDesc("美丽的科技城");
        area.setPriority(0);
        area.setCreateTime(new Date());
        area.setLastUpdateTime(new Date());

        int num = areaMapper.insertArea(area);
        assertEquals(1,num);
        assertEquals(new Long(2),area.getAreaId());

    }
    @Test
    @Ignore
    public void queryAreaTest() throws Exception{
        Area area = new Area();
        area.setAreaId(1L);
        area.setAreaName("科技城");
        Area areaQuery = areaMapper.queryArea(area);
        System.out.println(areaQuery);
        assertEquals("科技城",areaQuery.getAreaName());

    }

    @Test
    @Ignore
    public void queryAreaListTest() throws Exception{
        Area area = new Area();
        area.setAreaName("科技城");
        List<Area> areaList = areaMapper.queryAreaList(area);
        System.out.println("########"+areaList.get(0));
        assertEquals(2,areaList.size());
    }



    @Test
    @Ignore
    public void update() throws Exception{
        Area area = new Area();
        area.setAreaId(1L);
        area.setPriority(1);

        int num = areaMapper.update(area);

        assertEquals(1,num);

    }

    @Test
    @Ignore
    public void delete() throws Exception{

        int num = areaMapper.deleteById(2L);
        assertEquals(1,num);
    }
}
