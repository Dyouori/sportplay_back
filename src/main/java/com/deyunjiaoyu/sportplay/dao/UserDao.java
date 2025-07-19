package com.deyunjiaoyu.sportplay.dao;

import com.deyunjiaoyu.sportplay.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//@Repository 是 Spring 框架中的一个注解，它用于标记类，表示这个类是数据访问层（Data Access Layer，DAL）的一部分，通常用于与数据库进行交互的类
@Repository
public interface UserDao {
//    名字相同就不用穿这个注解
    //找mapping
    public User getUserByMessage(@Param("username") String username, @Param("password") String password, @Param("role") String role);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username")String username);
    public User findByUsername(@Param("username") String username);
    public List<User> getAllAdmin(@Param("username")String username);

    public int updateState(Integer id,Boolean state);

    public int addUser(User user);

    public int deleteUser(int id);

    public User getUpdateUser(int id);
    public int editUser(User user);
    public int changeUser(String role,int id);

    //注册
    public Boolean insertNewUser(User user);
    public int addMoney(int amount,int id);
    public UserCondition getWeight(@Param("id")Integer   id);
    public int setWeight(Integer id, Integer weight,Integer dreamWeight);
    public int weightLog(Integer id, LocalDateTime currentTime, Integer weight);
    public  List<WeightLog> weightChart(int id);

    //收藏课程
    public int classCollected(@Param("id")Integer id,int userId);
    public int classUnCollected(@Param("id")Integer id,int userId);

    public List<Comment> getUserComment(@Param("id")int id,@Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    public int sendComment(Integer user_id, Integer class_id, String content, Date comment_time);
    public int editHealth(HealthData healthData);
    public HealthData findUser(int id);
    public List<HealthData> getHealth(int id);
    public List<RunData> getRun(int id);
    public int addRun(int user_id,String date, String step,LocalDateTime currentTime);
    public int getRundataByUserIdAndDate(int id,String date,String newStep);
    public int addTodayCalorie(int user_id, int calorie, LocalDateTime currentTime);
    public boolean existsTodayCalorie(int user_id,String currentDate);
    public int editTodayCalorie(int user_id, int calorie, String currentDate);
    public List<TodayCalorie> getAllCalorie(int user_id);
    public List<Comment> getAllComment( @Param("pageStart") int pageStart,@Param("pageSize") int pageSize);
    public int getCommentCounts();
    public int deleteComment(int id);
    public String getUserPic(int id);
}
