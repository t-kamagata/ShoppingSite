let modal = document.querySelector("#modal");
let userButton = document.querySelector("#user");
let cancelButton = document.querySelector("#cancel");
userButton.addEventListener("click", () => {
		modal.classList.add("is-active");
});
cancelButton.addEventListener("click", () => {
	modal.classList.remove("is-active");
})