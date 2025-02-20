package com.deyunjiaoyu.sportplay.service.impl;

import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import com.deyunjiaoyu.sportplay.dao.ClassDao;
import com.deyunjiaoyu.sportplay.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public List<ClassInfo> getAllClass(String title, int pageStart, int pageSize) {
        return classDao.getAllClass(title, pageStart, pageSize);
    }

    @Override
    public int getClassCounts(String title) {
        return classDao.getClassCounts(title);
    }

    @Override
    public int addClass(ClassInfo classes) {
        return classDao.addClass(classes);
    }

    @Override
    public ClassInfo getUpdateClass(int id){return classDao.getUpdateClass(id);}

    @Override
    public int editClass(ClassInfo user) {
        return classDao.editClass(user);
    }

    @Override
    public int deleteClass(int user) {
        return classDao.deleteClass(user);
    }

//chart
    @Override
    public List<ClassInfo> findClassChart() {
        return classDao.findClassChart();
    }

    @Override
    public List<ClassInfo> oneTypeClass(String title) {
        return classDao.oneTypeClass(title);
    }
    @Override
    public List<ClassInfo> oneLevelClass(String level) {
        return classDao.oneLevelClass(level);
    }
    @Override
    public List<ClassInfo> getClassById(Integer id) {
        return classDao.getClassById(id);
    }
    @Override
    public int classLiked(Integer id){ return classDao.classLiked(id); };
    @Override
    public int classUnLiked(Integer id){ return classDao.classUnLiked(id); };
    @Override
    public int classCollected(Integer id){ return classDao.classCollected(id); };
    @Override
    public int classUnCollected(Integer id){ return classDao.classUnCollected(id); };
}
