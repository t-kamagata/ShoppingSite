<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>完了</title>
<link rel="stylesheet" href="../css/bulma.css">
</head>
<body>
	<section class="hero is-primary is-fullheight">
        <div class="hero-body">
          <div class="container">
            <div class="columns is-centered">
              <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                <div class="box has-text-centered">
                  <h1 class="has-text-centered">${ message }</h1>
                  <img class="is-64x64 is-block" src="../img/complete.jpg" alt="">
                  <a class="button has-text-centered is-inline-block" href="list-user">戻る</a>
              </div>
            </div>
          </div>
        </div>
    </section>
</body>
</html>