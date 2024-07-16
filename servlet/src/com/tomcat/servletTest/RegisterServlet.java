package com.tomcat.servletTest;

// 获取请求头的各个数据以及表单数据
// 将数据回显  注意中文的编码方式

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String AgentStr = request.getHeader("User-Agent");
        // 正则表达式获取括号内的部分
        String regStr = "\\((.*)\\)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(AgentStr);
        matcher.find();
        String group = matcher.group(1);
        System.out.println(group);
//        boolean b = matcher.find(0);
//        String group = matcher.group(0);
//        System.out.println(group);
    }
}