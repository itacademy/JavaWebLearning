package jp.itacademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/simpleBbs")
public class SimpleBbsServlet extends HttpServlet {

    private List<String> messages = Collections
        .synchronizedList(new ArrayList<String>());

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        showMessages(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String msg = req.getParameter("message");
        if (msg != null) {
            msg = msg.trim();
            if (msg.length() != 0) {
                messages.add(msg);
            }
        }
        showMessages(req, res);
    }

    private void showMessages(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta charset=\"utf-8\">");
        out
            .println("<style>.msg { border-bottom: solid 1px #999; padding-bottom: 10px; }</style>");
        for (String msg : messages) {
            out.println("<p class=\"msg\">" + msg + "</p>");
        }

        String action = req.getContextPath() + "/simpleBbs";
        out.println("<form method='POST' action='" + action + "'>");
        out.println("<textarea name='message' cols='40' rows='3'></textarea>");
        out.println("<input type='submit' value='‘—M' />");
        out.println("</form>");
    }

}
