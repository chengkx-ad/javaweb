package com.tomcat;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class orderServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        // 查看类型
//        Class<? extends ServletContext> aClass = context.getClass();
//        System.out.println(context + "===" + aClass);
        // 调用method1
        Integer visitcount = method1.writermd(context);
        // 设置输出的格式
        response.setContentType("text/html; charset = utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("网站加载次数为：" + visitcount);
        writer.flush();
        writer.close();
    }
}