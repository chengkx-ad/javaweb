package com.tomcat;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletContext", value = "/Sc")
public class ServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        javax.servlet.ServletContext context = getServletContext();
        String website = context.getInitParameter("website");
        String company = context.getInitParameter("company");
        // 获取项目工程路径
        String path =  context.getContextPath();
        // 获取项目发布后真正的工作路径
        String realPath = context.getRealPath("/");  // "//"表示我们的项目发布后的根路径
        System.out.println(website);
        System.out.println(company);
        System.out.println(path);
        System.out.println(realPath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}