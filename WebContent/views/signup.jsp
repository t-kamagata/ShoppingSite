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
    <section class="hero is-primary is-fullheight">
        <div class="hero-body">
            <div class="container">
                <div class="columns is-centered">
                    <div class="column is-5-tablet is-5-desktop is-5-widescreen">
                        <h1>新規登録</h1>
                        <form name="userForm" method="POST" action="../controller/create" class="box">
                            <div class="columns row-one">
                                <div class="column">
                                    <label class="label" for="firstName">姓</label>
                                    <div class="control">
                                        <input id="last_name" class="input" type="text" placeholder="姓" name="last_name" />
                                    </div>
                                </div>
                                <div class="column">
                                    <label class="label" for="lastName">名前</label>
                                    <div class="control">
                                        <input id="first_name" class="input" type="text" placeholder="名前" name="first_name" />
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <label for="" class="label">メールアドレス</label>
                                <div class="control has-icons-left">
                                    <input id="mail" name="mail_address" type="email" placeholder="メールアドレス" class="input" required>
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label for="" class="label">パスワード</label>
                                <div class="control has-icons-left">
                                    <input id="password" name="password" type="password" placeholder="*******" class="input" required>
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-lock"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <label for="" class="label">支払い方法</label>
                                <div class="select">
                                    <select id="payment" name="payment">
                                        <option value="" disabled selected style="display:none;">選択してください</option>
                                        <option value="カード支払い">カード支払い</option>
                                        <option value="代金引換">代金引換</option>
                                        <option value="コンビニ支払い">コンビニ支払い</option>
                                    </select>
                                </div>
                            </div>
                            <div class="field">
                                <label for="" class="label">住所</label>
                                <div class="control has-icons-left">
                                    <input id="address" name="address" type="text" placeholder="住所" class="input" required>
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="field">
                                <div class="mt-3">
                                    <label for="" class="label">生年月日</label>
                                    <div class="select">
                                        <select id="year" name="birth_year">
                                            <option value="" disabled selected style="display:none;">年</option>
                                            <% for(int i = 1920; i <= 2020; i++) { %>
												<option value="<%= i %>"><%= i %></option>
											<% } %>
                                        </select>
                                    </div>
                                </div>
                                <div class="mt-3">
                                    <!-- <label for="" class="label">　　　</label> -->
                                    <div class="select">
                                        <select id="month" name="birth_month">
                                            <option value="" disabled selected style="display:none;">月</option>
                                            <% for(int i = 1; i <= 12; i++) { %>
												<option value="<%= i %>"><%= i %></option>
											<% } %>
                                        </select>
                                    </div>
                                </div>
                                <div class="mt-3">
                                    
                                    <div class="select">
                                        <select id="day" name="birth_day">
                                            <option value="" disabled selected style="display:none;">日</option>
                                            <% for(int i = 1; i <= 31; i++) { %>
												<option value="<%= i %>"><%= i %></option>
											<% } %>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <label for="" class="label">電話番号</label>
                                <div class="control has-icons-left">
                                    <input id="phone" name="phone_number" type="text" placeholder="電話番号" class="input" required>
                                    <span class="icon is-small is-left">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                </div>
                            </div>
                            
                            <div class="field">
                                <button type="button" onclick="MyConfirm()" class="button is-success">
                                    登録
                                </button>
                            </div>
                        </form>
                        <script>
	                        let phoneInput = document.querySelector("#phone");
							let year = document.querySelector("#year");
							let month = document.querySelector("#month");
							let day = document.querySelector("#day");
							let payment =  document.querySelector("#payment");
							let mail = document.querySelector("#mail");

	                        function MyConfirm() {
	                        	if(!isFinite(phoneInput.value) || phoneInput.value.trim() === "") {
	                        		alert("電話番号に数値を入力してください。");
	                        	} else if(year.value === "" || month.value === "" || day.value === ""){
	                        		alert("生年月日を選択してください。");
	                        	} else if(payment.value === "") {
		                        	alert("支払い方法を選択してください。");
	                        	} else if(!mail.value.includes("@") || mail.value === "") {
		                        	alert("正しいメールアドレスを入力してください。")
	                        	} else {
	                        		document.userForm.submit();
		                        }
	                        }
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>