package jp.itacademy.samples.web.mvc.cl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/cl/add")
public class AddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        if (isBlank(name) || isBlank(tel) || isBlank(email)) {
            req.setAttribute("error", "名前・電話番号・メールアドレスを入力してください");
            req.getRequestDispatcher("/WEB-INF/mvc/cl/error.jsp").forward(req, res);
            return;
        }

        HttpSession session = req.getSession();
        ContactList list = (ContactList) session.getAttribute("list");
        if (list == null) {
            list = new ContactList();
            session.setAttribute("list", list);
        }
        list.add(new Contact(name, tel, email));
        
        req.getRequestDispatcher("/mvc/cl/list").forward(req, res);
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

}
