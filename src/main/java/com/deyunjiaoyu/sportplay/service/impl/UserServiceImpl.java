package com.deyunjiaoyu.sportplay.service.impl;

import com.deyunjiaoyu.sportplay.bean.*;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import com.deyunjiaoyu.sportplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByMessage(String username, String password, String role) {
        return userDao.getUserByMessage(username, password, role);
    }

    @Override
    public List<User> getAllUser(String username, int pageStart, int pageSize) {
        return userDao.getAllUser(username, pageStart, pageSize);
    }

    @Override
    public int getUserCounts(String username) {
        return userDao.getUserCounts(username);
    }

    @Override
    public int updateState(Integer id, Boolean state) {
        return userDao.updateState(id, state);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUpdateUser(int id) {
        return userDao.getUpdateUser(id);
    }

    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public int changeUser(String role, int id) {
        return userDao.changeUser(role, id);
    }

    @Override
    public Boolean insertNewUser(User user) {
        return userDao.insertNewUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getAllAdmin(String username) {
        return userDao.getAllAdmin(username);
    }

    @Override
    public int addMoney(int amount,int id) {
        return userDao.addMoney(amount,id);
    }

    @Override
    public UserCondition getWeight(Integer  id){ return userDao.getWeight(id); }

    @Override
    public int setWeight(Integer id, Integer weight,Integer dreamWeight) {
        return userDao.setWeight(id,weight,dreamWeight);
    }

    @Override
    public int weightLog(Integer id, LocalDateTime currentTime, Integer weight){
        return userDao.weightLog(id,currentTime,weight);
    }

    @Override
    public  List<WeightLog> weightChart(int id){
        return userDao.weightChart(id);
    }
    @Override
    public  int classCollected(Integer id,int userId){
        return userDao.classCollected( id, userId);
    }
    @Override
    public  int classUnCollected(Integer id,int userId){
        return userDao.classUnCollected( id, userId);
    }
    @Override
    public List<Comment> getUserComment(int id, int pageStart, int pageSize){
        return userDao.getUserComment(id, pageStart, pageSize);
    }
    @Override
    public int sendComment(Integer user_id, Integer class_id, String content, Date comment_time){
        return userDao.sendComment(user_id,class_id,content,comment_time);
    }
    @Override
    public int editHealth(HealthData healthData){
        return userDao.editHealth(healthData);
    }
    @Override
    public HealthData findUser(int id){
        return userDao.findUser(id);
    }
    @Override
    public List<HealthData> getHealth(int id){
        return userDao.getHealth(id);
    }
    @Override
    public List<RunData> getRun(int id){
        return userDao.getRun(id);
    }
    @Override
    public int addRun(int user_id,String date, String step,LocalDateTime currentTime) {
        return userDao.addRun(user_id,date,step,currentTime);
    }
    @Override
    public int getRundataByUserIdAndDate(int id,String date,String newStep){
        return userDao.getRundataByUserIdAndDate(id,date,newStep);
    }
    @Override
    public int addTodayCalorie(int user_id, int calorie, LocalDateTime currentTime){
        return userDao.addTodayCalorie(user_id,calorie,currentTime);
    }
    @Override
    public boolean existsTodayCalorie(int user_id, String currentDate){
        return userDao.existsTodayCalorie(user_id,currentDate);
    }
    @Override
    public int editTodayCalorie(int user_id, int calorie, String currentDate){
        return userDao.editTodayCalorie(user_id,calorie,currentDate);
    }
    @Override
    public List<TodayCalorie> getAllCalorie(int user_id) {
        return userDao.getAllCalorie(user_id);
    }

    @Override
    public List<Comment> getAllComment(int pageStart, int pageSize) {
        return userDao.getAllComment(pageStart, pageSize);
    }

    @Override
    public int getCommentCounts() {
        return userDao.getCommentCounts();
    }
    @Override
    public int deleteComment(int id) {
        return userDao.deleteComment(id);
    }
}
