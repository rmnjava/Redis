/**
 * 
 */
window.onload = function() {
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var email = document.getElementById("email");
	var tel = document.getElementById("tel");
	var btn = document.getElementById("btn");
	btn.onmouseout = function() {
//		var xhr;
//		alert(btn);
//		var jBtn = $(btn);
//		alert(jBtn);
//		var jBtn1 = $("#btn");// jQuery id选择器获取
//		alert(jBtn1);
//		var jBtn2 = jBtn1[0];
//		alert(jBtn2); 
	}  
	username.onblur = function () {
		var username = $("#	").val();
		$.ajax({
			url : "Register",
			type : "POST",
			data : "username=" + username,
			success : function(data) {
				$("#regsiter").html(data);
			}
		});
	}
	
	username.onfocus = function() {
		var span = document.getElementById("regsiter");
		span.innerHTML = "";
	} 
};