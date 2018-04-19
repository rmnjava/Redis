/**
 * 
 */
window.onload = function() {
	$("#miaosha_btn").click(
	   function() { 
			$.post("/Redis/doseckill", $("#codeform").serialize(), function(data) {
				if (data == "false") {
					alert("抢光了");
					$("#miaosha_btn").attr("disabled", true);
				}
			});
	   })
}
