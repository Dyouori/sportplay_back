package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {
    public List<ClassInfo> getAllClass(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getClassCounts(@Param("title")String title);
    public int addClass(ClassInfo classes);
    public ClassInfo getUpdateClass(int id);
    public int editClass(ClassInfo user);
    public int deleteClass(int id);
//    chart
    public List<ClassInfo> findClassChart();
    public List<ClassInfo> oneTypeClass(@Param("classification_title") String title);
    public List<ClassInfo> oneLevelClass(@Param("level") String level);
    public List<ClassInfo> getClassById(@Param("id") Integer id);
    public int classLiked(@Param("id") Integer id);
    public int classUnLiked(@Param("id") Integer id);
    public int classCollected(@Param("id") Integer id);
    public int classUnCollected(@Param("id") Integer id);
}
