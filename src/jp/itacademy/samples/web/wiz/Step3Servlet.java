package jp.itacademy.samples.web.wiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/wiz/step3")
public class Step3Servlet extends HttpServlet {

    @Override
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
        req.setCharacterEncoding("utf-8");
        user.setName(req.getParameter("name"));
        user.setAddress(req.getParameter("address"));

        out.println("<form action='finish' method='POST'>");
        out.println("<p>���p�K��F�@�v����ɉ��������Ă����Ȃ��̐ӔC�ł��B</p>");
        out.println("<p>��̋K���");
        out.println("<input id='agree_y' type='radio' name='agree' value='y'>");
        out.println("<label for='agree_y'>���ӂ���</label>");
        out.println("<input id='agree_n' type='radio' name='agree' value='n'>");
        out.println("<label for='agree_n'>���ӂ��Ȃ�</label>");
        out.println("</p>");
        out.println("<input type='submit' value='�o�^'>");
        out.println("</form>");
    }
}
