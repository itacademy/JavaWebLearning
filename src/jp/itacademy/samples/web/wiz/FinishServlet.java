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
            out.println("<p>�X�e�b�v1����J�n���Ă�������</p>");
            return;
        }

        String agree = req.getParameter("agree");
        if (!"y".equals(agree)) {
            out.println("<p>�K��ɓ��ӂ��Ă�������</p>");
            return;
        }

        out.println("<p>���肪�Ƃ��������܂��B</p>");
        out.println("<p>�ȉ��̂Ƃ��胆�[�U�o�^���s���܂����B</p>");
        out.println("<ul>");
        out.println("<li>�n���h���l�[��: " + user.getHandle() + "</li>");
        out.println("<li>�����O: " + user.getName() + "</li>");
        out.println("<li>�Z��: " + user.getAddress() + "</li>");
        out.println("</ul>");
    }

}
