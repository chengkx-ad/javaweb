package com.tomcat;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/pig1", "/pig2"})
public class PigServlet extends HttpServlet {

    int count1 = 0;
    int count2 = 0;

    @Override
    public void init() throws ServletException {
        System.out.println("pigServlet已加载");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        count1++;
        System.out.println("GET调用次数=" + count1);

        // 通过response  获取PrintWriter流
        // 告诉浏览器   编码设置
        response.setContentType("text/html; charset = utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>登录成功--</h1>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        count2++;
        System.out.println("pigServlet-doPost 被调用");
        System.out.println("POST调用次数=" + count2);
        System.out.println();
    }
}