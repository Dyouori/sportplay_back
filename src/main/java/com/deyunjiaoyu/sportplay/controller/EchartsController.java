package com.deyunjiaoyu.sportplay.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import com.deyunjiaoyu.sportplay.bean.WeightLog;
import com.deyunjiaoyu.sportplay.service.ClassService;
import com.deyunjiaoyu.sportplay.service.UserService;
import com.deyunjiaoyu.sportplay.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class EchartsController {
    @Autowired
    private ClassService classService;
    @Autowired
    private UserService userService;
    //课程表
    @RequestMapping("/sport/bie")
    public Result bie(){
//        查出所有的课程
        List<ClassInfo> list = classService.findClassChart();
//        我需要把分类都摘出来然后相同的计数
//        stream流
//        先把这个list打散,过滤每一项，再连接，分组是通过key，value，然后这样分组
       Map<String,Long> collect = list.stream()
               .filter(x -> ObjectUtil.isNotEmpty(x.getClassification_title()))
               .collect(Collectors.groupingBy(ClassInfo::getClassification_title,Collectors.counting()));

        List<Map<String,Object>> mapList = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(collect)){
            for(String key : collect.keySet()){
                Map<String,Object> map = new HashMap<>();
                map.put("name",key);
                map.put("value",collect.get(key));
                mapList.add(map);
            }
        }
        return Result.success(mapList);
    }
    //体重变化趋势图
    @RequestMapping("/sport/weightChart")
    public Result weightChart(int id){
        List<WeightLog> list = userService.weightChart(id);
      //  System.out.println("啊啊啊"+Result.success(list));
        return Result.success(list);
    }
}
