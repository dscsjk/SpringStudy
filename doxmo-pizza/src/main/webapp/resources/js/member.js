/**
 * 아이디 중복체크
 *
 * @param id
 * @return
 */
function idCheck(id) {
	if ($('#id').val() == ""){
		$("#id_alert").text("아이디를 입력해 주세요.");
		$('#id').focus();
	}

	if (!isValid($('#id').val())) {
		$("#idDupChk").val("N");
		$("#id").focus();
		return;
	}

	$.ajax({
		type: "POST",
		url: "/member/idChkAjax",
		data: { "id" : id.val()	},
		dataType : "json",
		success:function(data) {
			if(data.code >= 0){
				if(data.status == "success"){
					$("#id_alert").text("사용 가능한 아이디입니다.");
					$("#idDupChk").val(data.msg);
				}else{
					$("#id_alert").text("이미 사용중인 아이디입니다.\n다른 아이디를 입력해주세요.");
					$("#idDupChk").val("N");
				}
			}else{
				$("#id_alert").text("아이디는 8~16자의 영문/숫자만 가능하며 여백은 사용할 수 없습니다.");
				$("#idDupChk").val("N");
			}
		},
		error: function (error){
			alert('Error ==> ' + error);
		}
	});
}

/**
 * 아이디 유효성 체크
 *
 * @param id
 * @return
 */
function isValid(userid){

	if( userid.length < 8 || userid.length > 16){
		$("#id_alert").text("이용자ID의 길이는 8 ~ 16자 입니다.");
		return false;
	}

	if (('A' > userid.charAt(0)) || ('z' < userid.charAt(0)) ) {
		$("#id_alert").text("이용자ID의 첫글자는 영문자만 가능합니다.");
		return false;
	}

	for(k=0; k < userid.length; k++) {
			if( ('0' <= userid.charAt(k) &&
			'9' >= userid.charAt(k)) ||
			('A' <= userid.charAt(k) &&
			'Z' >= userid.charAt(k)) ||
			('a' <= userid.charAt(k) &&
			'z' >= userid.charAt(k)) ||
			(userid.charAt(k) == '_' && k > 0 && k < userid.length-1)){
		} else {
			$("#id_alert").text("이용자ID는 영문, 숫자, '_'만 가능합니다.");
			return false;
		}
	}
	return true;
}

/**
 * 비밀번호 유효성 체크
 *
 * @param passwd
 * @return
 */
function isValidPwd(passwd){

    var SamePass_0 = 0; //동일문자 카운트
    var SamePass_1 = 0; //연속성(+) 카운드
    var SamePass_2 = 0; //연속성(-) 카운드

    var chr_pass_0;
    var chr_pass_1;
    var chr_pass_2;

    var strValue = "qwertyuiop[]asdfghjkl;'zxcvbnm,./][POIUYTREWQ';LKJHGFDSA/.,MNBVCXZqazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLPPLOMKUZAQXSWCDEVFRBGTNHYMJUKILOP";


	if( passwd.length < 8 || passwd.length > 16){
		$("#passwd_alert").text("비밀번호의 길이는 8 ~ 16자 입니다.");
		return false;
	}

	//숫자 체크
	var nStr = "";
	for(k=0; k < passwd.length; k++) {
		if('0' <= passwd.charAt(k) && '9' >= passwd.charAt(k)){
			nStr += passwd.charAt(k);
		}
	}

	//영문 체크
	var eStr = "";
	for(k=0; k < passwd.length; k++) {
		if(('A' <= passwd.charAt(k) && 'Z' >= passwd.charAt(k))
			|| ('a' <= passwd.charAt(k) && 'z' >= passwd.charAt(k))){
			eStr += passwd.charAt(k);
		}
	}
	if(nStr == "" || eStr == ""){
		$("#passwd_alert").text("비밀번호는 영문/숫자 조합으로 가능합니다.");
		return false;
	}

	/*
    if(!passwd.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/))
    {
        alert("비밀번호는 문자, 숫자, 특수문자의 조합으로 입력해주세요.");
        return false;
    }
    */


    for(var i=0; i < passwd.length; i++)
    {
        chr_pass_0 = passwd.charAt(i);
        chr_pass_1 = passwd.charAt(i+1);

        //동일문자 카운트
        /*
        if(chr_pass_0 == chr_pass_1)
        {
            SamePass_0 = SamePass_0 + 1;
        }
        */

        chr_pass_2 = passwd.charAt(i+2);
        //연속성(+) 카운드

        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == 1)
        {
            SamePass_1 = SamePass_1 + 1;
        }

        //연속성(-) 카운드
        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == -1)
        {
            SamePass_2 = SamePass_2 + 1;
        }
    }
    if(SamePass_0 > 1)
    {
    	$("#passwd_alert").text("동일문자를 3번 이상 사용할 수 없습니다.");
        return false;
    }

    if(SamePass_1 >= 1 || SamePass_2 >= 1 )
    {
    	$("#passwd_alert").text("연속된 문자열(123 또는 321, abc, cba 등)을\n 3자 이상 사용 할 수 없습니다.");
        return false;
    }


	if (strValue.indexOf(passwd) >= 0) {
		$("#passwd_alert").text('키보드상에 나란히 있는 문자는 비밀번호로 사용하실 수 없습니다.');
		return false;
	}


	return true;
}


/**
 * 이메일 셀렉박스
 *
 * @param obj, obj2
 * @return
 */
function checkEmailState(obj, obj2) {
	if (obj.val() == "WRITE") {
		obj2.attr("readOnly", false);
		obj2.attr("disabled", false);
		obj2.val('');
		$('#email3').focus();
	} else {
		obj2.val(obj.val());
		obj2.attr("readOnly", true);
	}
}

/**
 * 인증번호 발송
 *
 * @param auth_type
 * @param email
 * @param hand_tel1
 * @param hand_tel2
 * @param hand_tel3
 * @return
 */
var memberAuthSendChk = false;
function memberAuthSend(auth_type, email, hand_tel1, hand_tel2, hand_tel3, gubun_type) {
	var errorTxt = "인증번호 발송 중 오류가 발생되었습니다. 다시 시도해주세요.";

	if(!memberAuthSendChk){
		memberAuthSendChk = true;
		$.ajax({
			type: "POST",
			url: "/member/authSendAjax",
			data: { "auth_type" : auth_type,
					"email" : email,
					"hand_tel1" : hand_tel1,
					"hand_tel2" : hand_tel2,
					"hand_tel3" : hand_tel3	 },
			dataType : "json",
			success:function(data) {
				if (data.status == "success") {
					$("#hdnAuthKey").val(data.msg);
					alert("인증번호가 발송되었습니다.\n인증번호 입력란에 수신된 인증번호를 입력해 주세요.");
				} else if (data.status == "hpError") {
					alert("전화번호 형태가 잘못 되었습니다.");
					if (gubun_type == "Y")
						showMemberInfo();
				} else if (data.status == "fail") {
					if (data.msg == "1min") {
						alert("인증번호 재발송은 발송 후 1분 후 가능합니다.");
					} else if (data.msg == "1day") {
						alert("인증번호 발송은 하루에 5회로 제한됩니다.");
					} else if (data.msg == "PCID ERROR") {
						alert("비정상적 접근입니다.");
					}

					if (gubun_type == "Y")
						showMemberInfo();
				} else if (data.status == "error") { // SMS 모듈 오류
					alert(errorTxt);
				} else {
					alert("입력하신 정보가 불충분합니다 확인바랍니다.");
					if (gubun_type == "Y")
						showMemberInfo();
				}
				memberAuthSendChk = false;
			},
			error: function (error){
				alert('Error ==> ' + error);
				memberAuthSendChk = false;
			}
		});
	}
}