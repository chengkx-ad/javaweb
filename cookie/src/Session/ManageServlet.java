package Session;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManageServlet", value = "/Manage")
public class ManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (username != null) {
            writer.write("<h1>用户管理界面</h1>");
            writer.write("<a>欢迎你，管理员</a>");
            writer.flush();
            writer.close();
        }else {
            response.sendRedirect("login.html");
        }
    }
}