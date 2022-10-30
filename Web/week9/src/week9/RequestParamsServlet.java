package week9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestParamsServlet", value = "/week9/requestParams")
public class RequestParamsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("用户名:" + request.getParameter("username"));
        System.out.println("密码:" + request.getParameter("password"));
        System.out.print("爱好:");
        String[] hobby = request.getParameterValues("hobby");
        for (int i=0; i<hobby.length; i++)
            System.out.print(hobby[i] + ' ');
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
