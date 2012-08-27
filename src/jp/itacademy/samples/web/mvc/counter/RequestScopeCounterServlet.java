package jp.itacademy.samples.web.mvc.counter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/requestCounter")
public class RequestScopeCounterServlet extends HttpServlet {

    private static final String COUNTER_KEY = "counter";

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Counter counter = (Counter) req.getAttribute(COUNTER_KEY);

        if (counter == null) {
            counter = new Counter();
            req.setAttribute(COUNTER_KEY, counter);
        }
        counter.inc();

        req.getRequestDispatcher("/WEB-INF/mvc/counter/request.jsp").forward(req, res);
    }
}
