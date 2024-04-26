signoutButton.addEventListener("click", () => {
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("userId");
    window.location.href="../login-page/Login.html";
});
