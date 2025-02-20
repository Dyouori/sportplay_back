package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.FoodType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao {
    public List<FoodType> getAllFoodType(@Param("title") String title);
    public  Integer getFoodTypeCounts(String title);
    public int deleteFoodType(int id);
    public FoodType getUpdateFoodType(int id);
    public int editFoodType(FoodType classifi);
    public int addFoodType(FoodType classification);
}
