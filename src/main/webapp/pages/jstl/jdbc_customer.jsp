<%-- 
我要查詢客戶資料:
SELECT c.CUSTOMER_ID, c.DISCOUNT_CODE, c."NAME", c.PHONE, c.EMAIL, c.CREDIT_LIMIT FROM APP.CUSTOMER c
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="datasource.jspf" %>
<sql:query dataSource= "${mydb}" var ="customer">
    SELECT c.CUSTOMER_ID, c.DISCOUNT_CODE, c."NAME", c.PHONE, c.EMAIL, c.CREDIT_LIMIT FROM APP.CUSTOMER c
</sql:query>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <%@ include file="menu.jspf"%>
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr>
                    <th>#</th>
                    <th>CUSTOMER_ID</th>
                    <th>DISCOUNT_CODE</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>CREDIT_LIMIT</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customer.rows}" var="p" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${p.CUSTOMER_ID}</td>
                        <td>${p.DISCOUNT_CODE}</td>
                        <td>${p.NAME}</td>
                        <td>${p.PHONE}</td>
                        <td>${p.EMAIL}</td>
                        <td>${p.CREDIT_LIMIT}</td>
                    </tr>
                </c:forEach>
            </tbody>
    </body>
</html>
