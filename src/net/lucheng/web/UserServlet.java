package net.lucheng.web;

import net.lucheng.bean.User;
import net.lucheng.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getParameter("method");
//        if ("login".equals(method)) {
//            login(request, response);
//        } else if ("register".equals(method)) {
//            register(request, response);
//        }
//    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User sa = new User();
        User user = null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserService userService = new UserService();
        try {
            BeanUtils.populate(sa, parameterMap);
            user = userService.login(sa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
//            String remember = request.getParameter("remember");
//
//            if (remember.equals("yes")) {
//                //记住密码
//                Cookie nameCookie = new Cookie("user", sa.getUser());
//                Cookie passwordCookie = new Cookie("password", sa.getPassword());
//                //设置cookie 有效期 防止销毁
//                nameCookie.setMaxAge(60*10);
//                passwordCookie.setMaxAge(60*10);
//                //将Cookie 发送给客户端保存
//                response.addCookie(nameCookie);
//                response.addCookie(passwordCookie);
//            }
            response.sendRedirect(request.getContextPath() + "/main.jsp");
        } else
        {
            //登录失败提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录失败");
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user = request.getParameter("user");
//        String password = request.getParameter("password");
//        String phone = request.getParameter("phone");
//        String name = request.getParameter("name");
        User sa = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(sa,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService = new UserService();
        boolean register = userService.register(sa);

        if (register) {
            response.sendRedirect(request.getContextPath() + "login.jsp");
        } else
        {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("注册失败");
        }



    }
}
