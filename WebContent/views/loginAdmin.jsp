<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
	<%
		Boolean error = (Boolean) request.getAttribute("error");
	%>
	<section class="hero is-primary is-fullheight">
        <div class="hero-body">
          <div class="container">
            <div class="columns is-centered">
              <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                <h1>管理者ログイン</h1>
                <% if(Objects.nonNull(error) && error) { 
                	String message = (String) request.getAttribute("message");
                %>
					<h1 class="has-text-danger"><%= message %></h1>
				<% } %>
                <form action="../controller/login-admin" method="POST" class="box">
                  <div class="field">
                    <label for="" class="label">メールアドレス</label>
                    <div class="control has-icons-left">
                      <input type="email" name="mail_address" placeholder="メールアドレス" class="input"
                      	value="<%= (Objects.nonNull(error) && error) ? request.getAttribute("mail_address") : ""%>" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-envelope"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <label for="" class="label">パスワード</label>
                    <div class="control has-icons-left">
                      <input type="password" name="password" placeholder="*******" class="input" 
                      	value="<%= (Objects.nonNull(error) && error) ? request.getAttribute("password") : ""%>" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-lock"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <button class="button is-success">
                      ログイン
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
    </section>
</body>
</html>