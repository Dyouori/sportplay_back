package com.deyunjiaoyu.sportplay.service.impl;

import com.deyunjiaoyu.sportplay.bean.Classification;
import com.deyunjiaoyu.sportplay.dao.ClassificationDao;
import com.deyunjiaoyu.sportplay.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationDao classDao;
    @Override
    public List<Class> getAllClassification(String title){
        return classDao.getAllClassification(title);
    }
    @Override
    public int getClassifiCounts(String title){
        return classDao.getClassifiCounts(title);
    }

    @Override
    public int deleteClassifi(int id) {
        return classDao.deleteClassifi(id);
    }

    @Override
    public Classification getUpdateClassifi(int id) {
        return classDao.getUpdateClassifi(id);
    }

    @Override
    public int editClassifi(Classification classifi) {
        return classDao.editClassifi(classifi);
    }
    @Override
    public int addClassifi(Classification classification) {
        return classDao.addClassifi(classification);
    }


}
