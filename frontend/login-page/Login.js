async function loginUser (username, password) {
	const url= 'http://127.0.0.1:8080/auth/login';

    let body = JSON.stringify({
            email: username,
            password: password
        });

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: body
    })
    let obj = await response.json();
    return obj;
}
	

(function($) {

	"use strict";

	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

	$(".toggle-password").click(function() {

	  $(this).toggleClass("fa-eye fa-eye-slash");
	  var input = $($(this).attr("toggle"));
	  if (input.attr("type") == "password") {
	    input.attr("type", "text");
	  } else {
	    input.attr("type", "password");
	  }
	});



	signinBtn.addEventListener("click", async() => {
		let validUser = await loginUser(
			document.getElementById("username-field").value,
			document.getElementById("password-field").value
		)
		if (validUser.tokenType == "Bearer") {
            sessionStorage.setItem("token", validUser.accessToken);
            sessionStorage.setItem("userId", validUser.userId);
			window.location.href = "../homepage/homepage.html"
		} else {
			document.getElementById("alertError").innerHTML = "Username and/or password does not match";
		}
		return false;
	});

})(jQuery);
