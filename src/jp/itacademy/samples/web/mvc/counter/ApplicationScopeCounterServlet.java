package jp.itacademy.samples.web.mvc.counter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/applicationCounter")
public class ApplicationScopeCounterServlet extends HttpServlet {

    private static final String COUNTER_KEY = "counter";

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        Counter counter = (Counter) context.getAttribute(COUNTER_KEY);

        if (counter == null) {
            counter = new Counter();
            context.setAttribute(COUNTER_KEY, counter);
        }
        counter.inc();

        req.getRequestDispatcher("/WEB-INF/mvc/counter/application.jsp").forward(req, res);
    }
}
