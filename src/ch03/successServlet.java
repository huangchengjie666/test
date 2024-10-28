package ch03;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class successServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        boolean flag = false;
//        if(cookies!=null)
//        {
//            System.out.println("cookie非空");
//            for(int i = 0 ; i < cookies.length ; i++)
//            {
//                if(cookies[i].getName().equals("username")&&cookies[i].getValue().equals("a"))
//                {
//                    flag = true;
//                    break;
//                }
//            }
//        }
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username" + username);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if (username != null) {
            out.println("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>登陆成功</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>登陆成功!!!</h1>\n" +
                    "    <h2><a href=\"login.html\">点此登录</a></h2>\n" +
                    "</body>\n" +
                    "</html>");
        } else {
            out.println("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>登陆成功</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>你还没登录呢！</h1>\n" +
                    "    <h2><a href=\"login.html\">点此登录</a></h2>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("我在这");
//        Cookie[] cookies = req.getCookies();
//        boolean flag = false;
//        if(cookies!=null)
//        {
//            for(int i = 0 ; i < cookies.length ; i++)
//            {
//                if(cookies[i].getName().equals("username")&&cookies[i].getValue().equals("a"))
//                {
//                    flag = true;
//                    break;
//                }
//            }
//        }
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter out = resp.getWriter();
//        if(flag)
//        {
//            out.println("<html lang=\"en\">\n" +
//                    "<head>\n" +
//                    "    <meta charset=\"UTF-8\">\n" +
//                    "    <title>登陆成功</title>\n" +
//                    "</head>\n" +
//                    "<body>\n" +
//                    "    <h1>登陆成功!!!</h1>\n" +
//                    "    <h2><a href=\"login.html\">点此登录</a></h2>\n" +
//                    "</body>\n" +
//                    "</html>");
//        }
//        else
//        {
//            out.println("<html lang=\"en\">\n" +
//                    "<head>\n" +
//                    "    <meta charset=\"UTF-8\">\n" +
//                    "    <title>登陆成功</title>\n" +
//                    "</head>\n" +
//                    "<body>\n" +
//                    "    <h1>你还没登录呢！</h1>\n" +
//                    "    <h2><a href=\"login.html\">点此登录</a></h2>\n" +
//                    "</body>\n" +
//                    "</html>");
//        }
//    }
}
