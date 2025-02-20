package com.deyunjiaoyu.sportplay.service.impl;


import com.deyunjiaoyu.sportplay.bean.FoodBook;
import com.deyunjiaoyu.sportplay.dao.FoodBookDao;
import com.deyunjiaoyu.sportplay.service.FoodBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodBookServiceImpl implements FoodBookService {
    @Autowired
    private FoodBookDao foodBookDao;

    @Override
    public List<FoodBook> getAllBook(String title, int pageStart, int pageSize) {
        return foodBookDao.getAllBook(title, pageStart, pageSize);
    }

    @Override
    public int getBookCounts(String title) {
        return foodBookDao.getBookCounts(title);
    }

    @Override
    public int addBook(FoodBook classes) {
        return foodBookDao.addBook(classes);
    }

    @Override
    public FoodBook getUpdateBook(int id){return foodBookDao.getUpdateBook(id);}

    @Override
    public int editBook(FoodBook user) {
        return foodBookDao.editBook(user);
    }

    @Override
    public int deleteBook(int id) {
        return foodBookDao.deleteBook(id);
    }
}
