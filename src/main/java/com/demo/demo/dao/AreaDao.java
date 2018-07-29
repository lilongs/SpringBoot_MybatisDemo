package com.demo.demo.dao;


import com.demo.demo.entity.Area;
import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    Area QueryAreaById(int areaid);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int area);
}
