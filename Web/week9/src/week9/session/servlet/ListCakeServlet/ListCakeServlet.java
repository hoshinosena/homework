package week9.session.servlet.ListCakeServlet;

import week9.session.cake.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ListCakeServlet", value = "/week9/listCake")
public class ListCakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Cake> cakes = CakeDB.getAll();
        out.write("<body>");
        out.write("本站提供的蛋糕有:<br />");
        for (Cake cake:cakes) {
            int i;
            for (i=0; i<cakes.size(); i++)
                if (cake == CakeDB.getCake("" + i))
                    break;
            out.write(cake.getName() + "<a href=purchase?id=" + i + ">点击购买</a><br />");
        }
        out.write("<a href=cart>点击查看购物车</a></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
