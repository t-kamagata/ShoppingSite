<%@page import="jp.co.aforce.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>削除確認</title>
<link rel="stylesheet" href="../css/bulma.css">
<style>
   .auto {
       margin: auto;
   }
</style>
</head>
<body>
	<% Product product = (Product) request.getAttribute("product"); %>
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="column is-one-third">
            <table class="table mt-3 auto">
                <tr>
                    <th>商品名</th>
                    <td><%= product.getName() %></td>
                </tr>
                <tr>
                    <th>値段</th>
                    <td><%= product.getPrice() %></td>
                </tr>
                <tr>
                    <th>在庫</th>
                    <td><%= product.getStock() %><td>
                </tr>
            </table>
            <form name="deleteForm" method="POST" action="../controller/delete-product" class="has-text-centered">
            	<input type="hidden" value="<%= product.getId() %>" name="id">
                <button type="button" onclick="MyConfirm()">削除</button>
            </form>
        </div>
        <div class="column is-one-third"></div>
    </div>
    <script>
		function MyConfirm() {
			let isYes = confirm("削除しますか？");
			if(isYes) {
					document.deleteForm.submit();
				}
		}
    </script>
</body>
</html>