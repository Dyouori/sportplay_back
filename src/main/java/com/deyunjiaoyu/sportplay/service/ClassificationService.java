package com.deyunjiaoyu.sportplay.service;

import com.deyunjiaoyu.sportplay.bean.Classification;

import java.util.List;

public interface ClassificationService {
   List<Class> getAllClassification(String title);
   int getClassifiCounts(String title);
   int deleteClassifi(int id);
   Classification getUpdateClassifi(int id);
   int editClassifi(Classification classifi);
   int addClassifi(Classification classification);

}
