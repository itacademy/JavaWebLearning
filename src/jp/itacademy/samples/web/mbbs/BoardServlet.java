package jp.itacademy.samples.web.mbbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mbbs/board")
public class BoardServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        forward("/WEB-INF/mbbs/board.jsp", req, res);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String body = req.getParameter("body");
        if (body == null || body.equals("")) {
            req.setAttribute("error", "���b�Z�[�W����͂��Ă�������");
            forward("/WEB-INF/mbbs/error.jsp", req, res);
            return;
        }

        User user = (User) req.getSession().getAttribute("user");

        ServletContext context = getServletContext();
        List<Message> messages =
            (List<Message>) context.getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
            context.setAttribute("messages", messages);
        }

        Message msg = new Message(user.getHandle(), body, new Date());
        messages.add(msg);
        
        seeOther("/mbbs/board", req, res);
    }

}
