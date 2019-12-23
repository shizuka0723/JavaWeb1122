package com.study.web.servlet.various;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/various/bmi")
public class BMIServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //設定文件編碼
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
    
        //取得表單資料
        String weight = req.getParameter("weight");
        String height = req.getParameter("height");
        String bmi = calcBMI(weight, height);
        
        //設定 out 物件
        PrintWriter out = resp.getWriter();
        out.print("BMI: "+bmi);
    }
    private String calcBMI(String weight,String height){
        double w,h,bmi;
        w = Double.valueOf(weight);
        h = Double.valueOf(height);
        bmi = w / Math.pow(h/100, 2);
        return String.format("%.2f", bmi);
    }
    
}
