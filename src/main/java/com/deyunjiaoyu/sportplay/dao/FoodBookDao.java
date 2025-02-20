package com.deyunjiaoyu.sportplay.dao;


import com.deyunjiaoyu.sportplay.bean.FoodBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodBookDao {
    public List<FoodBook> getAllBook(@Param("cook_name") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getBookCounts(@Param("cook_name") String food_name);
    public int addBook(FoodBook classes);
    public FoodBook getUpdateBook(int id);
    public int editBook(FoodBook user);
    public int deleteBook(int id);
}
