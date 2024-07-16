package com.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cat")
public class DogServlet extends HttpServlet {

    int count1 = 0;
    int count2 = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count1++;
        System.out.println("dogServlet-doGet 被调用");
        System.out.println("调用次数=" + count1);
        String host = req.getRemoteAddr();
        System.out.println(host);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count2++;
        System.out.println("dogServlet-doPost 被调用");
        System.out.println("调用次数=" + count2);
    }
}
