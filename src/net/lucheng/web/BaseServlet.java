package net.lucheng.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取方法名
            String method = req.getParameter("method");
            //获取当前对象的字节码文件
            Class clazz = this.getClass();
            //获取字节码里对象里的方法
            Method clazzMethod = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //执行这个方法
            clazzMethod.invoke(this,req,resp);

            // ==== 修改子类 servlet 里的  private 改成 public


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
