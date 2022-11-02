package week10.session.servlet;

import week10.session.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/week10/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = (User)request.getSession().getAttribute("user");
        String username = user != null ? user.username : request.getParameter("username");
        String password = user != null ? user.password : request.getParameter("password");
        if ("root".equals(username) && "admin".equals(password)) {
            user = new User();
            user.username = username;
            user.password = password;
            request.getSession().setAttribute("user", user);
            response.sendRedirect("indexServlet");
        }
        else {
            response.getWriter().write("请检查用户名或密码!");
            Cookie cookie = new Cookie("id", null); //重置cookie
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.setHeader("refresh", "2;url=login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
