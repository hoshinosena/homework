package week9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet", value = "/week9/lastAccess")
public class LastAccessServlet extends HttpServlet {
    protected void setCookies(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String data = new SimpleDateFormat("yyyy年MM月dd日" + "HH:mm:ss").format(new Date());
        System.out.println("编码前:" + data);
        data = URLEncoder.encode(data, "utf-8");
        System.out.println("编码后:" + data);
        Cookie cookie = new Cookie("lastTime", data);
        cookie.setMaxAge(-1); //关闭浏览器后自动失效
        response.addCookie(cookie);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            setCookies(request, response);
            response.getWriter().write("您好,欢迎首次访问");
        }
        else {
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("lastTime")) {
                    String value = cookie.getValue();
                    System.out.println("解码前:" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后:" + value);
                    response.getWriter().write("欢迎回来，您上次访问时间为:" + value);
                    break;
                }
                response.resetBuffer();
                response.getWriter().write("您好,欢迎首次访问");
            }
            setCookies(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
