package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.Classification;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClassificationDao {
    public List<Class> getAllClassification(@Param("title") String title);
    public  Integer getClassifiCounts(String title);
    public int deleteClassifi(int id);
    public Classification getUpdateClassifi(int id);
    public int editClassifi(Classification classifi);
    public int addClassifi(Classification classification);

}
