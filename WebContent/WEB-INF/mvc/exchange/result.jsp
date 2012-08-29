<%@page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>

<meta charset="utf-8">
<title>両替計算サイト</title>
<style>.amount { font-size: 2em; padding: 0 .5em; }</style>

<p>${param.amount} 円　＝　<span class="amount">${targetAmount}</span> ${param.currency}</p>
