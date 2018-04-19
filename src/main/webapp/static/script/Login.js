/**
 * jQuery的使用方法： 1. 2. 3. 4.
 */

window.onload = function() {
	var btn = document.getElementById("btnId");
	var loginBtn = document.getElementById("login");
	var username = document.getElementById("username");
	var password = document.getElementById("pwd");
	do {
		loginBtn.onclick = function() {
			if (username.value == "" || password.value == "") {
				alert("用户名或密码不为空:" + flag);
			} else {
				alert("请求成功");
			}
		}
	} while (false);
 
	
	
	
	
	
	
	
	
	
	
	
	
};
