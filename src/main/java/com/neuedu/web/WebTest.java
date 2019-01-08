package com.neuedu.web;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/index.do")
    public String index(ModelMap map){
        List<User> users = service.getUsers();
        map.addAttribute("users",users);
        return "index";
    }
    @RequestMapping("/login.do")
    public String login(){

        return "login";
    }
}
