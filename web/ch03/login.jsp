
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <h1>欢迎登录</h1>
    <!--把表单信息传输到对应目录的URL上 -->
    <!--如果是login,则是在ch02上找login(ch02/login)找不到,但是我们实际配置的时候是javaWeb/login在xml中，这个时候就找到servlet中的dopost-->
    <!-- 第二种方案就直接login就可以了,在servlet中再把ch02/删掉-->
    <form action = "login"  method = "POST">
        用户名 : <input type="text"  name="username"/></br>
        密码    :<input type = "password"  name="password"/></br>
        <input type = "submit"  value = "登录"/>
    </form>
    <%
        String msg = (String)request.getAttribute("msg");
        if(msg!=null)
        {
            out.print("<font color = 'red'>"+msg+"</font>");
        }
    %>
</body>
</html>
