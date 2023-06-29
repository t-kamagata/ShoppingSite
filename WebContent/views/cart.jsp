<%@page import="jp.co.aforce.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート画面</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
    <header>
        <nav class="level mt-5 is-mobile">
            <p class="level-item has-text-centered">
                <a class="link is-info" href="show-cart">
                    <img src="../img/cart.png" alt="" style="height: 70px;">
                </a>
            </p>
            <p class="level-item has-text-centered">
                <a class="link is-info" href="../views/login.jsp">
                    <img src="../img/member.png" alt="" style="height: 70px;">
                </a>
            </p>
            <h1 class="title" style="height: 30px;"><a class="has-text-primary" href="../index.jsp">TK Games.</a></h1>
            <p class="level-item has-text-centered">
                <a href="../views/login.jsp" class="link is-size-4">ログイン</a>
            </p>
            <p class="level-item has-text-centered">
                <a href="../views/signup.jsp" class="link is-size-4">新規登録</a>
            </p>
        </nav>
    </header>

    <div class="container mt-3">
      
          <section class="main-content columns is-fullheight">
      
      		<% List<Cart> items = (List<Cart>) session.getAttribute("items"); %>
      		
            <div class="container column is-10">
              <div class="section">
      		
      		<% for(Cart item : items) { %>
            <div class="card">
            <div class="card-header">
              <p class="card-header-title"><%=item.getName() %></p>
            </div>
            <div class="card-conten columns is-vcentered">
              <div class="content column is-one-third">
              	<span class="is-inline-block ml-3 mt-3">値段：<%= item.getPrice() %></span>
              	<span class="is-inline-block ml-3">数量：<%= item.getQuantity() %></span>
              	<span class="is-inline-block ml-3">小計：<%= item.getQuantity() * item.getPrice() %></span>
              </div>
              <div class="column is-one-third"></div>
              <div class="column is-one-third">
              	<a href="../controller/update-cart-valued?id=<%= item.getId() %>" class="button is-inline-block">更新</a>
              	<a href="../controller/delete-cart?id=<%= item.getId() %>" class="button is-inline-block">削除</a>
              </div>
            </div>
          </div>
          <br />
      		<% } %>
                
      
              </div>
              <a href="../views/purchaseConfirm.jsp" class="button is-primary column" style="margin: auto; width: 100px">確認</a>
            </div>
          </section>
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
                        <img src="image/top.png" alt="" style="height: 64px;">
                    </a>
                </p>
            </div>
        </div>
    </footer>
</body>
</html>