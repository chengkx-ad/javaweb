package com.tomcat;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 调用父类的init  相当于将tomcat创建的config传递给了父类GenericServlet中的config
*  后面才能接着调用getServletConfig获取config信息
* */

public class DBServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 这里必须调用父类的init  不调用init 后面的config没有值，无法显示用户名和密码
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletConfig config = getServletConfig();
        String username = config.getInitParameter("username");
        String pwd = config.getInitParameter("pwd");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + pwd);

    }
}