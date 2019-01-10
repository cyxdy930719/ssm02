package com.neuedu.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mysql.jdbc.MultiHostMySQLConnection;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class WebTest {
    @Autowired
    private IUserService service;
    @RequestMapping("/index.do")
    public String index(ModelMap map,HttpServletRequest req,User user){
        int pageNum = req.getParameter("pageNum")==null?1:Integer.parseInt(req.getParameter("pageNum"));
        /*第几页*/
        int pageSize = 2;
        /*显示几条数据*/
        PageHelper.startPage(pageNum,pageSize);
        List<User> likeUsers=null;
        PageInfo<User> page = null;
        if(StringUtils.isBlank(user.getUsername())){
            user.setUsername(null);
            likeUsers = service.likeUsers(user);
            page = new PageInfo<>(likeUsers,4);
            map.addAttribute("page",page);
            map.addAttribute("users",likeUsers);
        }else{
            likeUsers = service.likeUsers(user);
            String uname = "&username="+user.getUsername();
            page = new PageInfo<>(likeUsers,4);
            map.addAttribute("uname",uname);
            map.addAttribute("page",page);
            map.addAttribute("users",likeUsers);
        }

        return "index";
    }
    @RequestMapping("/login.do")
    public String login(){

        return "login";
    }

    @RequestMapping("/dologin.do")
    public String dologin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = service.getOne(username);
        if (user!= null) {
            if (password.equals(user.getPassword())) {
                Cookie coo = new Cookie("username", username);
                Cookie coo1 = new Cookie("password", password);
                coo.setMaxAge(24 * 60 * 60 * 7);
                coo1.setMaxAge(24 * 60 * 60 * 7);
                response.addCookie(coo);
                response.addCookie(coo1);
                System.out.println(coo.getName()+"  "+coo.getValue());
                HttpSession seesion = request.getSession();
                seesion.setAttribute("user", user);
                return "redirect:index.do";
            }
        }
            return "redirect:login.do";
    }

    @RequestMapping("/doload.do")
    public String doload(@RequestParam("files") MultipartFile[] files){
        /*String filename = file.getOriginalFilename();
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File("C:\\Users\\hasee\\Pictures\\Saved Pictures\\"+filename));

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        for (int i=0;i<=files.length;i++){
            String filename = files[i].getOriginalFilename();
            File f = new File("C:\\Users\\hasee\\Pictures\\Saved Pictures\\"+filename);
            try {
                FileUtils.copyInputStreamToFile(files[i].getInputStream(),f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}
