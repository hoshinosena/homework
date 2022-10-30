package week9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestLineServlet", value = "/week9/requestLine")
public class RequestLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("getMethod:" + request.getMethod() + "<br />");
        out.println("getRequestURI:" + request.getRequestURI() + "<br />");
        out.println("getQueryString:" + request.getQueryString() + "<br />");
        out.println("getProtocol:" + request.getProtocol() + "<br />");
        out.println("getContextPath:" + request.getContextPath() + "<br />");
        out.println("getPathInfo:" + request.getPathInfo() + "<br />");
        out.println("getPathTranslated:" + request.getPathTranslated() + "<br />");
        out.println("getServletPath:" + request.getServletPath() + "<br />");
        out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br />");
        out.println("getRemoteHost:" + request.getRemoteHost() + "<br />");
        out.println("getRemotePort:" + request.getRemotePort() + "<br />");
        out.println("getLocalAddr:" + request.getLocalAddr() + "<br />");
        out.println("getLocalName:" + request.getLocalName() + "<br />");
        out.println("getLocalPort:" + request.getLocalPort() + "<br />");
        out.println("getServerName:" + request.getServerName() + "<br />");
        out.println("getServerPort:" + request.getServerPort() + "<br />");
        out.println("getScheme:" + request.getScheme() + "<br />");
        out.println("getRequestUIL:" + request.getRequestURL() + "<br />");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
