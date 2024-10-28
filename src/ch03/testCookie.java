package ch03;



import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class testCookie extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("ch02/login.html");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo2......");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("a")&&password.equals("1")){
//            更新cookie而不是完全新建
//            Cookie cookie = new Cookie("username","a");
//            resp.addCookie(cookie);
            HttpSession session = req.getSession();
            session.setAttribute("username","a");
            resp.sendRedirect("success.jsp");
//            resp.sendRedirect("success");
        }
        else{
            //resp.sendRedirect("login.html");
        //这里跳转的是相对提交表单的路径
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
