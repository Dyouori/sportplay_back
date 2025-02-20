package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.*;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import com.deyunjiaoyu.sportplay.service.OrderService;
import com.deyunjiaoyu.sportplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
//    获取用户的
    @RequestMapping("/alluser")
    public String getAllUser(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字
      int numbers = userService.getUserCounts("%"+queryInfo.getQuery()+"%");
      int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
      List<User> users = userService.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
      HashMap<String,Object> res = new HashMap<>();
      res.put("numbers",numbers);
      res.put("data",users);
      String res_string = JSON.toJSONString(res);
      return res_string;
    }
//    获取管理员的
    @RequestMapping("/alladmin")
    public String getAllAdmin(String username){

        List<User> users = userService.getAllAdmin(username);
        HashMap<String,Object> res = new HashMap<>();
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
//修改
    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id")Integer id,@RequestParam("state")Boolean state){
        int i = userService.updateState(id,state);
        return i > 0 ? "success" : "error";
    }
    ///添加
    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user) {

        // 检查数据库中是否已存在相同的username
        User existingUser = userService.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getId()!=user.getId()) {
            // 如果存在且不是当前用户，则返回错误
            return "error2";
        }
        // 添加用户逻辑
        // 假设userService.addUser()返回的是受影响的行数
        int rowsAffected = userService.addUser(user);

        // 检查是否添加成功
        if (rowsAffected > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    //删除
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userService.deleteUser(id);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        // 检查数据库中是否已存在相同的username
        User existingUser = userService.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getId()!=user.getId()) {
            // 如果存在且不是当前用户，则返回错误
            return "error2";
        }
        int i = userService.editUser(user);
        return i > 0 ? "success":"error";
    }

//修改权限
    @RequestMapping("/changeUser")
    public String changeUser(@RequestParam("role")String role,@RequestParam("id")Integer id){
        int i = userService.changeUser(role,id);
        System.out.println(role+""+id);
        return i > 0 ? "success":"error";

    }

    @RequestMapping("/getupdateUser")
    public String getUpdateUser(int id){
        User user = userService.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
}

    @RequestMapping("/addMoney")
    public int addMoney(int id,int orderId){
      //  System.out.println("我进来了"+orderId+id);
        int curMoney = orderService.getMoney(id);
      //  System.out.println(curMoney);
        int amount = 0;
        switch (orderId) {
            case 0:
                amount =curMoney + 50;

                break;
            case 1:
                amount = curMoney + 150;
                break;
            case 2:
                amount = curMoney + 500;
                break;
            // 可以添加更多的 case 来处理不同的 orderId
            default:
                amount = curMoney + orderId;
                break;
        }
        int i = userService.addMoney(amount,id);
        return i;
    }

    @RequestMapping("/getWeight")
    public String getWeight(@RequestParam("id")Integer id){
        UserCondition userCondition = userService.getWeight(id);
       // System.out.println("我在找"+id);
        String string = JSON.toJSONString(userCondition);
        return string;
    }

//设置理想体重或者是自己体重
    @PostMapping(value = "/setWeight", consumes = "application/x-www-form-urlencoded")
    public int setWeight(@RequestParam("id") Integer id,
                         @RequestParam("weight") Integer weight,
                         @RequestParam("dreamWeight") Integer dreamWeight) {
      //  System.out.println(id+"aaa"+"bbb"+weight);
        int i =userService.setWeight(id,weight,dreamWeight);
        LocalDateTime currentTime = LocalDateTime.now();
        int m = userService.weightLog(id, currentTime, weight);

        return i;
    }
    //获取用户评论
    @RequestMapping("/getUserComment")
    public String getUserComment(int id,QueryInfo queryInfo){
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        List<Comment> comment = userService.getUserComment(id,pageStart,queryInfo.getPageSize());
        String string = JSON.toJSONString(comment);
        return string;
    }
    //存储用户评论
   @RequestMapping("/sendComment")
    public String sendComment(@RequestBody Comment comment){

       Date comment_time = new Date();
       System.out.println(comment.getUser_id()+comment.getClass_id()+comment.getContent());
       int i = userService.sendComment(comment.getUser_id(),comment.getClass_id(),comment.getContent(),comment_time);
       return i > 0 ? "success" : "error";
   }
   //编辑健康数据
   @RequestMapping("/editHealth")
    public String editHealth(@RequestBody HealthData healthData){
//        int id = healthData.getUser_id();
       HealthData user = userService.findUser(healthData.getUser_id());

       if(user != null){
           LocalDateTime currentTime = LocalDateTime.now();
           int m = userService.weightLog(healthData.getUser_id(), currentTime, healthData.getWeight());
           int rowsAffected = userService.editHealth(healthData);
//            检查是否添加成功
       if (rowsAffected > 0) {
           return "success";
       } else {
           return "error";
       }

       }else{
           LocalDateTime currentTime = LocalDateTime.now();
           int n = userService.weightLog(healthData.getUser_id(), currentTime, healthData.getWeight());
           int isUp = userService.editHealth(healthData);
           if (isUp > 0) {
               return "success";
           } else {
               return "error";
           }
       }

   }
   //看看数据库里有没有健康数据
    @RequestMapping("/getHealth")
    public String getHealth(int id){
        List<HealthData> healthData = userService.getHealth(id);
        String string = JSON.toJSONString(healthData);
        return string;
    }

    //查询记录的步数--测试成功get
    @RequestMapping("/getRun")
    public String getRun(int user_id){
        List<RunData> runData = userService.getRun(user_id);
        String string = JSON.toJSONString(runData);
        return string;
    }
    //插入记录的步数------测试通过post
    @RequestMapping("/addRun")
    public String addRun(@RequestParam("user_id") int user_id,
                         @RequestParam("date") String date,
                         @RequestParam("step") String step){
        LocalDateTime currentTime = LocalDateTime.now();
        int rowsAffected = userService.addRun(user_id,date,step,currentTime);
        if (rowsAffected > 0) {
            return "success";
        } else {
            return "error";
        }
    }
    //根据日期和id查询,更新步数----测试通过get
    @RequestMapping("/editRunByDate")
    public String getRundata(
            @RequestParam("user_id") int user_id,
            @RequestParam("date") String date,
            @RequestParam("step") String newStep

    ) {
        int i = userService.getRundataByUserIdAndDate(user_id, date,newStep);
        if(i>0){
            return "find";
        }
        else {
            return "no";
        }
    }
    @RequestMapping("/addTodayCalorie")
    public String addTodayCalorie(@RequestParam("user_id") int user_id,@RequestParam("calorie") int calorie){
        LocalDateTime currentTime = LocalDateTime.now();
        // 获取当前日期的年月日部分
        String currentDate = currentTime.toLocalDate().toString();
        // 检查数据库中是否已经存在记录
        boolean exists = userService.existsTodayCalorie(user_id, currentDate);
        if (!exists) {
            // 如果不存在，调用addTodayCalorie方法添加记录
            int i = userService.addTodayCalorie(user_id, calorie, currentTime);
            return i > 0 ? "success" : "error";
        } else {
            // 如果存在，那我就是修改
            int m = userService.editTodayCalorie(user_id, calorie, currentDate);
            return m > 0 ? "success2" : "error2";
        }
    }

    @RequestMapping("/getAllCalorie")
    public String getAllCalorie(@RequestParam("user_id") int user_id){

        List<TodayCalorie> users = userService.getAllCalorie(user_id);
        HashMap<String,Object> res = new HashMap<>();
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }
    //获取全部评论
    @RequestMapping("/getcomment")
    public String getAllComment(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字
        int numbers = userService.getCommentCounts();
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        List<Comment> users = userService.getAllComment(pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(int id){
        int i = userService.deleteComment(id);
        return i > 0 ? "success":"error";
    }
}


