let phoneInput = document.querySelector("#phone");

function MyConfirm() {
	if(!isFinite(phoneInput.value) || phoneInput.value.trim() === "") {
		alert("値段に数値を入力してください。");
	} else {
		document.userForm.submit();
	}
}