<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/my" prefix="my" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:stock symbol="USDTWD=x" />
        </h1>
        <h1>
            <my:stock symbol="2330.TW" />
        </h1>
            <my:stock2>
                2330.TW,USDTWD=x,TWDJPY=x
            </my:stock2>
    </body>
</html>
