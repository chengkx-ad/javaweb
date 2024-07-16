package com.tomcat;

import java.io.*;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class payServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletContext servletContext = getServletContext();

        Object visit_count = servletContext.getAttribute("visit_count");
        if (visit_count == null) {
            servletContext.setAttribute("visit_count", 1);
            visit_count = 1;
        }else {
            visit_count = Integer.parseInt(visit_count + "") + 1;
            servletContext.setAttribute("visit_count", visit_count);
        }

        // 设置输出格式
        response.setContentType("text/html; charset = utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("网站访问次数为：" + visit_count);
        writer.flush();
        writer.close();
    }
}