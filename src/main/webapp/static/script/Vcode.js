/**
 * 
 */
window.onload = function() {
	var t = 120;// 设定倒计时的时间
	var interval;
	function refer() {
		$("#countdown").text("请于" + t + "秒内填写验证码 "); // 显示倒计时
		t--; // 计数器递减
		if (t <= 0) {
			clearInterval(interval);
			$("#countdown").text("验证码已失效，请重新发送！ ");
		}
	}

	$(function() {
		$("#sendCode").click(
				function() {
					$.post("/Redis/CodeSenderServlet", $("#codeform")
							.serialize(), function(data) {
						if (data == "true") {
							t = 120;
							clearInterval(interval);
							interval = setInterval("refer()", 1000);// 启动1秒定时
						} else if (data == "limit") {
							clearInterval(interval);
							$("#countdown").text("单日发送超过次数！ ")
						}
					});
				});

		$("#verifyCode").click(
				function() {
					$.post("/Redis/CodeVerifyServlet", $("#codeform")
							.serialize(), function(data) {
						if (data == "true") {
							$("#result").attr("color", "green");
							$("#result").text("验证成功");
							clearInterval(interval);
							$("#countdown").text("")
						} else {
							$("#result").attr("color", "red");
							$("#result").text("验证失败");
						}
					});
				});

	});
}
