package com.deyunjiaoyu.sportplay.service;

import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClassService {
    int getClassCounts(String title);

    List<ClassInfo> getAllClass(String title, int pageStart, int pageSize);

    int addClass(ClassInfo classes);
    ClassInfo getUpdateClass(int id);
    int editClass(ClassInfo user);
    int deleteClass(int id);
//    ecahart查询
    List<ClassInfo> findClassChart();

    //根据类型选择当前类型的所有课程
    List<ClassInfo> oneTypeClass(String title);
    List<ClassInfo> oneLevelClass(String level);
    List<ClassInfo> getClassById(Integer id);
    int classLiked(Integer id);
    int classUnLiked(Integer id);
    int classCollected(Integer id);
    int classUnCollected(Integer id);
}
