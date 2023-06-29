<%@page import="java.util.Objects"%>
<%@page import="jp.co.aforce.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TK Games.</title>
<link rel="stylesheet" href="css/bulma.css">
<style>
        a.has-text-primary:hover {
            color: #00d1b2;
        }
</style>
</head>
<body>
	<% User user = (User) session.getAttribute("user"); %>
	<div class="modal" id="modal">
        <div class="modal-background"></div>
        <div class="modal-content">
            <div class="modal-card">
                <section class="modal-card-body">
                	<% if(Objects.nonNull(user)) { %>
                    <div>ようこそ、${ user.last_name }さん</div>
                    <a class="button" href="controller/logout">ログアウト</a>
                    <button class="button">変更</button>
                    <button class="button">削除</button>
                    <% } else { %>
                    <a class="button" href="views/login.jsp">ログインはこちら<a/>
                    <% } %>
                </section>
                <footer class="modal-card-foot">
                    <button class="button is-danger" id="cancel">Cancel</button>
                </footer>
            </div>
        </div>
    </div>
    <header>
        <nav class="level mt-5 is-mobile">
            <p class="level-item has-text-centered">
                <a class="link is-info" href="controller/show-cart">
                    <img src="img/cart.png" alt="" style="height: 70px;">
                </a>
            </p>
            <p class="level-item has-text-centered">
                <a class="link is-info" id="user">
                    <img src="img/member.png" alt="" style="height: 70px;">
                </a>
            </p>
            <h1 class="level-item title" style="height: 30px;"><a class="has-text-primary">TK Games.</a></h1>
            <p class="level-item has-text-centered">
                <a href="views/login.jsp" class="link is-size-4">ログイン</a>
            </p>
            <p class="level-item has-text-centered">
                <a href="views/signup.jsp" class="link is-size-4">新規登録</a>
            </p>
        </nav>
    </header>

    <div class="container mt-3">
        <div >
            <div class="columns is-vcentered has-text-centered mt-4 has-background-danger" style="height: 5rem; background-color: orange; border-radius: 6px;">
                <p class="has-text-white column is-size-3 has-text-weight-medium">新着タイトル</p>
                <div><a href="controller/list-user" class="button mr-2">もっと見る</a></div>
            </div>
            <div class="level" style="margin: 0 6rem;">
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/minecraft.jpg" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                マインクラフト
                                <p class="has-text-centered">
                                    4,500円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/sf6.jpg" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                ストリートファイター6
                                <p class="has-text-centered">
                                    8,600円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/bio.jpg" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                バイオハザード4:Re
                                <p class="has-text-centered">
                                    8,500円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="level mt-4" style="margin: 0 6rem;">
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/dragon.jpg" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                龍が如く極
                                <p class="has-text-centered">
                                    8,500円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered mx-3">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/kirby.jpg" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                カービィ
                                <p class="has-text-centered">
                                    7,500円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="level-item">
                    <div class="card">
                        <div class="card-image has-text-centered">
                            <figure class="image is-128x128 is-inline-block">
                                <img src="img/auto.png" alt="" style="height: 128px;">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                GRID autosport
                                <p class="has-text-centered">
                                    1,200円
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="columns is-vcentered has-text-centered mt-4" style="height: 5rem; background-color: orange; border-radius: 6px;">
                <p class="has-text-white column is-size-3 has-text-weight-medium">セールタイトル</p>
            </div>
            <div >
                <div class="level" style="margin: 0 6rem;">
                    <div class="level-item">
                        <div class="card">
                            <div class="card-image has-text-centered">
                                <figure class="image is-128x128 is-inline-block">
                                    <img src="img/zelda.jpg" alt="" style="height: 128px;">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="content">
                                    ゼルダの伝説<br>トワイライトプリンセス
                                    <p class="has-text-centered">
                                        <s class="" style="text-decoration-style: double; text-decoration-color: red;">6,500</s><br>
                                        4,500円
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="level-item">
                        <div class="card">
                            <div class="card-image has-text-centered">
                                <figure class="image is-128x128 is-inline-block">
                                    <img src="img/sonic.jpg" alt="" style="height: 128px;">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="content">
                                    ソニックアドベンチャー２
                                    <p class="has-text-centered">
                                        <s class="" style="text-decoration-style: double; text-decoration-color: red;">7,500</s><br>
                                        4,500円
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="level-item">
                        <div class="card">
                            <div class="card-image has-text-centered">
                                <figure class="image is-128x128 is-inline-block">
                                    <img src="img/pokemon.jpg" alt="" style="height: 128px;">
                                </figure>
                            </div>
                            <div class="card-content">
                                <div class="content">
                                    ポケットモンスターY
                                    <p class="has-text-centered">
                                        <s class="" style="text-decoration-style: double; text-decoration-color: red;">5,500</s><br>
                                        3,500円
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
        </div>
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
                        <img src="img/top.png" alt="" style="height: 64px;">
                    </a>
                </p>
            </div>
        </div>
    </footer>
    <script src="js/toggleModal.js"></script>
</body>
</html>