package com.study.web.session;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/session/*")
public class AuthCodeFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("AuthCodeFilter");
        HttpSession session = req.getSession();
        String code = req.getParameter("code");
        String authCode = session.getAttribute("authCode") + "";
        Boolean authPass = Boolean.parseBoolean(session.getAttribute("authCode") + "");
        boolean pass = authPass || (code != null && code.equals(authCode)) ? true : false;

        System.out.println(code + ", " + authCode + ", " + pass);
        
        if(pass){
            session.setAttribute("authPass", true);
            chain.doFilter(req, res); //重導到下一頁
        }else{
            session.invalidate(); // session失效
            req.setAttribute("message", "認證碼不正確");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/session/login.jsp");
            rd.forward(req, res);
        }
    }

}
