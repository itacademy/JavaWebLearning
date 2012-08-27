<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>Web住所録</title>
<style>
* {
  margin: 0;
  padding: 0;
}
p.error {
  margin: 10px;
}
fieldset {
  margin: 10px;
  padding: 5px;
  border: solid 1px #999;
}
fieldset p {
  padding: 2px 0;
}
#search-form fieldset input[name="keyword"] {
  margin: 0 5px;
}
#contact-list {
  margin: 30px 10px 10px;
  border-collapse: collapse;
}
#contact-list th {
  padding: 4px 8px;
  border: solid 1px #999;
}
#contact-list td {
  padding: 4px 8px;
  border: solid 1px #999;
}
</style>

<c:if test="${empty contacts}">
<p class="error">一件もみつかりませんでした。</p>
</c:if>

<form id="add-form" action="${pageContext.request.contextPath}/mvc/cl/add">
  <fieldset>
    <legend>新規登録</legend>
    <p>名前: <input type="text" name="name"></p>
    <p>電話番号: <input type="text" name="tel"></p>
    <p>メールアドレス: <input type="text" name="email"></p>
    <p><input type="submit" value="登録"></p>
  </fieldset>
</form>

<form id="search-form" action="${pageContext.request.contextPath}/mvc/cl/search">
  <fieldset>
    <legend>検索</legend>
    <p>名前に<input type="text" name="keyword">を含む</p>
    <p><input type="submit" value="絞込み"></p>
  </fieldset>
</form>

<c:if test="${not empty contacts}">

<table id="contact-list">
  <tr>
    <th>名前</th>
    <th>電話番号</th>
    <th>メールアドレス</th>
    <th></th>
  </tr>
<c:forEach var="contact" items="${contacts}">
  <tr>
    <td>${contact.name}</td>
    <td>${contact.tel}</td>
    <td>${contact.email}</td>
    <td>
      <form action="${pageContext.request.contextPath}/mvc/cl/remove">
        <input type="hidden" name="name" value="${contact.name}">
        <input type="submit" value="削除">
      </form>
    </td>
  </tr>
</c:forEach>
</table>
</c:if>

