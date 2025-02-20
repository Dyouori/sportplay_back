package com.deyunjiaoyu.sportplay.service.impl;

import com.deyunjiaoyu.sportplay.bean.Classification;
import com.deyunjiaoyu.sportplay.bean.FoodType;
import com.deyunjiaoyu.sportplay.dao.FoodDao;

import com.deyunjiaoyu.sportplay.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDao foodDao;
    @Override
    public List<FoodType> getAllFoodType(String title){
        return foodDao.getAllFoodType(title);
    }
    @Override
    public int getFoodTypeCounts(String title){
        return foodDao.getFoodTypeCounts(title);
    }

    @Override
    public int deleteFoodType(int id) {
        return foodDao.deleteFoodType(id);
    }

    @Override
    public FoodType getUpdateFoodType(int id) {
        return foodDao.getUpdateFoodType(id);
    }

    @Override
    public int editFoodType(FoodType classifi) {
        return foodDao.editFoodType(classifi);
    }
    @Override
    public int addFoodType(FoodType classification) {
        return foodDao.addFoodType(classification);
    }


}
