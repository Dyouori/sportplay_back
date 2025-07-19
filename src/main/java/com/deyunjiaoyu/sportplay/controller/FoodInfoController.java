package com.deyunjiaoyu.sportplay.controller;
import com.alibaba.fastjson.JSON;

import com.deyunjiaoyu.sportplay.bean.FoodInfo;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;

import com.deyunjiaoyu.sportplay.service.FoodInfoService;
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
public class FoodInfoController {
    @Autowired
    private FoodInfoService foodInfoService;
    @RequestMapping("/allfood")
    public String getAllFood(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字
        int numbers = foodInfoService.getFoodCounts("%"+queryInfo.getQuery()+"%");
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        List<FoodInfo> classes = foodInfoService.getAllFood("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",classes);
        String res_string = JSON.toJSONString(res);

        return res_string;
    }

    ///添加
    @RequestMapping("/addfood")
    public ResponseEntity<String> addUser(@RequestBody FoodInfo classes) {

        if (!foodInfoService.getAllFood(classes.getFoodName(),1,5).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }
        // 添加用户逻辑
        // 假设userService.addUser()返回的是受影响的行数
        int rowsAffected = foodInfoService.addFood(classes);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    找到要更改的那个信息
@RequestMapping("/getupdatefood")
public String getUpdateFood(int id){
    FoodInfo user = foodInfoService.getUpdateFood(id);
    String string = JSON.toJSONString(user);
    return string;
}
    @RequestMapping("/editfood")
    public String editFood(@RequestBody FoodInfo user){
        int i = foodInfoService.editFood(user);
        return i > 0 ? "success":"error";
    }

    //删除
    @RequestMapping("/deletefood")
    public String deletefood(int id){
        int i = foodInfoService.deleteFood(id);
        return i > 0 ? "success":"error";
    }

    @PutMapping("/batchdeletefood")
    public String batchDelete(@RequestBody List<FoodInfo> ids) {

        for(FoodInfo classification: ids) {
            int i = foodInfoService.deleteFood(classification.getId());
            if(i < 0) {
                return "error";
            }
        }
        return "success"; // 返回成功消息
    }
}
