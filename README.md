# javaweb
javaweb基础内容代码汇总
**HTML**（HyperText Mark-up Language）即超文本标签语言

不需要编译  直接由浏览器执行

**css**

**javascript**

**dom**



Tomcat

**一、浏览器如何访问web资源**

**二、配置tomcat   启动  关闭  调用**

**三、servlet**

**1、导入setvlet的jar包**

**2、在tomcat中配置servlet**
   <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.tomcat.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/helloServlet</url-pattern>
    </servlet-mapping>
    3、实现servlet类**

```java
package com.tomcat;

import javax.servlet.*;
import java.io.IOException;

// 开发一个servlet  需要实现servlet类
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init() 被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 处理浏览器的请求（包括get/post）
        // 当浏览器每请求一次，就会调用service方法
        // 当tomcat调用该方法时，会把http请求的数据封装成(实现了ServletRequest的) 对象
        //servletRequest对象，得到用户数据
        // servletResponse对象  用于给tomcat返回数据
        System.out.println("hi servlet");
    }

    // 返回servlet信息
    @Override
    public java.lang.String getServletInfo() {
        return null;
    }
    // 销毁servlet时调用只有一次
    @Override
    public void destroy() {

    }
}
```

**4、服务器请求servlet流程**

servlet是单例的   常驻内存

**5、servlet生命周期**

初始化init()：

**Servlet** 容器(比如: Tomcat)加载 Servlet，加载完成后，Servlet容器会创建一个 **Servlet** **实例**

并调用init()方法，init()方法只会调用一次**, **Servlet **容器在下面的情况装载** Servlet：

1. Servlet 容器(Tomcat)启动时自动装载某些 servlet，实现这个需要在 web.xml 文件中添加

  ```XML
<load-on-startup>1</load-on-startup>   <!--1 表示装载的顺序-->
  ```

2. 在 Servlet 容器启动后，浏览器首次向 Servlet 发送请求(这个前面说过)

3. Servlet 重新装载时(比如 tomcat 进行 redeploy【redeploy 会销毁所有的 Servlet 实例】)，
   浏览器再向 Servlet 发送请求的第 1 次

处理器请求阶段（service）

1. 每收到一个 http 请求，服务器就会产生一个新的线程去处理[线程]
2. 创建一个用于封装 HTTP 请求消息的 ServletRequest 对象和一个代表 HTTP 响应消息的
   ServletResponse 对象
3. 然后调用 Servlet 的 service()方法并将请求和响应对象作为参数传递进去

销毁阶段

当web 应用被终止，或者Servlet 容器终止运行，或者Servlet 类重新装载时，会调用 destroy()
方法
, 比如重启 tomcat ,或者 redeploy web 应用

**6、GET和POST的分发处理**

doget  dopost

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<h1>注册用户</h1>
<form action="http://localhost:8090/servlet/helloServlet"
      method="post">  // method
    u: <input type="text" name="username"/><br><br>
    <input type="submit" value="注册用户"/>
</form>
</body>
</html>
```

```java
// 通过servletRequest的子接口HttpServletRequest，方法getMethod，获取POST
// servletRequest下没有对应的查看哪个方法的函数  所以转成子接口
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
```

**7、通过继承httpservlet实现setvlet**

httpServlet中已经实现了所有需要的方法

只需要重写doGet 和 doPost 即可

```java
public class HiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");

    }
```

通过idea创建servlet   （注释方式）

```java
@WebServlet(name = "CcServlet", value = "/CcServlet")
public class CcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost");
    }
```

**8、servlet注解**



**9、WEB开发通信协议-Http协议**

(1)http请求头

(2)http响应头

(3)http状态码

(4)http页面请求次数分析

资源越多，请求次数越多   （在浏览器分析）

(5)GET请求头

```http
GET /servlet/pig2?username=ccc&username=123 HTTP/1.1  
Host: localhost:8090   // 主机【域名+端口】
Connection: keep-alive    // 表示长连接（保持连接状态）
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36
// 带上浏览器的版本号是因为tomcat会根据不同的浏览器版本作出不同的response    有的tomcat不支持某个版本的浏览器
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9  // 默认解析格式  首先按text/html的格式进行解析
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8090/servlet/login.html   // 这个请求是哪里来的（有的浏览器会检测域名  不是自己域名的  打回去  防盗链）
Accept-Encoding: gzip, deflate, br   // 接受什么格式的压缩类型
Accept-Language: zh-CN,zh;q=0.9  // 支持接收的语言
```

（6）哪些是GET请求  哪些是POST请求  怎么分辨

安全性：GET>POST  

数据量：POST>GET

（7）http响应码分析

```http
HTTP/1.1 200 OK    // 响应行
// 响应头
Server: Apache-Coyote/1.1
Date: Wed, 26 Jun 2024 07:21:07 GMT
Accept-Ranges: bytes
ETag: W/"839-1719366433350"
Last-Modified: Wed, 26 Jun 2024 01:47:13 GMT
Content-Type: text/html
Content-Length: 839
```

**10、servletConfig**  

写servlet类----进行信息配置  本身也是一个类

tomcat创建servlet时，会同时创建一个servletconfig

**11、servletContext**(接口)

实现该接口的对象：1、可以被多个servlett共享  2、存储形式key-value，类似于哈希map 3、可以实现多个servlet的通讯 4、数据在内存中

一个web工程    只能有一个servletContext 对象实例

**servletContext的作用：**获取web.xml中配置的上下文参数**context-param**、获取当前工程的路径、获取工程部署 后在服务器硬盘上的绝对路径、像map一样存取数据，多个servlet共享数据

**12、httpservletRequest**

接受中文参数的乱码问题

```java
request.setCharacterEncoding("utf-8");  默认编码方式：URLEncoding
```

**13、请求转发**

发出http请求后，**tomcat**先调用servlet01，然后得到数据后，**tomcat**再调用servlet02，再次处理，最后才返回http响应。

**1. 浏览器地址不会变化(地址会保留在第 1 个 servlet 的 url)****

**2. 在同一次 HTTP 请求中，进行多次转发，仍然是一次 HTTP 请求**

**3. 在同一次 HTTP 请求中，进行多次转发，多个 Servlet 可以共享 request 域/对象的数据(因**

**为始终是同一个 request 对象)**

**4. 可以转发到 WEB-INF 目录下    tomcat会拒绝返回web-inf下的资源  使用请求转发可以到web-inf下的资源****

**5. 不能访问当前 WEB 工程外的资源**

**6.因为浏览器地址栏会停止在第一个 servlet ,如果你刷新页面，会再次发出请求(并且会**

**带数据), 所以在支付页面情况下，不要使用请求转发，否则会造成重复支付[演示]**（重定向、将数据写到数据库中）

**14、请求重定向**

重定向后，会再次发出http请求

地址也会发生变化

应用场景：网站迁移  网站域名变化

**15、WEB工程路径专题**

“/”在web工程中的含义：

如果被浏览器解析，/会被解析成http://localhost:8080/

如果被服务器解析，/会被解析为http://localhost:8080/工程名/

编写资源路径时，路径前面有没有/    路径在那里被解析

**16、开发会话技术cookie和session**

**Cookie**(小甜饼)是客户端技术，服务器把每个用户的数据以 cookie 的形式写给用户各自的浏览器。当用户使用浏览器再去访问服务器中的 web 资源时，就会带着各自的数据去。这样，web 资源处理的就是用户各自的数据了。

cookie数据是保存在浏览器的（这些数据有：用户名，浏览历史等等，这些数据并不大，当服务器端需要的时候，按照http协议传输）

```http
Cookie=JSESSIONID=BBCA533EDE42155D2E3FE67E7ADDC077
如果有多个浏览器创建了会话，服务器依靠上面的JESSIONID来分辨哪个cookie是哪个会话的
```

cookie生命周期

setMaxAge()  设置的时间到了以后，浏览器再发出请求时，就不再携带该cookie信息，但是这个cookie还在浏览器里能看到（因为浏览器还没关闭）

cookie有效路径

cookie1的/path为  /工程路径

cookie2的/path为 /工程路径/aaa



如果资源的路径为http://localhost:8080/工程路径/资源

那么1会被发送   2不会

如果资源的路径为http://localhost:8080/工程路径/aaa/资源

那么1和2都会被发送

1. 一个 Cookie 只能标识一种信息，它至少含有一个标识该信息的名称（NAME）和设置值
   （VALUE）。
2. 一个 WEB 站点可以给一个浏览器发送多个 Cookie，一个浏览器也可以存储多个 WEB 站
   点提供的 Cookie。
3. cookie 的总数量没有限制，但是每个域名的 COOKIE 数量和每个 COOKIE 的大小是有限
   制的 (不同的浏览器限制不同, 知道即可) , Cookie 不适合存放数据量大的信息。
4. 注意，删除 cookie 时，path 必须一致，否则不会删除
5. Java servlet 中 cookie 中文乱码解决

```java
String urlName = URLEncoder.encode("成凯璇", "utf-8");  // 中文编码

// 输出的时候  先对中文进行特定的解码
URLDecoder.decode(cookie.getValue(),"utf-8") + "] <br/>");
```

**session**

1、Session 是服务器端技术，服务器在运行时为每一个用户的浏览器创建一个其独享的
session 对象/集合

2、由于 session 为各个用户浏览器独享，所以用户在访问服务器的不同页面时，可以从各自
的 session 中读取/添加数据, 从而完成相应任务

**服务器端渲染技术
