package week9.session.servlet.ListCakeServlet;

import week9.session.cake.Cake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/week9/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Cake> cart = (List)request.getSession().getAttribute("cart");
        out.write("<body>");
        if (cart == null)
            out.write("抱歉，您尚未购买任何商品！<br />");
        else {
            out.write("您已购买如下蛋糕:<br />");
            for (Cake cake:cart)
                out.write(cake.getName() + "<br />");
        }
        out.write("<a href=listCake>点击返回购买页面</a></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
