package jp.itacademy.samples.web.mvc.cl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/cl/list")
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        ContactList list = (ContactList) session.getAttribute("list");
        List<Contact> contacts = null;
        if (list == null) {
            contacts = new ArrayList<>();
        } else {
            contacts = list.getContacts();
        }
        req.setAttribute("contacts", contacts);

        req.getRequestDispatcher("/WEB-INF/mvc/cl/list.jsp").forward(req, res);
    }

}
