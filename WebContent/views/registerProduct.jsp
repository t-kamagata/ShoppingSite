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
	<section class="hero is-primary is-fullheight">
        <div class="hero-body">
          <div class="container">
            <div class="columns is-centered">
              <div class="column is-5-tablet is-4-desktop is-3-widescreen">
                <h1>商品登録</h1>
                <form name="registerForm" method="POST" action="../controller/create-product" class="box">
                  <div class="field">
                    <label for="" class="label">商品名</label>
                    <div class="control has-icons-left">
                      <input name="name" type="text" placeholder="商品名" class="input" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-envelope"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <label for="" class="label">値段</label>
                    <div class="control has-icons-left">
                      <input id="price" name="price" type="text" placeholder="値段" class="input" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-lock"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <label for="" class="label">数量</label>
                    <div class="control has-icons-left">
                      <input id="quantity" name="stock" type="text" placeholder="数量" class="input" required>
                      <span class="icon is-small is-left">
                        <i class="fa fa-lock"></i>
                      </span>
                    </div>
                  </div>
                  <div class="field">
                    <button onclick="MyConfirm()" type="button" class="button is-success">
                      登録
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
    </section>
    <script>
	    let priceInput = document.querySelector("#price");
	    let qunatityInput = document.querySelector("#quantity");
	    
	    function MyConfirm() {
			let isYes = confirm("登録しますか？");
			if(isYes) {
				if(!isFinite(priceInput.value) || priceInput.value.trim() === "") {
					alert("値段に数値を入力してください。");
				} else if(!isFinite(qunatityInput.value) || qunatityInput.value.trim() === ""){
					alert("数量に数値を入力してください。");
				} else {
					document.registerForm.submit();
				}
			}
		}
    </script>
</body>
</html>