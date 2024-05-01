async function registerUser (name, email, password) {
	const url='http://127.0.0.1:8080/auth/register';
	let body = JSON.stringify({
		name: name,
		email: email,
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

	registerBtn.addEventListener("click", async() => {
		let validUser = await registerUser(
			document.getElementById("namename-field").value,
			document.getElementById("email-field").value,
			document.getElementById("password-field").value
		)

		if (validUser.userId) {
			window.location.href = "../login-page/Login.html"
		} else {
			document.getElementById("alertError").innerHTML = "Username and/or password does not match";
		}
		return false;
	});

})(jQuery);
