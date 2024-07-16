package com.tomcat.pay;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pServlet", value = "/pServlet")
public class pServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = getServletContext().getContextPath();
        String money = request.getParameter("money");
        int i = method.parseInt(money);
        if (i > 100) {
            response.sendRedirect(path + "/payok.html");
        }else {
            response.sendRedirect(path + "/login.html");
        }
    }
}