package jp.itacademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/uranai")
public class UranaiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>血液型占いサイト</title>");
		out.println("<style>.result { font-size: 1.2em; }</style>");

		String bloodType = req.getParameter("bloodType");
		if (bloodType == null) {
			out.println("<p>血液型を選択してください。</p>");
			return;
		}

		out.print("<p class=\"result\">");
		switch (bloodType) {
		case "A":
			out.print("だいきちー");
			break;
		case "B":
			out.print("ちょうだいきちー");
			break;
		case "O":
			out.print("まあまあー");
			break;
		case "AB":
			out.print("だいきょうー　がーん！");
			break;
		default:
			out.print("そんな血液型ないですからー");
			break;
		}
		out.println("</p>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

}
