package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;

import com.deyunjiaoyu.sportplay.bean.FoodBook;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;

import com.deyunjiaoyu.sportplay.service.FoodBookService;
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
public class FoodBookController {
    @Autowired
    private FoodBookService foodBookService;
    @RequestMapping("/allbook")
    public String getAllBook(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字
        int numbers = foodBookService.getBookCounts("%"+queryInfo.getQuery()+"%");
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        List<FoodBook> classes = foodBookService.getAllBook("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",classes);
        String res_string = JSON.toJSONString(res);

        return res_string;
    }

    ///添加
    @RequestMapping("/addbook")
    public ResponseEntity<String> addBook(@RequestBody FoodBook classes) {

        if (!foodBookService.getAllBook(classes.getCook_name(),1,5).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }
        // 添加用户逻辑
        // 假设userService.addUser()返回的是受影响的行数
        int rowsAffected = foodBookService.addBook(classes);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    找到要更改的那个信息
@RequestMapping("/getupdatebook")
public String getUpdateBook(int id){
    FoodBook user = foodBookService.getUpdateBook(id);
    String string = JSON.toJSONString(user);
    return string;
}
    @RequestMapping("/editbook")
    public String editBook(@RequestBody FoodBook user){
        int i = foodBookService.editBook(user);
        return i > 0 ? "success":"error";
    }

    //删除
    @RequestMapping("/deletebook")
    public String deleteBook(int id){
        int i = foodBookService.deleteBook(id);
        return i > 0 ? "success":"error";
    }

    @PutMapping("/batchdeletebook")
    public String batchDelete(@RequestBody List<FoodBook> ids) {

        for(FoodBook classification: ids) {
            int i = foodBookService.deleteBook(classification.getId());
            if(i < 0) {
                return "error";
            }
        }
        return "success"; // 返回成功消息
    }
}
