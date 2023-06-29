<%@page import="jp.co.aforce.model.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>注文一覧</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
<% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
    <div class="columns has-text-centered is-vcentered is-centered" style="height: 100vh">
        <!--   <div class="column is-one-third"></div> -->
        <div class="has-background-link column is-half mt-3 box">
            <table class="is-inline-block table">
                <tr>
                    <th>注文ID</th>
                    <th>注文者</th>
                    <th>配送状況</th>
                </tr>
                <% for(Order order : orders) { %>
                <tr>
                	<td><%= order.getId() %></td>
                	<td><%= order.getUserName() %></td>
                	<td><%= order.isShipping() ? "配達済み" : "未配達" %></td>
                </tr>
                <% } %>
            </table>
            <div>
            	<a href="admin-home" class="button is-primary">戻る</a>
            </div>
        </div>
    </div>
</body>
</html>