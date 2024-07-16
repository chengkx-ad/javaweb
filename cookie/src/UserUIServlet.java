import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserUIServlet", value = "/UserUIServlet")
public class UserUIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        Cookie newUsername =  cookieUtils
                .readCookieByName("newUsername", cookies);
        String username = "";
        if (newUsername != null){
            username = newUsername.getValue();
        }

        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>用户登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>登录系统</h1>\n" +
                "<form action=\"/cookie/login\" method=\"post\">\n" +
                "    用户名:<input type=\"text\" value=\"" + username + "\" name=\"username\"><br/>\n" +
                "    密　码:<input type=\"password\" name=\"pwd\"><br/>\n" +
                "    <input type=\"submit\" value=\"登录\"> <input type=\"reset\" value=\"重新填写\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        // value=\"" + username + "\"
        writer.flush();
        writer.close();
    }
}