<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>おみせ - カート内容</title>
<style>
form {
  text-align: right;
}
#cart {
  width: 600px;
  margin: 10px auto;
  border-collapse: collapse;
}
#cart th {
  padding: 5px 10px;
  border: solid 1px #999;
}
#cart td {
  padding: 5px 10px;
  border: solid 1px #999;
}
#cart td.price {
  text-align: right;
}
#cart td.quantity {
  text-align: right;
}
#cart td.amount {
  text-align: right;
}
#cart td.total-amount {
  text-align: right;
}
p.link {
  text-align: center;
}
</style>

<form action="${pageContext.request.contextPath}/mvc/shop/checkout">
  <input type="submit" value="購入する">
</form>

<table id="cart">
  <tr>
    <th>商品名</th>
    <th>単価</th>
    <th>個数</th>
    <th>小計</th>
  </tr>
<c:forEach var="item" items="${cart.items}">
  <tr>
    <td>${item.name}</td>
    <td class="price">${item.price} G</td>
    <td class="quantity">${item.quantity} 個</td>
    <td class="amount">${item.price * item.quantity} G</td>
  </tr>
</c:forEach>
  <tr>
    <td colspan="3">合計</td>
    <td class="total-amount">${cart.amount} G</td>
  </tr>
</table>

<p class="link">
  <a href="${pageContext.request.contextPath}/mvc/shop/">買い物を続ける</a>
</p>
