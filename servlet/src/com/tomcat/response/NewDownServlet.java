package com.tomcat.response;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NewDownServlet", value = "/NewDownServlet")
public class NewDownServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("newdownsetvlet被调用");
        response.setContentType("application/x-tar; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("下载开始~~");
        writer.flush();
        writer.close();
    }
}