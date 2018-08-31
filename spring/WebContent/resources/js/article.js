

$(() => {

	var el = {
			form : $("#article"),
			articleForm : $("#articleForm"),
			idx : $("input[name='idx']"),
			userName : $("input[name='userName']"),
			password : $("input[name='password']"),
			re_password : $("input[name='re-password']"),
			title : $("input[name='title']"),
			content : $("textarea[name='content']"),
			isNew : $("input[name='isNew']"),
			modify_btn : $("input[name=btn-modify]"),
			delete_btn : $("input[name=btn-delete]"),
			cancel_btn : $("input[name=btn-cancel]"),
			submit_btn : $("input[name='btn-submit']")
	},
	
	btnEvent = () => {
		// 확인버튼 클릭 : 쓰기, 수정
		el.submit_btn.on('click', save);
		
		// 수정버튼 클릭
		el.modify_btn.on('click', checkPass);
		
		// 삭제버튼 클릭
		el.delete_btn.on('click', checkPass);
		
		// 취소버튼 클릭 : 리스트로 이동
		el.cancel_btn.on('click', () => {
			location.href= "/spring/articles";
		});
		
	},
	
	save = () => {
			
			if (el.userName.val().trim().length < 1) {
				alert("이름을 입력해주세요.");
				el.userName.focus();
				return;
			} else if (el.password.val().trim().length < 1) {
				alert("비밀번호를 입력해주세요.");
				el.password.focus();
				return;
			} else if (el.title.val().trim().length < 1){
				alert("제목을 입력해주세요.");
				el.title.focus();
				return;
			} else if (el.content.val().trim().length < 1){
				alert("내용을 입력해주세요.");
				el.content.focus();
				return;
			}
			
			var url = "/spring/article";
			
			$.ajax({
		        type : 'POST',
		        url : url,
		        data : el.articleForm.serialize(),
		        success : (result) => {
		            if(result > 0){
		            	alert("저장 성공");
		            	location.href = "/spring/articles";
		            } else {
		            	alert("저장 실패");
		            	location.href = "/spring/articles";
		            }      
		        }
		    });
	},	
	
	doDelete = () => {
		var url = "/spring/article/delete";

		$.ajax({
	        type : 'POST',
	        url : url,
	        data : el.form.serialize(),
	        success : (result) => {
	            if (result === false) {
	            	alert("삭제 실패");
	            	location.href = "/spring/articles";
	            } else {
	            	alert("삭제 성공");
	            	location.href = "/spring/articles";
	            }
	        }
	    });
	},
	
	checkPass = (e) => {

		if (el.re_password.val().trim().length < 1) {
			alert("비밀번호를 입력해주세요.");
			el.re_password.focus();
			return;
		}
		
		var data = {
				'idx' : el.idx.val(),
				'password' : el.re_password.val()
		}
		
		var url = "/spring/password";
		var whenSuccess = (e.target.name.trim() === "btn-modify") ? true : false;

		$.ajax({
	        type : 'GET',
	        url : url,
	        data : data,
	        success : (result) => {
	        	
	            if(result === false) {
	            	alert("비밀번호를 확인해주세요.");
	            	el.re_password.val("");
	            	el.re_password.focus();
	            } else {
	            	if (whenSuccess) {
	            		location.href = "/spring/article/save/" + el.idx.val();
	            	} else {
	            		doDelete();
	            	}
	            }
	        }
	    });
	}
	
	btnEvent();
});
