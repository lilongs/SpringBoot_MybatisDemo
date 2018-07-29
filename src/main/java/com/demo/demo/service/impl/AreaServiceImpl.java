package com.demo.demo.service.impl;

import com.demo.demo.dao.AreaDao;
import com.demo.demo.entity.Area;
import com.demo.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.QueryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName()!=null && !"".equals(area.getAreaName()))
        {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int n=areaDao.insertArea(area);
                if (n>0)
                {
                    return  true;
                }
                else
                {
                    throw new RuntimeException("插入区域信息异常!");
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException("插入区域信息异常!"+e.toString());
            }
        }else
        {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaid()!=null && area.getAreaid()>0)
        {
            area.setLastEditTime(new Date());
            try{
                int n=areaDao.updateArea(area);
                if (n>0)
                {
                    return  true;
                }
                else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败！"+e.toString());
            }
        }
        else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int n=areaDao.deleteArea(areaId);
                if (n>0){
                    return  true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败！"+e.toString());
            }
        }else{
            throw new RuntimeException("区域信息Id不能为空！");
        }
    }
}
