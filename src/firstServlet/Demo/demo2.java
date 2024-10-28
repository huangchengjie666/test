package firstServlet.Demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ch02/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo2......");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("a")&&password.equals("1")){
            resp.sendRedirect("ch02/success.html");
        }
        else
            resp.sendRedirect("ch02/login.html");
        //这里跳转的是相对提交表单的路径
    }
}
