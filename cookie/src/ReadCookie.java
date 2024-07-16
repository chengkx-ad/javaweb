import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadCookie", value = "/ReadCookie")
public class ReadCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie pwd = cookieUtils.readCookieByName("pwdx", cookies);

        if (pwd != null) {
            pwd.setValue("ckx-pwd");
            response.addCookie(pwd);
            System.out.println("已修改pwd的value，newvalue=" + pwd.getValue());
        }else {
            System.out.println("没有找到该cookie");
        }

        for (Cookie cookie : cookies) {
            System.out.println("name=" + cookie.getName() + "-" + "value=" + cookie.getValue());
        }

        PrintWriter writer = response.getWriter();
        writer.print("要查找的特定cookie已修改~");
        writer.flush();
        writer.close();
    }
}