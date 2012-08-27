package jp.itacademy.samples.web.mvc.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/mvc/shop/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            req.setAttribute("error", "商品が一件もカートにはいっていません");
            req.getRequestDispatcher("/WEB-INF/mvc/shop/error.jsp").forward(req, res);
            return;
        }

        req.getRequestDispatcher("/WEB-INF/mvc/shop/cart.jsp").forward(req, res);
    }

}
