function postUser (username, email, password) {
	const Http = new XMLHttpRequest();
	const url='https://www.example.com/api/user';
	const userBody = {
		"username": username,
		"email": email,
		"password": password
	};

    Http.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
        }
    };

    Http.open('POST', url);
    Http.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    Http.send(JSON.stringify(userBody));
	
	Http.onreadystatechange = (e) => {
		console.log(Http.responseText)
		return Http.responseText;
	}
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

	registerBtn.addEventListener("click", () => {
		let validUser = postUser(
			document.getElementById("namename-field").value,
			document.getElementById("email-field").value,
			document.getElementById("password-field").value
		)
		if (validUser) {
			window.location.href = "../homepage/homepage.html"
		} else {
			document.getElementById("alertError").innerHTML = "Username and/or password does not match";
		}
		return false;
	});

})(jQuery);
