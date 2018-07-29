package com.demo.demo.config.dao;

import com.demo.demo.dao.AreaDao;
import com.demo.demo.entity.Area;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList =areaDao.queryArea();

        assertEquals( 2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area=areaDao.QueryAreaById(1);
        assertEquals(  "东苑" ,area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("北苑");
        area.setPriority(1);
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        int i=areaDao.insertArea(area);
        assertEquals(1,i);
    }

    @Test
    public void updateArea() {
        Area area=new Area();
        area.setAreaid(3);
        area.setAreaName("北苑");
        area.setPriority(3);
        area.setLastEditTime(new Date());
        int i=areaDao.updateArea(area);
        assertEquals(1,i);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int i=areaDao.deleteArea(4);
        assertEquals(1,i);
    }
}