import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "redirectServlet", value = "/redirectServlet")
public class redirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        * 注意：重定向路径按下面的方式写
        * ContextPath + "/views/user.html"
        * 直接写/views/user.html也可以（默认使用浏览器当前地址栏的路径）但是推荐按上面说的方法写
        * 不要用views/user.html
        * */
        // 请求转发的方式  定位到user.html
        System.out.println("请求转发成功~~");
        // 前后端数据调试的时候注意缓存的问题
//        request.getRequestDispatcher("/views/user.html").forward(request, response);

        // 重定向方式定位user.html
        String contextPath = getServletContext().getContextPath();
        response.sendRedirect(contextPath + "/views/user.html");
        System.out.println("重定向成功");
    }
}