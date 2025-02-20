package com.deyunjiaoyu.sportplay.service;



import com.deyunjiaoyu.sportplay.bean.FoodBook;

import java.util.List;


public interface FoodBookService {
    int getBookCounts(String title);
    List<FoodBook> getAllBook(String title, int pageStart, int pageSize);
    int addBook(FoodBook classes);
    FoodBook getUpdateBook(int id);
    int editBook(FoodBook user);
    int deleteBook(int id);
}
