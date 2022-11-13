<%--
  Created by IntelliJ IDEA.
  User: 18452
  Date: 2022/11/13
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查阅邮件</title>
</head>
<body>
<jsp:useBean id="email" class="week11.JavaBean.Email" />
<jsp:setProperty name="email" property="*" />
<%! public class CharacterEncoding {
    public String toString(String str) throws UnsupportedEncodingException {
        String text = "";
        if (str!=null && !"".equals(str)) {
            text = new String(str.getBytes("ISO-8859-1"),"UTF-8");
        }
        return text;
    }
} %>
<% CharacterEncoding encoding = new CharacterEncoding(); %>
<div align="center">
    <div id="container">
        <div id="title"><%= encoding.toString(email.getTitle()) %></div>
        <hr>
        <div id="content"><%= encoding.toString(email.getContent()) %></div>
    </div>
</div>
</body>
</html>
