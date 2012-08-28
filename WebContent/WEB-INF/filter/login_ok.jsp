<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="_header.jsp" %>

<p>ログインしました。ようこそ ${account} さん。</p>
<p><a href="${pageContext.request.contextPath}/filter/memberOnly/page1">ページ1へ</a></p>
<p><a href="${pageContext.request.contextPath}/filter/memberOnly/page2">ページ2へ</a></p>

<%@include file="_footer.jsp" %>
