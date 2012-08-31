package jp.itacademy.samples.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PreparingBooksListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent e) {

        List<Book> books = new ArrayList<>();

        Author akutagawa = new Author("ó¥îVâÓ", "äHêÏ");
        Author dazai = new Author("é°", "ëæç…");

        books.add(new Book("óÖê∂ñÂ", akutagawa, 800, 3));
        books.add(new Book("íwÂÅÇÃéÖ", akutagawa, 500, 5));
        books.add(new Book("êlä‘é∏äi", dazai, 1000, 0));

        ServletContext context = e.getServletContext();
        context.setAttribute("books", books);
    }

    public void contextDestroyed(ServletContextEvent e) {
        ServletContext context = e.getServletContext();
        context.removeAttribute("books");
    }
}
