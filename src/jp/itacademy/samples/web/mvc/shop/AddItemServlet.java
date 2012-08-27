package jp.itacademy.samples.web.mvc.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/mvc/shop/addItem")
public class AddItemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            // ignore;
        }

        Item item = getItemById(id);
        if (item == null) {
            req.setAttribute("error", "è§ïiIDÇ™ê≥ÇµÇ≠Ç†ÇËÇ‹ÇπÇÒ");
            req.getRequestDispatcher("/WEB-INF/mvc/shop/error.jsp").forward(req, res);
            return;
        }

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(item);

        req.getRequestDispatcher("/mvc/shop/cart").forward(req, res);
    }

    @SuppressWarnings("unchecked")
    private Item getItemById(int id) {
        ServletContext context = getServletContext();
        List<Item> items = (List<Item>) context.getAttribute("items");
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
