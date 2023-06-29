<%@page import="jp.co.aforce.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
	<% Cart cart = (Cart) request.getAttribute("cart"); %>
	<section class="hero is-primary is-fullheight">
        <div class="hero-body">
          <div class="container">
            <div class="columns is-centered">
              <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                <h1>カート情報更新</h1>
                <form name="registerForm" method="POST" action="../controller/update-cart" class="box">
                  <input type="hidden" name="id" value="<%= cart.getId() %>">
                  
                  <div class="field">
                  	<h2><%= cart.getName() %></h2>
                  </div>
                  <div class="field">
                    <label for="" class="label">数量</label>
                    <div class="control has-icons-left">
                      <input id="quantity" value="<%= cart.getQuantity() %>" name="quantity" type="text" placeholder="数量" class="input" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-lock"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <button onclick="MyConfirm()" type="button" class="button is-success">
                      更新
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
    </section>
    <script>
	    let qunatityInput = document.querySelector("#quantity");
	    
	    function MyConfirm() {
			let isYes = confirm("更新しますか？");
			if(isYes) {
				if(!isFinite(qunatityInput.value) || qunatityInput.value.trim() === ""){
					alert("数量に数値を入力してください。");
				} else {
					document.registerForm.submit();
				}
			}
		}
    </script>
</body>
</html>