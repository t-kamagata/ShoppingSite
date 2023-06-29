<%@page import="jp.co.aforce.model.User"%>
<%@page import="jp.co.aforce.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" href="../css/bulma.css">
<style>
        
</style>
</head>
<body>
	<header>
		<nav class="level mt-5 is-mobile">
			<p class="level-item has-text-centered">
				<a class="link is-info" href="../controller/show-cart"> <img
					src="../img/cart.png" alt="" style="height: 70px;">
				</a>
			</p>
			<p class="level-item has-text-centered">
				<a class="link is-info" href="../views/login.jsp"> <img
					src="../img/member.png" alt="" style="height: 70px;">
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
	<%
	List<Product> products = (List<Product>) request.getAttribute("products");
	%>
	<div class="container mt-3">
		<div>
			<div
				class="columns is-vcentered has-text-centered mt-4 has-background-light"
				style="height: 5rem; background-color: orange; border-radius: 6px;">
				<div class="column is-one-third"></div>
				<form method="POST">
					<div>
						<input name="key" class="input is-inline" type="text" size="30">
						<input class="button" type="submit"
							formaction="../controller/search" value="検索">
					</div>
					<div>
						<select class="select" name="sort">
							<option value="name">商品名順</option>
							<option value="price">価格順</option>
						</select> <select class="select" name="order">
							<option value="asc">昇順</option>
							<option value="desc">降順</option>
						</select> <input class="button" type="submit"
							formaction="../controller/sort" value="並べ替え">
					</div>
				</form>
			</div>

			<div class="level" style="margin: 0 6rem;">
				<%
				User user = (User) session.getAttribute("user");
				%>
				<%
				int localId = 0;
				%>
				<%
				for (Product product : products) {
				%>
				<div class="level-item mt-3">
					<div class="card">
						<div class="card-image has-text-centered">
							<figure class="image is-128x128 is-inline-block">
								<img src="<%=product.getImg_path()%>" alt=""
									style="height: 128px;">
							</figure>
						</div>
						<div class="card-content">
							<div class="content">
								<%=product.getName()%>
								<%
								localId++;
								%>
								<p class="has-text-centered"><%=product.getPrice()%>円
								</p>
								<form name="a<%=localId%>" action="../controller/add-cart"
									method="POST">
									<input type="hidden" name="userId" value="<%=user.getId()%>">
									<input type="hidden" name="productId"
										value="<%=product.getId()%>"> 
									<select name="quantity">
										<%
										for (int i = 1; i <= product.getStock(); i++) {
										%>
										<option value="<%=i%>"><%=i%></option>
										<%
										}
										%>
									</select>
									<button>カートに追加</button>
								 </form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<footer class="footer mt-4">
		<div class="level">
			<div class="level-left">
				<p class="level-item has-text-centered">
					<img src="https://bulma.io/images/bulma-type.png" alt=""
						style="height: 30px;">
				</p>
			</div>

			<div class="level-item">©2023 TK Games.</div>
			<div class="level-right">
				<p class="level-item has-text-centered">
					<a href="#"> <img src="../img/top.png" alt=""
						style="height: 64px;">
					</a>
				</p>
			</div>
		</div>
	</footer>
</body>
</html>