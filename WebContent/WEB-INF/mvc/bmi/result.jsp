<%@page contentType="text/html; charset=utf-8" %>
<%@page import="jp.itacademy.samples.web.mvc.bmi.Person" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>BMI計算サイト</title>
<style>.bmi { font-size: 2em; padding: 0 .5em; }</style>

<% Person person = (Person) request.getAttribute("person"); %>
<p>あなたのBMIは<span class="bmi"><%= person.getBmi() %></span>です。</p>
