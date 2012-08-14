package jp.itacademy.samples.web.wiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/wiz/finish")
public class FinishServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html; charset=utf-8");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta charset=\"utf-8\">");

        HttpSession sess = req.getSession(false);
        User user = null;
        if (sess == null || (user = (User) sess.getAttribute("user")) == null) {
            out.println("<p>ステップ1から開始してください</p>");
            return;
        }

        String agree = req.getParameter("agree");
        if (!"y".equals(agree)) {
            out.println("<p>規約に同意してください</p>");
            return;
        }

        out.println("<p>ありがとうございます。</p>");
        out.println("<p>以下のとおりユーザ登録を行いました。</p>");
        out.println("<ul>");
        out.println("<li>ハンドルネーム: " + user.getHandle() + "</li>");
        out.println("<li>お名前: " + user.getName() + "</li>");
        out.println("<li>住所: " + user.getAddress() + "</li>");
        out.println("</ul>");
    }

}
