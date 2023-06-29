<%@page import="jp.co.aforce.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
  <div id="app">

    <nav class="nav has-shadow">
      <div class="container">
        <div class="nav-left">
        </div>
        <label for="menu-toggle" class="nav-toggle">
          <span></span>
          <span></span>
          <span></span>
        </label>
        <input type="checkbox" id="menu-toggle" class="is-hidden" />
        <div class="nav-right nav-menu">
          <a class="nav-item is-tab is-hidden-tablet">
            <span class="icon"><i class="fa fa-home"></i></span> 新規追加
          </a>
          <a class="nav-item is-tab is-hidden-tablet">
            <span class="icon"><i class="fa fa-table"></i></span> Links
          </a>
          <a class="nav-item is-tab is-hidden-tablet">
            <span class="icon"><i class="fa fa-info"></i></span> About
          </a>

          <a class="nav-item is-tab is-active">
            <span class="icon"><i class="fa fa-user"></i></span>
          </a>
          <a class="nav-item is-tab">
            <span class="icon"><i class="fa fa-sign-out"></i></span>
          </a>
        </div>
      </div>
    </nav>

    <section class="main-content columns is-fullheight">

      <aside class="column is-2 is-narrow-mobile is-fullheight section is-hidden-mobile">
        <p class="menu-label is-hidden-touch is-size-4">商品管理</p>
        <ul class="menu-list">
          <li>
            <a href="../views/registerProduct.jsp" class="button is-primary">
              <span class="icon"><i class="fa fa-home"></i></span> 新規追加
            </a>
          </li>
          <li class="mt-3">
            <a href="../controller/show-order" class="button is-primary">
              <span class="icon"><i class="fa fa-home"></i></span> 注文情報
            </a>
          </li>
        </ul>
      </aside>
		
	  <% List<Product> products = (List<Product>) session.getAttribute("products"); %>
	  
	  
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
              	<a href="../controller/update-valued?id=<%= product.getId() %>" class="button is-inline-block">更新</a>
              	<a href="../controller/delete-valued?id=<%= product.getId() %>" class="button is-inline-block">削除</a>
              </div>
            </div>
          </div>
          <br />
          <% } %>
          
        </div>
      </div>

    </section>

    <footer class="footer is-hidden">
      <div class="container">
        <div class="content has-text-centered">
          <p>Hello</p>
        </div>
      </div>
    </footer>

  </div>
</body>
</html>