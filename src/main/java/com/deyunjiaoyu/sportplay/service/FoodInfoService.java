package com.deyunjiaoyu.sportplay.service;

import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import com.deyunjiaoyu.sportplay.bean.FoodInfo;

import java.util.List;


public interface FoodInfoService {
    int getFoodCounts(String title);
    List<FoodInfo> getAllFood(String title, int pageStart, int pageSize);
    int addFood(FoodInfo classes);
    FoodInfo getUpdateFood(int id);
    int editFood(FoodInfo user);
    int deleteFood(int id);
}
