package jp.itacademy.samples.web.wiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/wiz/step2")
public class Step2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        User user = new User();

        req.setCharacterEncoding("utf-8");
        user.setHandle(req.getParameter("handle"));

        HttpSession sess = req.getSession();
        sess.setAttribute("user", user);

        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<form action='step3' method='POST'>");
        out.println("<p>Ç®ñºëO: <input type='text' name='name'></p>");
        out.println("<p>èZèä: <input type='text' name='address'></p>");
        out.println("<input type='submit' value='éüÇ÷'>");
        out.println("</form>");
    }
}
