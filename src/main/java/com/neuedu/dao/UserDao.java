package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User getOne(String username);
    @Insert(value = "insert into user(username,password,tele) values(qqq,132,46546)")
    public int insertOnes(User user);
    public List<User> likeUsers(User user);
}
