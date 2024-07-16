import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (("chengkaixuan".equals(username)) && ("123456".equals(pwd))) {
            Cookie cookie = new Cookie("newUsername", username);
            cookie.setMaxAge(259200);
            response.addCookie(cookie);

            writer.print("<h1>登录OK</h1>");
        }else {
            writer.print("<h1>登录失败</h1>");

        }
        writer.flush();
        writer.close();
    }
}