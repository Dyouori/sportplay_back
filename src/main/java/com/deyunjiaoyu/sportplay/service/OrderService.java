package com.deyunjiaoyu.sportplay.service;



import com.deyunjiaoyu.sportplay.bean.Order;

import java.util.List;

public interface OrderService {

//    获取所有普通用户
    List<Order> getAllOrder(String username, int pageStart, int pageSize);

    int getOrderCounts(String username);
    int getOneOrderCounts(int id);

    int editOrder(int id);
    int deleteOrder(int id);
    List<Order> getOrder(int id, int pageStart, int pageSize);
    int Recharge(int money,int id);
    int getMoney(int id);
    int addOrder(Order order);
    int backOrder(int user_id,int orderId,int money);
    int payOrder(int user_id,int money);
}
