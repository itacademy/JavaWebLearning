<%@page contentType="text/html; charset=utf-8" %>
<%@page import="jp.itacademy.samples.web.mvc.counter.Counter" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>カウンター</title>

<% Counter counter = (Counter)application.getAttribute("counter"); %>
<p>訪問回数： <%= counter.getNum() %> 回</p>
