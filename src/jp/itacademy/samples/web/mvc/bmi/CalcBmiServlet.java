package jp.itacademy.samples.web.mvc.bmi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mvc/calcBmi")
public class CalcBmiServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // リクエストパラメータの処理など、Web特有のロジックはサーブレットに書く
        double weight;
        double height;
        try {
            weight = Double.parseDouble(req.getParameter("weight"));
            height = Double.parseDouble(req.getParameter("height"));
        } catch (Exception e) {
            req.setAttribute("error", "パラメータが正しくありません");
            req.getRequestDispatcher("/WEB-INF/mvc/bmi/error.jsp").forward(req, res);
            return;
        }

        Person person = new Person(height, weight);
        req.setAttribute("person", person);

        req.getRequestDispatcher("/WEB-INF/mvc/bmi/result.jsp").forward(req, res);
    }
}
