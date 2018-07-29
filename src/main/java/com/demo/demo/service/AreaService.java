package com.demo.demo.service;

import com.demo.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
