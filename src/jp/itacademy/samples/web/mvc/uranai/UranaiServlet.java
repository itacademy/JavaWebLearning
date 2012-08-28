package jp.itacademy.samples.web.mvc.uranai;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mvc/uranai")
public class UranaiServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String bloodType = req.getParameter("bloodType");
        if (bloodType == null || bloodType.trim().length() == 0) {
            req.setAttribute("error", "ÉpÉâÉÅÅ[É^Ç™ê≥ÇµÇ≠Ç†ÇËÇ‹ÇπÇÒ");
            req.getRequestDispatcher("/mvc/uranai/error.jsp").forward(req, res);
        }
        
        Uranai uranai = new Uranai(bloodType);
        req.setAttribute("result", uranai.getResult());

        req.getRequestDispatcher("/WEB-INF/mvc/uranai/result.jsp").forward(req, res);
    }
}
