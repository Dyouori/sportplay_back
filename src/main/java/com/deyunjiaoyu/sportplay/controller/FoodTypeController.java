package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.FoodType;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class FoodTypeController {
    @Autowired
    private FoodService foodService;

    @RequestMapping("/allfoodtype")
    public String getAllFoodType(QueryInfo queryInfo){

        int numbers = foodService.getFoodTypeCounts("%"+queryInfo.getQuery()+"%");
        List<FoodType> classes = foodService.getAllFoodType("%"+queryInfo.getQuery()+"%");
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",classes);
        String res_string = JSON.toJSONString(res);
        // System.out.println(res_string);
        return res_string;
    }
    @RequestMapping("/deletefoodtype")
    public String deleteFoodType(int id){
        int i = foodService.deleteFoodType(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/updatefoodtype")
    public String getUpdateFoodType(int id){
        FoodType classifi = foodService.getUpdateFoodType(id);
        String string = JSON.toJSONString(classifi);
        return string;
    }
    @RequestMapping("/editfoodtype")
    public String editFoodType(@RequestBody FoodType classifi){
        int i = foodService.editFoodType(classifi);
        return i > 0 ? "success":"error";
    }

    ///添加
    @RequestMapping("/addfoodtype")
    public ResponseEntity<String> addFoodType(@RequestBody FoodType classification) {
        if (!foodService.getAllFoodType(classification.getTitle()).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }

        int rowsAffected = foodService.addFoodType(classification);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/batchdeletetype")
    public String batchDelete(@RequestBody List<FoodType> ids) {
        System.out.println(121212);
        for(FoodType classification: ids) {
            int i = foodService.deleteFoodType(classification.getId());
            if(i < 0) {
                return "error";
            }
        }
        return "success"; // 返回成功消息
    }



}
