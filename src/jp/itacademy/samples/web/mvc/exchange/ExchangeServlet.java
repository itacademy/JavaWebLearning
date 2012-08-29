package jp.itacademy.samples.web.mvc.exchange;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mvc/exchange")
public class ExchangeServlet extends HttpServlet {

    private Exchanger exchanger;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        exchanger = new Exchanger();
        exchanger.addCurrency("USD", 78.53);
        exchanger.addCurrency("CNY", 12.35);
        exchanger.addCurrency("ZWD", 1d / 3_000_000);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int amount;
        String currency = req.getParameter("currency");
        try {
            amount = Integer.parseInt(req.getParameter("amount"));
        } catch (Exception e) {
            req.setAttribute("error", "ÉpÉâÉÅÅ[É^Ç™ê≥ÇµÇ≠Ç†ÇËÇ‹ÇπÇÒ");
            forward("/WEB-INF/mvc/exchange/error.jsp", req, res);
            return;
        }
        
        double targetAmount = exchanger.getTargetAmount(amount, currency);
        req.setAttribute("targetAmount", targetAmount);

        forward("/WEB-INF/mvc/exchange/result.jsp", req, res);
    }

    private void forward(String url, HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, res);
    }
}
