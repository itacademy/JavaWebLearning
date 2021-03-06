<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.List" %>
<%@page import="jp.itacademy.samples.web.mvc.bbs.Message" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>簡易掲示板</title>
<style>
#board {
  width: 600px;
  margin: 10px auto;
  padding: 10px;
}
.message {
  padding: 10px 0;
}
.message .meta {
  border-top: dashed 1px #999;
  border-bottom: solid 1px #999;
  background-color: #f5f5f5;
  padding: 10px 5px;
  font-family: monospace;
  text-align: right;
}
.message .body {
  padding: 5px;
}
form p {
  margin: 0;
  padding: 2px 0;
}
</style>

<div id="board">

<% List<Message> messages = (List<Message>) application.getAttribute("messages"); %>
<% if (messages == null || messages.isEmpty()) { %>
<p>まだ書き込みはありません。</p>
<% } else { %>
<% for (Message msg : messages) { %>
  <div class="message">
    <p class="body"><%= msg.getBody() %></p>
    <p class="meta">
      by <span class="poster"><%= msg.getPoster() %></span>
      at <span class="posted-at"><%= msg.getPostedAt() %></span>
    </p>
  </div>
<% } %>
<% } %>

<form action="<%= request.getContextPath() %>/mvc/bbs" method="POST">
  <p>名前: <input type="text" name="poster"></p>
  <p><textarea name="body" rows="5" cols="50"></textarea></p>
  <p><input type="submit" value="投稿"></p>
</form>

</div>
