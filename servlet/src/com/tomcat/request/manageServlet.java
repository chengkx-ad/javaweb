package com.tomcat.request;

// 输出用户信息
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "manageServlet", value = "/manageServlet")
public class manageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String role = (String) request.getAttribute("role");

        response.setContentType("text/html; charset = utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(username + "：" + role);
        writer.flush();
        writer.close();
    }
}