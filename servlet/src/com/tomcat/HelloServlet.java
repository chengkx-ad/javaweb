package com.tomcat;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// 开发一个servlet  需要实现servlet接口
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init() 被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 处理浏览器的请求（包括get/post）
        // 当浏览器每请求一次，就会调用service方法
        // 当tomcat调用该方法时，会把http请求的数据封装成(实现了ServletRequest的) 对象
        //servletRequest对象，得到用户数据
        // servletResponse对象  用于给tomcat返回数据
        System.out.println("hi servlet");
        // 查看线程id


        // servletRequest下没有对应的查看哪个方法的函数  所以转成子接口
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }

    }

    public void doGet(){
        System.out.println("get被调用");
    }

    public void doPost(){
        System.out.println("post被调用");
    }

    // 返回servlet信息
    @Override
    public java.lang.String  getServletInfo() {
        return null;
    }
    // 销毁servlet时调用只有一次
    @Override
    public void destroy() {

    }
}
