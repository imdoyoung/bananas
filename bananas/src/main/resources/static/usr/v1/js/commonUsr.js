// 시터 로그아웃
document.getElementById("sitterSignOutBtn").onclick = function() {
	$.ajax({ 
		async: true
		, cache: false
		, type: "post"
		/* ,dataType:"json" */
		, url: "/usr/v1/infra/common/baSitterSignOutProc"
		/* ,data : $("#formLogin").serialize() */
		, success: function(response) {
			if (response.rt == "success") {
				location.href = "/usr/v1/infra/common/baSitterSignIn";
			} else {
				alert("로그아웃 실패");
			}
		}
	}); // ajax end
} // sitterSignOutBtn end

// 사용자 로그아웃 
document.getElementById("logoutBtn").onclick = function () {
         $.ajax({  
           async: true
           ,cache: false
           ,type: "post"
           /* ,dataType:"json" */
           ,url: "/usr/v1/infra/common/baUsrSignOutProc"
           /* ,data : $("#formLogin").serialize() */
           ,success: function(response) {
              if(response.rt == "success") {
                 location.href="/usr/v1/infra/common/baUsrSignIn";  
              } else {        
                 // by pass  
              }
             }      
            }); // ajax end
 } // logoutBtn end