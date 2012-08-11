package jp.itacademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/showParameters")
public class ShowParametersServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>show parameters</title>");
		out.println("<ul>");
		out.println("<li>name=" + req.getParameter("name") + "</li>");
		out.println("<li>pass=" + req.getParameter("pass") + "</li>");
		out.println("<li>plan=" + req.getParameter("plan") + "</li>");
		out.println("<li>like=" + join(req.getParameterValues("like"))
				+ "</li>");
		out.println("<li>payment=" + req.getParameter("payment") + "</li>");
		out.println("<li>comment=" + req.getParameter("comment") + "</li>");
		out.println("<li>token=" + req.getParameter("token") + "</li>");
		out.println("</ul>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	private String join(String[] array) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			buf.append(array[i]).append(",");
		}
		buf.deleteCharAt(buf.length() - 1);
		return buf.toString();
	}

}
