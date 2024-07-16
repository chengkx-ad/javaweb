package com.tomcat;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CatServlet implements Servlet {
    int count = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("CatServlet 被调用了");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            System.out.println("catServlet 调用GET");
        }else if ("POST".equals(method)){
            System.out.println("catServlet 调用POST");
        }
        System.out.println("第" + count + "次调用");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
