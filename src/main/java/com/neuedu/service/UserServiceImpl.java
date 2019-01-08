package com.neuedu.service;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;
    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }
    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
