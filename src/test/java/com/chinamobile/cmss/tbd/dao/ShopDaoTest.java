package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.entity.Shop;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hjb on 2018/2/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDaoTest {

    @Autowired
    private ShopMapper shopMapper;


    @Test
    @Ignore
    public void insertTest() throws Exception{
        Shop shop = new Shop();
        shop.setOwnerId(1L);
        shop.setAreaId(1L);
        shop.setShopCategoryId(3L);
        shop.setShopName("海鲜大排档");
        shop.setShopDesc("新鲜海鲜");
        shop.setPhone("18896724284");
        shop.setAddress("苏州科技城");
        shop.setPriority(0);
        shop.setStatus(0);

        int num = shopMapper.insert(shop);
        assertEquals(1,num);
        assertEquals(new Long(1),shop.getShopId());

    }

    @Test
    @Ignore
    public void updateTest() throws Exception{
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("新鲜海鲜测试");
        int num = shopMapper.update(shop);
        assertEquals(1,num);
    }

    @Test
    @Ignore
    public void queryByIdTest() throws Exception{

        Shop shop = shopMapper.queryShopById(1L);
        System.out.println("@@@@@@@@@@@@@ "+shop.toString());
        assertEquals("海鲜大排档",shop.getShopName());
        assertEquals(new Long(1),shop.getOwnerId());
        assertEquals(new Long(1),shop.getAreaId());
        assertEquals(new Long(3),shop.getShopCategoryId());
    }

    @Test
    public void queryListTest() throws Exception{
        Shop shop = new Shop();
        shop.setShopName("海鲜大排档");
        List<Shop> shopList = shopMapper.queryShopList(shop);

        assertEquals(1,shopList.size());
        assertEquals("海鲜大排档",shopList.get(0).getShopName());

    }

}
