// LogoutProc
document.getElementById("SignoutBtn").onclick = function() {
	alert("로그아웃 성공");
	$.ajax({
		async: true
		, cache: false
		, type: "post"
		/* ,dataType:"json" */
		, url: "/xdm/v1/infra/baMember/baMemberXdmSignoutProc"
		/* ,data : $("#formLogin").serialize() */
		, success: function(response) {
			if (response.rt == "success") {
				location.href = "/xdm/v1/infra/baMember/baMemberXdmSignin";
			} else {
				// by pass
			}
		}
	});
}
