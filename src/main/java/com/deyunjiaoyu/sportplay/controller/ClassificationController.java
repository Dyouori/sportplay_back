package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.Classification;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class ClassificationController {

    @Autowired
    private ClassificationService classService;

    @RequestMapping("/allclassification")
    public String getAllClassification(QueryInfo queryInfo){

        int numbers = classService.getClassifiCounts("%"+queryInfo.getQuery()+"%");
        List<Class>classes = classService.getAllClassification("%"+queryInfo.getQuery()+"%");
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",classes);
        String res_string = JSON.toJSONString(res);
       // System.out.println(res_string);
        return res_string;
    }
    @RequestMapping("/deleteClassfi")
    public String deleteClassfi(int id){
        int i = classService.deleteClassifi(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/classifiupdate")
    public String getUpdateClassifi(int id){
        Classification classifi = classService.getUpdateClassifi(id);
        String string = JSON.toJSONString(classifi);
        return string;
    }
    @RequestMapping("/editclassfi")
    public String editClassifi(@RequestBody Classification classifi){
        int i = classService.editClassifi(classifi);
        return i > 0 ? "success":"error";
    }

    ///添加
    @RequestMapping("/addclassifi")
    public ResponseEntity<String> addClassifi(@RequestBody Classification classification) {
        if (!classService.getAllClassification(classification.getTitle()).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }

        int rowsAffected = classService.addClassifi(classification);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/batchdelete")
    public String batchDelete(@RequestBody List<Classification> ids) {
        System.out.println(121212);
        for(Classification classification: ids) {
            int i = classService.deleteClassifi(classification.getId());
            if(i < 0) {
                return "error";
            }
        }
        return "success"; // 返回成功消息
    }



}
