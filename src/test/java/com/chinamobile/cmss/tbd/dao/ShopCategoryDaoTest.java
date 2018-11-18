package com.chinamobile.cmss.tbd.dao;

import com.chinamobile.cmss.tbd.entity.ShopCategory;
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
 * Created by hjb on 2018/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryDaoTest {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Test
    @Ignore
    public void insertTest() throws Exception{
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryName("海鲜");
        shopCategory.setShopCategoryDesc("胡林峰海鲜测试");
        shopCategory.setPriority(2);
        shopCategory.setCreateTime(new Date());
        shopCategory.setParentId(2L);

        int num = shopCategoryMapper.insert(shopCategory);
        assertEquals(1,num);
    }

    @Test
    @Ignore
    public void queryTest() throws Exception{
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(2L);

        shopCategory = shopCategoryMapper.queryShopCategory(shopCategory);

        System.out.println("############ "+shopCategory);
        assertEquals("美食",shopCategory.getShopCategoryName());
    }

    @Test
    @Ignore
    public void queryListTest() throws Exception{
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setParentId(2L);

        List<ShopCategory> shopCategories = shopCategoryMapper.queryShopCategoryList(shopCategory);

        System.out.println("############ "+shopCategories.get(0));
        assertEquals(2,shopCategories.size());
        assertEquals("火锅",shopCategories.get(0).getShopCategoryName());
    }

    @Test
    @Ignore
    public void updateTest() throws Exception{
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(5L);
        shopCategory.setShopCategoryDesc("海鲜测试测试");

        int num = shopCategoryMapper.update(shopCategory);
        assertEquals(1,num);

    }

    @Test
    @Ignore
    public void deleteTest() throws Exception{

        int num = shopCategoryMapper.deleteById(5L);
        assertEquals(1,num);
    }


}
