<%@page import="jp.co.aforce.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>購入確認</title>
<link rel="stylesheet" href="../css/bulma.css">
<style>
   .auto {
       margin: auto;
   }
   a.has-text-primary:hover {
            color: #00d1b2;
   }
</style>
</head>
<body>
	<header>
        <nav class="level mt-5 is-mobile">
            <p class="level-item has-text-centered">
                <a class="link is-info" href="controller/show-cart">
                    <img src="../img/cart.png" alt="" style="height: 70px;">
                </a>
            </p>
            <p class="level-item has-text-centered">
                <a class="link is-info" id="user">
                    <img src="../img/member.png" alt="" style="height: 70px;">
                </a>
            </p>
            <h1 class="title" style="height: 30px;"><a class="has-text-primary" href="../index.jsp">TK Games.</a></h1>
            <p class="level-item has-text-centered">
                <a href="views/login.jsp" class="link is-size-4">ログイン</a>
            </p>
            <p class="level-item has-text-centered">
                <a href="views/signup.jsp" class="link is-size-4">新規登録</a>
            </p>
        </nav>
    </header>
    <hr>
	<% List<Cart> items = (List<Cart>) session.getAttribute("items"); %>
    <div class="columns">
        <div class="column is-one-quarter"></div>
        <div class="column is-one-half">
            <table class="table mt-3 auto">
                <tr>
                    <th>商品名</th>
                    <th>値段</th>
                    <th>数量</th>
                    <th>小計</th>
                    <th>合計</th>
                </tr>
                <% int sum = 0; %>
                <% for(Cart item : items) { %>
                <tr>
                	<td><%= item.getName() %></td>
                	<td><%= item.getPrice() %></td>
                	<td><%= item.getQuantity() %></td>
                	<% sum += item.getPrice() * item.getQuantity(); %>
                	<td><%= item.getPrice() * item.getQuantity() %>円</td>
                	<td></td>
                </tr>
                <% } %>
                <tr>
                    <td colspan="4"></td>
                    <td><%= sum %>円<td>
                </tr>
            </table>
            <form name="purchaseForm" action="../controller/purchase" class="has-text-centered">
                <button class="button is-primary" type="button" onclick="MyConfirm()">購入</button>
            </form>
        </div>
        <div class="column is-one-quarter"></div>
    </div>
    <footer class="footer mt-4">
        <div class="level">
            <div class="level-left">
                <p class="level-item has-text-centered">
                    <img src="https://bulma.io/images/bulma-type.png" alt="" style="height: 30px;">
                </p>
            </div>

            <div class="level-item">
                ©2023 TK Games.
            </div>
            <div class="level-right">
                <p class="level-item has-text-centered">
                    <a href="#">
                        <img src="../img/top.png" alt="" style="height: 64px;">
                    </a>
                </p>
            </div>
        </div>
    </footer>
    <script>
		function MyConfirm() {
			let isYes = confirm("購入しますか？");
			if(isYes) {
					document.purchaseForm.submit();
				}
		}
    </script>
</body>
</html>