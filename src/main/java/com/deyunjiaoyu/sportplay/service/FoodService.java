package com.deyunjiaoyu.sportplay.service;

import com.deyunjiaoyu.sportplay.bean.Classification;
import com.deyunjiaoyu.sportplay.bean.FoodType;

import java.util.List;

public interface FoodService {
   List<FoodType> getAllFoodType(String title);
   int getFoodTypeCounts(String title);
   int deleteFoodType(int id);
   FoodType getUpdateFoodType(int id);
   int editFoodType(FoodType classifi);
   int addFoodType(FoodType classification);

}
