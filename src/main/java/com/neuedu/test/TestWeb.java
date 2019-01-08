package com.neuedu.test;

import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
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
    private UserDao dao;
    @Test
    public void test(){
        List<User> users = dao.getUsers();
        for(User u:users){
            System.out.println(u);
        }
    }
}
