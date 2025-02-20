package com.deyunjiaoyu.sportplay.service;

import com.deyunjiaoyu.sportplay.bean.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface UserService {
    User getUserByMessage(String username, String password, String role);
//    获取所有普通用户
    List<User> getAllUser(String username, int pageStart, int pageSize);
//    管理员
    List<User> getAllAdmin(String username);

    int getUserCounts(String username);
    int updateState(Integer id, Boolean state);
    int addUser(User user);
    int deleteUser(int id);
    User getUpdateUser(int id);
    int editUser(User user);
    int changeUser(String role, int id);
    // 假设这个方法根据username查找用户
    User findByUsername(String username);

//    注册
    Boolean insertNewUser(User user);
int addMoney(int amount,int id);
UserCondition getWeight(Integer  id);
    int setWeight(Integer id, Integer weight,Integer dreamWeight);
    int weightLog(Integer userId, LocalDateTime currentTime,Integer weight);
    List<WeightLog> weightChart(int id);

    int classCollected(Integer id,int userId);
    int classUnCollected(Integer id,int userId);

    List<Comment> getUserComment(int id,int pageStart, int pageSize);
    int sendComment(Integer user_id, Integer class_id, String content, Date comment_time);

    int editHealth(HealthData healthData);
    HealthData findUser(int id);

    List<HealthData>getHealth(int id);
    List<RunData>getRun(int id);
    int addRun(int user_id,String date, String step,LocalDateTime currentTime);
    int getRundataByUserIdAndDate(int id,String date,String newStep);
    int addTodayCalorie(int user_id, int calorie, LocalDateTime currentTime);
    boolean existsTodayCalorie(int user_id,String currentDate);
    int editTodayCalorie(int user_id, int calorie, String currentDate);
    List<TodayCalorie> getAllCalorie(int user_id);
    List<Comment> getAllComment(int pageStart, int pageSize);
    int getCommentCounts();
    int deleteComment(int id);
}
