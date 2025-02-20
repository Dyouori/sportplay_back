package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;

import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.service.UserService;
import com.deyunjiaoyu.sportplay.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.HashMap;

@RestController
@RequestMapping("/sport")
public class LoginController {
    @Autowired
    private UserService userService;
// 这表示你想要 Spring 容器自动注入一个 UserDao 类型的 bean 到这个字段中。


    @RequestMapping("/login")
//    当客户端（如前端JavaScript代码）发送POST或PUT请求，并且请求体中包含数据时，服务器端的Spring MVC控制器可以使用带有@RequestBody注解的参数来接收这些数据。
    public String login(@RequestBody User user){
        String flag = "error";
// 假设数据库中查询到了该用户，这里测试先所及生成一个UUID，作为用户的id
        String userId = UUID.randomUUID().toString();

        HashMap<String,Object> res = new HashMap<>();
        User us = userService.getUserByMessage(user.getUsername(),user.getPassword(),user.getRole());
        // 准备存放在JWT中的自定义数据
        HashMap<String,Object> info  = new HashMap<>();
        info.put("username", user.getUsername()); // 使用实际的username
        info.put("pass", user.getPassword()); // 使用实际的pass
        // 生成JWT字符串
        String token = JwtUtil.sign(userId, info);


        if(us!=null){
            flag = "ok";
        }
        res.put("token",token);
        res.put("flag",flag);
        res.put("user",us);
        String res_json = JSON.toJSONString(res);//把对象转换成一个json串
System.out.println("生成的token是："+token);
        return res_json;
    }

    //注册
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if (!userService.getAllUser(user.getUsername(),1,5).isEmpty()) {
            return new ResponseEntity<>("error2", HttpStatus.BAD_REQUEST);
        }
        if (userService.insertNewUser(user)) {
            return new ResponseEntity<>("注册成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("注册失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}

