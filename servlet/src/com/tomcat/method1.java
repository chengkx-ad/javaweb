package com.tomcat;

/*
* 方法一: 计算访问orderServlet1和payServlet的次数
* */
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;



public class method1 {
    public static Integer writermd(ServletContext context){
        Object visit_count = context.getAttribute("visit_count");
        if (visit_count == null) {
            context.setAttribute("visit_count", 1);
            visit_count = 1;
        }else {
            visit_count = Integer.parseInt(visit_count + "") + 1;
            context.setAttribute("visit_count", visit_count);
        }

        return Integer.parseInt(visit_count + "");
    }
}
