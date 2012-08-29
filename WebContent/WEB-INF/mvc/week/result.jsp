<%@page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>曜日算出サイト</title>
<style>.dow { font-size: 2em; padding: 0 .5em; }</style>

<p>${param.year}年${param.month}月${param.date}日は<span class="dow">${dow.dayOfWeek}曜日</span>です。</p>
