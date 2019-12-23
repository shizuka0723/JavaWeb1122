package com.study.web.servlet.various;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/various/post")
public class PostServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //設定文件編碼
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        //抓取表單資料
        String id = req.getParameter("id");
        String exam = req.getParameter("exam");
        String[] slot = req.getParameterValues("slot");
        String pay = req.getParameter("pay");
        String note = req.getParameter("note");
        
        //設定 out 物件
        PrintWriter out = resp.getWriter();
        out.print(String.format("id = %s<br>exam = %s<br>時段 = %s<br>繳費狀況 = %s<br>備註 = %s<br>", id,exam,Arrays.toString(slot),pay,note));
    }
    
}
