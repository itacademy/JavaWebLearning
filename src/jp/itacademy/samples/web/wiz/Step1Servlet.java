package jp.itacademy.samples.web.wiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wiz/step1")
public class Step1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<form action='step2' method='POST'>");
        out.println("<p>ハンドルネーム: <input type='text' name='handle'></p>");
        out.println("<input type='submit' value='次へ'>");
        out.println("</form>");
    }
}
