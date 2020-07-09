package com.sl.book_manager.controller;

import com.sl.book_manager.persist.entity.User;
import com.sl.book_manager.service.UserService;
import com.sl.book_manager.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 16:48
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册用户
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String register(User user, HttpSession session) {
        //String sessionCode = (String) session.getAttribute("code");
        //if (sessionCode.equalsIgnoreCase(code)) {
        //如果验证码正确，跳转到图书管理系统主页
        userService.register(user);
        return "redirect:/toLogin";
        //} else {
        //    如果验证码错误，刷新注册页面
        //return "redirect:/toRegister";
        //}
    }

    /**
     * 生成二维码
     *
     * @param session
     * @param response
     */
    @RequestMapping("/code")
    public void getVerification(HttpSession session, HttpServletResponse response) throws IOException {
        //生成二维码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //存入session
        session.setAttribute("code", securityCode);
        //响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);

    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletResponse response, RedirectAttributes attributes) {
        User user = userService.login(username, password);
        if (user != null) {
            //创建Cookie对象
            Cookie userCookie = new Cookie("userCookie", user.getUserName());
            //设置Cookie的生命周期为一周
            userCookie.setMaxAge(7 * 24 * 60 * 60);
            //设置路径为全路径（同一个项目下的页面都可以访问）
            userCookie.setPath("/");
            response.addCookie(userCookie);
            return "redirect:/book/findAll";
        } else {
            attributes.addAttribute("msg","密码错误");
            return "redirect:/toLogin";
        }
    }


}
