package com.neuedu.until;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUntil {
    public static Map<String,Cookie> getCookies(Cookie[] cookie){
        Map<String,Cookie> maps = new HashMap<>();
        if(cookie!=null){
            for (Cookie coo:cookie){
                maps.put(coo.getName(),coo);
            }
        }
        return maps;
    }
}
