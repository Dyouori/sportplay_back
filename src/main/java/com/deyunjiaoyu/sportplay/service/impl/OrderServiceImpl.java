package com.deyunjiaoyu.sportplay.service.impl;


import com.deyunjiaoyu.sportplay.bean.Order;
import com.deyunjiaoyu.sportplay.dao.OrderDao;
import com.deyunjiaoyu.sportplay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Order> getAllOrder(String username, int pageStart, int pageSize) {
        return orderDao.getAllOrder(username, pageStart, pageSize);
    }

    @Override
    public int getOrderCounts(String username) {
        return orderDao.getOrderCounts(username);
    }

    @Override
    public int getOneOrderCounts(int id) {
        return orderDao.getOneOrderCounts(id);
    }

    @Override
    public int deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }
    @Override
    public int editOrder(int user) {
        return orderDao.editOrder(user);
    }

    @Override
    public List<Order> getOrder(int id, int pageStart, int pageSize) {
        return orderDao.getOrder(id, pageStart, pageSize);
    }

    @Override
    public int Recharge(int money,int id) {
        return orderDao.Recharge(money,id);
    }
    @Override
    public int getMoney(int id) {
        return orderDao.getMoney(id);
    }
    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }
    @Override
    public int backOrder(int user_id,int orderId,int money) {
        return orderDao.backOrder(user_id,orderId,money);
    }
    @Override
    public int payOrder(int user_id,int money) {
        return orderDao.payOrder(user_id,money);
    }
}
