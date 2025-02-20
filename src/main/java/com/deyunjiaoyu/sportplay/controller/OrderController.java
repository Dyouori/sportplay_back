package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.Order;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;


import com.deyunjiaoyu.sportplay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sport")
public class OrderController {
    @Autowired
    private OrderService orderService;
//    获取用户的
    @RequestMapping("/allorder")
    public String getAllOrder(QueryInfo queryInfo){
        //获取查询信息和当前编号
        //只能根据username查名字
      int numbers = orderService.getOrderCounts("%"+queryInfo.getQuery()+"%");
      int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
      List<Order> users = orderService.getAllOrder("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
      HashMap<String,Object> res = new HashMap<>();
      res.put("numbers",numbers);
      res.put("data",users);
      String res_string = JSON.toJSONString(res);

      return res_string;
    }
    //删除
    @RequestMapping("/deleteorder")
    public String deleteOrder(int id){
        int i = orderService.deleteOrder(id);
        return i > 0 ? "success":"error";
    }
//    取消
    @RequestMapping("/cancelOrder")
    public String editOrder(int id){
        int i = orderService.editOrder(id);
        return i > 0 ? "success":"error";
    }
//    查找本用户的所有订单
    @RequestMapping("/getorder")
    public String  getOrder(QueryInfo queryInfo){
        int pageStart =  (queryInfo.getPageStart()-1)*queryInfo.getPageSize();
        int numbers = orderService.getOneOrderCounts(queryInfo.getQueryId());
        List<Order> users = orderService.getOrder(queryInfo.getQueryId(),pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);

        return res_string;
    }

//    充值
@RequestMapping("/recharge")
public String  Recharge(int money,int id){
    int i = orderService.Recharge(money,id);
    return i > 0 ? "success":"error";

}
    @RequestMapping("/getMoney")
    public int  getMoney(int id){

        int i = orderService.getMoney(id);
       // System.out.println("啊啊啊啊啊啊啊啊"+i);
        return i;
    }
    //开始买东西加订单
    @RequestMapping("/addOrder")
    public String  addOrder(@RequestParam("user_id") Integer user_id,
                            @RequestParam("class_id") Integer class_id,
                            @RequestParam("price") String price,
                            @RequestParam("status") String status,
                            @RequestParam("order_number") String order_number,
                            @RequestParam("name") String name,
                            @RequestParam("phone") String phone
    ){
        // 根据查询参数创建Order对象
        Order order = new Order();
        order.setUser_id(user_id);
        order.setClass_id(class_id);
        order.setPrice(price);
        order.setStatus(status);
        order.setOrder_number(order_number);
        order.setName(name);
        order.setPhone(phone);
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 获取当前日期的年月日部分
        String currentDateStr = currentTime.toLocalDate().toString();

        // 将字符串转换为LocalDate对象
        LocalDate currentDate = LocalDate.parse(currentDateStr);

        // 如果你需要java.util.Date类型，你可以进一步转换
        java.util.Date pay_time = java.sql.Date.valueOf(currentDate);

        order.setPay_time(pay_time);

        int i = orderService.addOrder(order);
        return i > 0 ? "success":"error";
    }
    //取消订单
    @RequestMapping("/backOrder")
    public String backOrder(int user_id,int orderId,int money){
        int i = orderService.backOrder(user_id,orderId,money);
        return i > 0 ? "success":"error";
    }
    //支付订单
    @RequestMapping("/payOrder")
    public String payOrder(int user_id,int money){
        System.out.println("支付订单："+user_id);
        int i = orderService.payOrder(user_id,money);
        return i > 0 ? "success":"error";
    }
}


