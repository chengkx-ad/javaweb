import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cookie", value = "/cookie")
public class cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=utf-8");
        Cookie cookie1 = new Cookie("username", "ckx");
        Cookie cookie2 = new Cookie("pwd", "123");
        // 将创建的cookie给浏览器保存
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        // 读取cookie

        PrintWriter writer = response.getWriter();
        writer.print("cookie保存成功！");
        writer.flush();
        writer.close();
    }
}