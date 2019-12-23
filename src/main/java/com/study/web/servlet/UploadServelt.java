package com.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 15,
        location = "C:/temp"
)
public class UploadServelt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter out = resp.getWriter();
        req.getParts().stream()
                .filter(part -> part.getName().equals("uploadfile"))
                .forEach(part -> {
                    try {
                        part.write(part.getSubmittedFileName());
                        out.println(part.getSubmittedFileName() + " upload OK");
                    } catch (Exception e) {
                        out.println("upload Error");
                    }
                });

        req.getParts().stream()
                .filter(part -> part.getName().equals("desc"))
                .forEach(part -> {
                    try {
                        String data = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
                        out.println(data);
                    } catch (IOException ex) {
                    }
                });

    }

}
