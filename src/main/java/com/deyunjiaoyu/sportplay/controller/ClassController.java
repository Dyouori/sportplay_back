package com.deyunjiaoyu.sportplay.controller;
import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.ClassInfo;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.service.ClassService;
import com.deyunjiaoyu.sportplay.service.UserService;
import com.deyunjiaoyu.sportplay.utils.Result;
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
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private UserService userService;
    @RequestMapping("/allclass")
    public String getAllClass(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字

        int numbers = classService.getClassCounts("%"+queryInfo.getQuery()+"%");
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        List<ClassInfo> classes = classService.getAllClass("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",classes);
        String res_string = JSON.toJSONString(res);
        System.out.println("------------------------------------------------------");
    System.out.println("输出class试试"+classes);
        return res_string;
    }
    @PutMapping("/batchdeleteclass")
    public String batchDelete(@RequestBody List<ClassInfo> ids) {

        for(ClassInfo classification: ids) {
            int i = classService.deleteClass(classification.getId());
            if(i < 0) {
                return "error";
            }
        }
        return "success"; // 返回成功消息
    }
    //删除
    @RequestMapping("/deleteclass")
    public String deletefood(int id){
        int i = classService.deleteClass(id);
        return i > 0 ? "success":"error";
    }
    ///添加
    @RequestMapping("/addclass")
    public ResponseEntity<String> addUser(@RequestBody ClassInfo classes) {

        if (!classService.getAllClass(classes.getTitle(),1,5).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }
        // 添加用户逻辑
        // 假设userService.addUser()返回的是受影响的行数
        int rowsAffected = classService.addClass(classes);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    找到要更改的那个信息
@RequestMapping("/getupdateclass")
public String getUpdateClass(int id){
    ClassInfo user = classService.getUpdateClass(id);
    String string = JSON.toJSONString(user);
    return string;
}
    @RequestMapping("/editclass")
    public String editUser(@RequestBody ClassInfo user){
        int i = classService.editClass(user);
        return i > 0 ? "success":"error";
    }
//    根据类型选择当前类型的所有课程
    @RequestMapping("/oneTypeClass")
    public String oneTypeClass(QueryInfo queryInfo){

        List<ClassInfo> classes =classService.oneTypeClass(queryInfo.getQuery());
        HashMap<String,Object> res = new HashMap<>();
        res.put("data",classes);
      //  System.out.println(classes);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
//根据等级
@RequestMapping("/oneLevelClass")
public String oneLevelClass(String level){
//    System.out.println(
//            "131313"+level);
    List<ClassInfo> classes =classService.oneLevelClass(level);
    HashMap<String,Object> res = new HashMap<>();
    res.put("data",classes);
    // System.out.println(classes);
    String res_string = JSON.toJSONString(res);
    return res_string;
}

//根据id
    @RequestMapping("/classDetail")
    public Result getClassById(Integer id){
        List<ClassInfo> classes = classService.getClassById(id);
        // 检查列表是否为空
        HashMap<String,Object> res = new HashMap<>();
        res.put("data",classes);
        if (classes == null || classes.isEmpty()) {
            // 没有找到数据，返回错误信息
            return Result.error("没有找到对应的数据");
        } else {
            // 找到了数据，返回成功的结果和数据
            return Result.success(classes);
        }

    }

//    点赞课程
        @RequestMapping("/Liked")
        public String classLiked(Integer id){
            int i = classService.classLiked(id);
           // System.out.println(Result.success());
            return i > 0 ?  "0":"1";
        }
//        取消点赞
        @RequestMapping("/unLiked")
        public String classUnLiked(Integer id){
            int i = classService.classUnLiked(id);
          //  System.out.println(Result.success());
            return i > 0 ?  "0":"1";
        }

    //    收藏课程
    @RequestMapping("/Collected")
    public String classCollected(Integer id,int userId){
        int i = classService.classCollected(id);
        userService.classCollected(id,userId);
        return i > 0 ?  "0":"1";
    }
    //        取消收藏
    @RequestMapping("/unCollected")
    public String classUnCollected(Integer id ,int userId){
        int i = classService.classUnCollected(id);
       int m = userService.classUnCollected(id,userId);
        return i > 0 ?  "0":"1";
    }
}
