<%--
  Created by IntelliJ IDEA.
  User: 黄程杰
  Date: 2024/10/9
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功页面</title>
</head>
<body>
    <%
        String msg = (String)session.getAttribute("username");
        if(msg != null)
        {
            out.print("<h1>"+ msg+"登陆成功!!!</h1>");
        }
        else {
            out.print("    <h1>你还没登录呢！</h1>\n" +
                    "    <h2><a href=\"login.jsp\">点此登录</a></h2>\n");
        }
    %>
</body>
</html>
