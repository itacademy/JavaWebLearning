package jp.itacademy.samples.web.mvc.bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/bbs")
public class BbsServlet extends HttpServlet {

    private static final String KEY = "messages";

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/mvc/bbs/bbs.jsp").forward(req, res);
    }

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String poster = req.getParameter("poster");
        if (poster == null || poster.equals("")) {
            poster = "名無しさん";
        }

        String body = req.getParameter("body");
        if (body == null || body.equals("")) {
            req.setAttribute("error", "メッセージを入力してください");
            req.getRequestDispatcher("/WEB-INF/mvc/bbs/error.jsp").forward(req, res);
            return;
        }

        ServletContext context = getServletContext();
        List<Message> messages = (List<Message>) context.getAttribute(KEY);
        if (messages == null) {
            messages = new ArrayList<>();
            context.setAttribute(KEY, messages);
        }

        Message msg = new Message(poster, body, new Date());
        messages.add(msg);

        doGet(req, res);
    }

}
