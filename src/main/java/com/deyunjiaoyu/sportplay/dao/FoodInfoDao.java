package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import com.deyunjiaoyu.sportplay.bean.FoodInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodInfoDao {
    public List<FoodInfo> getAllFood(@Param("food_name") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getFoodCounts(@Param("food_name") String food_name);
    public int addFood(FoodInfo classes);
    public FoodInfo getUpdateFood(int id);
    public int editFood(FoodInfo user);
    public int deleteFood(int id);
}
