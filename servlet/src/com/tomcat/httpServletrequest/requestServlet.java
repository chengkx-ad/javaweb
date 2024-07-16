package com.tomcat.httpServletrequest;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestServlet", value = "/rs")
public class requestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取请求头的字段   部分方法演示
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);

        String uri1 = request.getHeader("URI");
        System.out.println(uri1);

        String cookie = request.getHeader("Cookie");
        String s = cookie.split("=")[1];
        System.out.println("JSESSIONID =  " + s);

        // 获取表单数据
        String username = request.getParameter("username");
        System.out.println("用户名 = " + username);

        // 获取一组表单数据
        // 多选项  单选项  下拉框等等
        String[] parameterValues = request.getParameterValues("");

    }
}