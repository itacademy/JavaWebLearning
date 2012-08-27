<%@page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>BMI計算サイト</title>
<style>.bmi { font-size: 2em; padding: 0 .5em; }</style>

<%
    double weight, height;
    try {
        weight = Double.parseDouble(request.getParameter("weight"));
        height = Double.parseDouble(request.getParameter("height"));
    } catch (Exception e) {
        out.println("<p>パラメータが正しくありません</p>");
        return;
    }
    double bmi = weight / Math.pow(height / 100, 2);
%>

<p>あなたのBMIは<span class="bmi"><%= bmi %></span>です。</p>