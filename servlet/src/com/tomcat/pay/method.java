package com.tomcat.pay;

// 输入金额的合理

public class method {

    public static int parseInt(String string) {

        int num = 0;

        try {
            num = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            // 不要把异常扔给tomcat   自己处理 输出一个格式不正确  tomcat不会再出现500状态码
            System.out.println("格式不正确");
        }
        return num;
    }
}
