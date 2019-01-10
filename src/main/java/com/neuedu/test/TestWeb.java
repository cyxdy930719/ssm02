package com.neuedu.test;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestWeb {
    @Resource
    private IUserService service;
    private UserDao dao;
    @Test
    public void test(){
        List<User> list = service.getUsers();
        for (User u:list){
            System.out.println(u);
        }
    }

    @Test
    public void test1(){
        User user= service.getOne("root");
        System.out.println(user);
    }
    @Test
    public void test2(){
        User user = new User();
        user.setUsername("root");
        List<User> u = service.likeUsers(user);
        System.out.println(u);
    }
}
