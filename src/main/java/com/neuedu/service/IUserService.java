package com.neuedu.service;

import com.neuedu.pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    public User getOne(String useranme);
    public List<User> likeUsers(User user);
}
