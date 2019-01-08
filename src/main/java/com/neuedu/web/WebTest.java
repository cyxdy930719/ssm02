package com.neuedu.web;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("/dologin.do")
    public String dologin(String username, String pwd, HttpServletRequest request){
        User user = service.getOne(username);
        if (user!=null){
            if (pwd.equals(user.getPassword())){
                Cookie coo = new Cookie("username",username);
                Cookie coo1 = new Cookie("pwd",pwd);
                coo.setMaxAge(24*60*60*7);
                coo1.setMaxAge(24*60*60*7);
                HttpSession seesion = request.getSession();
                seesion.setAttribute("user",user);
            }
        }
        return "redirect:index.do";
    }
}
