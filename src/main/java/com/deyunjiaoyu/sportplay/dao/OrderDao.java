package com.deyunjiaoyu.sportplay.dao;


import com.deyunjiaoyu.sportplay.bean.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository 是 Spring 框架中的一个注解，它用于标记类，表示这个类是数据访问层（Data Access Layer，DAL）的一部分，通常用于与数据库进行交互的类
@Repository
public interface OrderDao {
//    名字相同就不用穿这个注解
    //找mapping
    public List<Order> getAllOrder(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getOrderCounts(@Param("username") String username);
    public int getOneOrderCounts(@Param("id") int id);

    public int editOrder(int id);
    public int deleteOrder(int id);
    public List<Order> getOrder(@Param("id") int id, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int Recharge(@Param("money")int money,@Param("id") int id);
    public int getMoney(@Param("id") int id);
    public int addOrder(Order order);
    public int backOrder(int user_id,int orderId,int money);
    public int payOrder(int user_id,int money);
}
