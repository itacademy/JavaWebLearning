package jp.itacademy.samples.web.mvc.week;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mvc/week")
public class WeekServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int year, month, date;
        try {
            year = Integer.parseInt(req.getParameter("year"));
            month = Integer.parseInt(req.getParameter("month")) - 1;
            date = Integer.parseInt(req.getParameter("date"));
        } catch (Exception e) {
            req.setAttribute("error", "îNåéì˙Çê≥ÇµÇ≠ì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢");
            forward("/WEB-INF/mvc/week/error.jsp", req, res);
            return;
        }

        DayOfWeek dow = new DayOfWeek(year, month, date);
        req.setAttribute("dow", dow);
        forward("/WEB-INF/mvc/week/result.jsp", req, res);

    }

    private void forward(String url, HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, res);
    }
}
