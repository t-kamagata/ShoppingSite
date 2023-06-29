function MyConfirm(text) {
	let isYes = confirm(text);
	
	if(isYes) {
		document.registerForm.submit();
	}
}