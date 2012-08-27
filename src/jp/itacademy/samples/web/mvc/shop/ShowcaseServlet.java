package jp.itacademy.samples.web.mvc.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mvc/shop/")
public class ShowcaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        super.init();

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "‚â‚­‚»‚¤", 8));
        items.add(new Item(2, "‚Ç‚­‚¯‚µ‚»‚¤", 10));
        items.add(new Item(3, "‚¹‚¢‚·‚¢", 20));
        items.add(new Item(4, "‚Ü‚ñ‚°‚Â‚»‚¤", 30));
        items.add(new Item(5, "Ž­‚¹‚ñ‚×‚¢", 4980000));

        ServletContext context = getServletContext();
        context.setAttribute("items", items);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/mvc/shop/showcase.jsp").forward(req, res);
    }
}
