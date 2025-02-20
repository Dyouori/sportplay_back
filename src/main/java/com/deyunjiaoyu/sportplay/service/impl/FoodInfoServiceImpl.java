package com.deyunjiaoyu.sportplay.service.impl;


import com.deyunjiaoyu.sportplay.bean.FoodInfo;
import com.deyunjiaoyu.sportplay.dao.FoodInfoDao;
import com.deyunjiaoyu.sportplay.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodInfoServiceImpl implements FoodInfoService {
    @Autowired
    private FoodInfoDao foodInfoDao;

    @Override
    public List<FoodInfo> getAllFood(String title, int pageStart, int pageSize) {
        return foodInfoDao.getAllFood(title, pageStart, pageSize);
    }

    @Override
    public int getFoodCounts(String title) {
        return foodInfoDao.getFoodCounts(title);
    }

    @Override
    public int addFood(FoodInfo classes) {
        return foodInfoDao.addFood(classes);
    }

    @Override
    public FoodInfo getUpdateFood(int id){return foodInfoDao.getUpdateFood(id);}

    @Override
    public int editFood(FoodInfo user) {
        return foodInfoDao.editFood(user);
    }

    @Override
    public int deleteFood(int id) {
        return foodInfoDao.deleteFood(id);
    }
}
