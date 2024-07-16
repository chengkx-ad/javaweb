package com.tomcat.request;
// 跳转请求

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 分配用户等级

@WebServlet(name = "checkServlet", value = "/checkServlet")
public class checkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        if ("tom".equals(username)){
            request.setAttribute("role", "管理员");
        }else {
            request.setAttribute("role", "普通用户");
        }
        /*
        * "/manageServlet"  这里的/会被解析为/servlet
        * 用于请求转发   checkServlet执行后，tomcat会调用manageServlet
        */
        RequestDispatcher requestDispatcher
                = request.getRequestDispatcher("/manageServlet");
        // 请求转发的这几个servlet共享同一组request和response
        // forward的作用就是将目前的request送给manageServlet
        // 但是所有的servlet都由tomcat调用
        requestDispatcher.forward(request, response);
    }
}