<%@page import="jp.co.aforce.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
	<header>
        <nav class="level mt-5 is-mobile">
            <p class="level-item has-text-centered">
                <a class="link is-info" href="login.html">
                    <img src="../img/cart.png" alt="" style="height: 70px;">
                </a>
            </p>
            <p class="level-item has-text-centered">
                <a class="link is-info" id="user">
                    <img src="../img/member.png" alt="" style="height: 70px;">
                </a>
            </p>
            <p class="level-item has-text-centered">
                <img src="https://bulma.io/images/bulma-type.png" alt="" style="height: 30px;">
            </p>
            <p class="level-item has-text-centered">
                <a href="views/login.jsp" class="link is-size-4">ログイン</a>
            </p>
            <p class="level-item has-text-centered">
                <a class="link is-size-4">新規登録</a>
            </p>
        </nav>
    </header>
	<div id="app">
		
	  <% List<Product> products = (List<Product>) request.getAttribute("products"); %>
	  
	  
      <div class="container column is-10">
        <div class="section">
		  <% for(Product product : products) { %>
		  	<div class="card">
            <div class="card-header">
              <p class="card-header-title"><%= product.getName() %></p>
            </div>
            <div class="card-conten columns is-vcentered">
              <div class="content column is-one-third">
              	<span class="is-inline-block ml-3 mt-3">値段：<%= product.getPrice() %></span>
              	<span class="is-inline-block ml-3">数量：<%= product.getStock() %></span>
              </div>
              <div class="column is-one-third"></div>
              <div class="column is-one-third">
              	<button class="is-inline-block">更新</button>
              	<button class="is-inline-block">削除</button>
              </div>
            </div>
          </div>
          <br />
          <% } %>
        </div>
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
                        <img src="../img/top.png" alt="" style="height: 64px;">
                    </a>
                </p>
            </div>
        </div>
    </footer>
</body>
</html>