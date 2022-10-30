package week9.session.servlet.ListCakeServlet;

import week9.session.cake.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", value = "/week9/purchase")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            response.sendRedirect("listCake");
        else {
            HttpSession session = request.getSession();
            List<Cake> cart = (List)session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
            cart.add(CakeDB.getCake(id));
            Cookie cookie = new Cookie("sessionId", session.getId());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            response.sendRedirect("cart");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
