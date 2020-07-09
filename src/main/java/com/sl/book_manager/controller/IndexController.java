package com.sl.book_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 16:35
 */
@Controller
public class IndexController {

    /**
     * thymeleaf跳转登录页面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toIndex(Model model) {
        model.addAttribute("msg",model.getAttribute("msg"));
        return "book/login";
    }

    /**
     * thymeleaf跳转注册页面
     *
     * @return
     */
    @RequestMapping("toRegister")
    public String register() {
        return "book/regist";
    }

    @RequestMapping("toSave")
    public String toSave() {
        return "book/addBook";
    }

    @RequestMapping("toLogout")
    public String toLogout(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();//获取cookie数组
        //遍历cookie
        for (Cookie c : cookies) {
            if (c.getName().equals("userCookie")) {
                Cookie cookie = new Cookie(c.getName(), null);//删除前必须要new 一个valu为空；
                cookie.setPath("/");//路径要相同
                cookie.setMaxAge(0);//生命周期设置为0
                break;
            }
        }
        return "redirect:/toLogin";
    }
}
