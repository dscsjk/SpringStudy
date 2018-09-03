/**
 * ���̵� �ߺ�üũ
 *
 * @param id
 * @return
 */
function idCheck(id) {
	if ($('#id').val() == ""){
		$("#id_alert").text("���̵� �Է��� �ּ���.");
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
					$("#id_alert").text("��� ������ ���̵��Դϴ�.");
					$("#idDupChk").val(data.msg);
				}else{
					$("#id_alert").text("�̹� ������� ���̵��Դϴ�.\n�ٸ� ���̵� �Է����ּ���.");
					$("#idDupChk").val("N");
				}
			}else{
				$("#id_alert").text("���̵�� 8~16���� ����/���ڸ� �����ϸ� ������ ����� �� �����ϴ�.");
				$("#idDupChk").val("N");
			}
		},
		error: function (error){
			alert('Error ==> ' + error);
		}
	});
}

/**
 * ���̵� ��ȿ�� üũ
 *
 * @param id
 * @return
 */
function isValid(userid){

	if( userid.length < 8 || userid.length > 16){
		$("#id_alert").text("�̿���ID�� ���̴� 8 ~ 16�� �Դϴ�.");
		return false;
	}

	if (('A' > userid.charAt(0)) || ('z' < userid.charAt(0)) ) {
		$("#id_alert").text("�̿���ID�� ù���ڴ� �����ڸ� �����մϴ�.");
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
			$("#id_alert").text("�̿���ID�� ����, ����, '_'�� �����մϴ�.");
			return false;
		}
	}
	return true;
}

/**
 * ��й�ȣ ��ȿ�� üũ
 *
 * @param passwd
 * @return
 */
function isValidPwd(passwd){

    var SamePass_0 = 0; //���Ϲ��� ī��Ʈ
    var SamePass_1 = 0; //���Ӽ�(+) ī���
    var SamePass_2 = 0; //���Ӽ�(-) ī���

    var chr_pass_0;
    var chr_pass_1;
    var chr_pass_2;

    var strValue = "qwertyuiop[]asdfghjkl;'zxcvbnm,./][POIUYTREWQ';LKJHGFDSA/.,MNBVCXZqazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLPPLOMKUZAQXSWCDEVFRBGTNHYMJUKILOP";


	if( passwd.length < 8 || passwd.length > 16){
		$("#passwd_alert").text("��й�ȣ�� ���̴� 8 ~ 16�� �Դϴ�.");
		return false;
	}

	//���� üũ
	var nStr = "";
	for(k=0; k < passwd.length; k++) {
		if('0' <= passwd.charAt(k) && '9' >= passwd.charAt(k)){
			nStr += passwd.charAt(k);
		}
	}

	//���� üũ
	var eStr = "";
	for(k=0; k < passwd.length; k++) {
		if(('A' <= passwd.charAt(k) && 'Z' >= passwd.charAt(k))
			|| ('a' <= passwd.charAt(k) && 'z' >= passwd.charAt(k))){
			eStr += passwd.charAt(k);
		}
	}
	if(nStr == "" || eStr == ""){
		$("#passwd_alert").text("��й�ȣ�� ����/���� �������� �����մϴ�.");
		return false;
	}

	/*
    if(!passwd.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/))
    {
        alert("��й�ȣ�� ����, ����, Ư�������� �������� �Է����ּ���.");
        return false;
    }
    */


    for(var i=0; i < passwd.length; i++)
    {
        chr_pass_0 = passwd.charAt(i);
        chr_pass_1 = passwd.charAt(i+1);

        //���Ϲ��� ī��Ʈ
        /*
        if(chr_pass_0 == chr_pass_1)
        {
            SamePass_0 = SamePass_0 + 1;
        }
        */

        chr_pass_2 = passwd.charAt(i+2);
        //���Ӽ�(+) ī���

        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == 1)
        {
            SamePass_1 = SamePass_1 + 1;
        }

        //���Ӽ�(-) ī���
        if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1 && chr_pass_1.charCodeAt(0) - chr_pass_2.charCodeAt(0) == -1)
        {
            SamePass_2 = SamePass_2 + 1;
        }
    }
    if(SamePass_0 > 1)
    {
    	$("#passwd_alert").text("���Ϲ��ڸ� 3�� �̻� ����� �� �����ϴ�.");
        return false;
    }

    if(SamePass_1 >= 1 || SamePass_2 >= 1 )
    {
    	$("#passwd_alert").text("���ӵ� ���ڿ�(123 �Ǵ� 321, abc, cba ��)��\n 3�� �̻� ��� �� �� �����ϴ�.");
        return false;
    }


	if (strValue.indexOf(passwd) >= 0) {
		$("#passwd_alert").text('Ű����� ������ �ִ� ���ڴ� ��й�ȣ�� ����Ͻ� �� �����ϴ�.');
		return false;
	}


	return true;
}


/**
 * �̸��� �����ڽ�
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
 * ������ȣ �߼�
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
	var errorTxt = "������ȣ �߼� �� ������ �߻��Ǿ����ϴ�. �ٽ� �õ����ּ���.";

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
					alert("������ȣ�� �߼۵Ǿ����ϴ�.\n������ȣ �Է¶��� ���ŵ� ������ȣ�� �Է��� �ּ���.");
				} else if (data.status == "hpError") {
					alert("��ȭ��ȣ ���°� �߸� �Ǿ����ϴ�.");
					if (gubun_type == "Y")
						showMemberInfo();
				} else if (data.status == "fail") {
					if (data.msg == "1min") {
						alert("������ȣ ��߼��� �߼� �� 1�� �� �����մϴ�.");
					} else if (data.msg == "1day") {
						alert("������ȣ �߼��� �Ϸ翡 5ȸ�� ���ѵ˴ϴ�.");
					} else if (data.msg == "PCID ERROR") {
						alert("�������� �����Դϴ�.");
					}

					if (gubun_type == "Y")
						showMemberInfo();
				} else if (data.status == "error") { // SMS ��� ����
					alert(errorTxt);
				} else {
					alert("�Է��Ͻ� ������ ������մϴ� Ȯ�ιٶ��ϴ�.");
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