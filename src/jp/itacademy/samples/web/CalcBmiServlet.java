package jp.itacademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/calcBmi")
public class CalcBmiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>BMI計算サイト</title>");
		out.println("<style>.bmi { font-size: 2em; padding: 0 .5em; }</style>");

		double weight, height;
		try {
			weight = Double.parseDouble(req.getParameter("weight"));
			height = Double.parseDouble(req.getParameter("height"));
		} catch (Exception e) {
			out.println("<p>パラメータが正しくありません</p>");
			return;
		}
		double bmi = weight / Math.pow(height / 100, 2);
		out.printf("<p>あなたのBMIは<span class=\"bmi\">%.2f</span>です。</p>", bmi);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

}
