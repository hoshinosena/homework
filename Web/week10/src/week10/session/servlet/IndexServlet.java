package week10.session.servlet;

import week10.session.user.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet", value = "/week10/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user == null || !user.username.equals("root")) //抵御伪造cookie的重放攻击
            response.getWriter().write("请<a href='login.jsp'>点击此处</a>登录");
        else {
            PrintWriter out = response.getWriter();
            out.write("<body>");
            out.write(user.username + ",欢迎回来!<br /><br />");
            out.write("您可以<a href='logoutServlet'>单机此处</a>退出");
            out.write("</body>");
            Cookie cookie = new Cookie("id", user.id);
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
