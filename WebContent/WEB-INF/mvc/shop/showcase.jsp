<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>おみせ</title>
<style>
#showcase {
  width: 600px;
  margin: 10px auto;
  border-collapse: collapse;
}
#showcase th {
  padding: 5px 10px;
  border: solid 1px #999;
}
#showcase td {
  padding: 5px 10px;
  border: solid 1px #999;
}
#showcase td.price {
  text-align: right;
}
p.link {
  text-align: center;
}
</style>

<table id="showcase">
  <tr>
    <th>商品名</th>
    <th>価格</th>
    <th></th>
  </tr>
<c:forEach var="item" items="${items}">
  <tr>
    <td>${item.name}</td>
    <td class="price">${item.price} G</td>
    <td>
      <form action="${pageContext.request.contextPath}/mvc/shop/addItem">
        <input type="hidden" name="id" value="${item.id}">
        <input type="submit" value="カートに追加">
      </form>
    </td>
  </tr>
</c:forEach>
</table>

<p class="link">
  <a href="${pageContext.request.contextPath}/mvc/shop/cart">カートを見る</a>
</p>
