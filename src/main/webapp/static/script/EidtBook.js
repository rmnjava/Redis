/**
 * 
 */
window.onload = function() {
	$(function() {
		// 页面加载完毕以后就会执行. manager_flag
		$(".delete").click(function() {
			var flag = window.confirm("确定要删除吗?");
			if (!flag) {
				// 取消超链接的默认行为
				return false;
			}
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			// 取消超链接的默认行为
			return false;
		});
	});

}
