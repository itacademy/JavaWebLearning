package jp.itacademy.samples.web.mvc.cl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/cl/remove")
public class RemoveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        if (name == null || name.trim().length() == 0) {
            req.setAttribute("error", "çÌèúÇ∑ÇÈòAóçêÊÇÃñºëOÇ™éwíËÇ≥ÇÍÇƒÇ¢Ç‹ÇπÇÒ");
            req.getRequestDispatcher("/WEB-INF/mvc/cl/error.jsp").forward(req, res);
            return;
        }

        HttpSession session = req.getSession();
        ContactList list = (ContactList) session.getAttribute("list");
        if (list == null) {
            list = new ContactList();
            session.setAttribute("list", list);
        }
        list.remove(name);
        
        req.getRequestDispatcher("/mvc/cl/list").forward(req, res);
    }

}
