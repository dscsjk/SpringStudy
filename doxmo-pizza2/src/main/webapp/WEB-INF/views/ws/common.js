/*
 * @needs jquery
 */

/**
 * Ajax ��û
 *
 * @param ajaxOpt
 */
function callAjax(ajaxOpt) {
	var opt = $.extend({
		type : 'GET',
		cache : false,
		dataType : "json",
		data : {}
	}, ajaxOpt);

	$.ajax(opt);
}

/**
 * �Ķ���� �������� ����
 *
 * @param data
 */
function cvtParam(data) {
	if (!!!data) {
		return '';
	}

	var params = [],
		i = 0;
	$.each(data, function(key, value) {
		params[i++] = key + '=' + value;
	});

	return params.join('&');
}


/**
 * �� ���
 *
 * @param month ����� ���� ��
 * @param day ���� ��¥
 */
function calculateMonth(month, day) {
	var date = day || new Date();

	// Display the month, day, and year. getMonth() returns a 0-based number.'
	date.setMonth(date.getMonth() + month);

	return date;
}


/**
 * üũ�ڽ� ��ü ����
 *
 * @param
 * @returns
 */
$(function(){
	$("input[name=totCheck]").click(function(){
		if($("input[name=totCheck]:checked").length > 0){
			$("input[name=selCheck]").each(function(){
				this.checked=true;
			});
		}else{
			$("input[name=selCheck]").each(function(){
				this.checked=false;
			});
		}
	});
	$("input[name=selCheck]").click(function(){
		if($("input[name=selCheck]").length == $("input[name=selCheck]:checked").length){
			$("input[name=totCheck]").each(function(){
				this.checked=true;
			});
		}else{
			$("input[name=totCheck]").each(function(){
				this.checked=false;
			});
		}
	});
});


/**
 * GNB , LNB �޴��� ��Ŀ��
 *
 * @param  position,subPosition
 * @returns
 */
function menuPosition(position,subPosition){
	$(".header_memu > ul > li:eq("+position+")").addClass("on");												// GNB �޴� class on
	$("#aside > div > div > dl ").hide();																						// LNB �޴� �ʱ�ȭ
	$("#aside > div > div > dl:eq("+position+") ").show();															// GNB �޴��� LNB Show
	$("#aside > div > div > dl:eq("+position+") > dd:eq("+subPosition+")").addClass("on");
}

function NoPosition(){
	$("#aside ").hide();				//LNB hidden
}



/**
 *  ��й�ȣ ��ȿ�� üũ
 *
 * @param  id , msg
 * @returns
 */
function checkPwd(id,msg){
	var alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	var number = "1234567890";
	var sChar = "-_=+\|()*&^%$#@!~`?></;,.:'";
	var sChar_Count = 0;
	var alphaCheck = false;
	var numberCheck = false;
	var pw = $("#"+id).val();

	if($.trim(pw) != ""){
		if(6 <= pw.length || pw.length <= 15){
			for(var i=0; i<pw.length; i++){
				 if(sChar.indexOf(pw.charAt(i)) != -1){	sChar_Count++; }
				 if(alpha.indexOf(pw.charAt(i)) != -1){ alphaCheck = true; }
				 if(number.indexOf(pw.charAt(i)) != -1){ numberCheck = true; }
			}
			var flag = 0;
			if(sChar_Count > 0 && alphaCheck ==true && numberCheck ==true){
				flag = 0;
			}else if(sChar_Count > 0 && alphaCheck ==true && numberCheck !=true ){
				flag = 0;
			}else if(sChar_Count > 0 && alphaCheck !=true && numberCheck ==true ){
				flag = 0;
			}else if(sChar_Count < 1 && alphaCheck ==true && numberCheck ==true ){
				flag = 0;
			}else{
				flag = 1;
			}
			if(flag>0){
				$("#"+id).val("");
				$("#"+id).focus();
				 alert(msg);
				 return;
			}
		}else{
			$("#"+id).val("");
			$("#"+id).focus();
			 alert(msg);
			return;
		}
	}
}

/**
 *  Datepicker ����
 *
 * @param  selector , path
 * @returns
 */

function dateType(selector,path){
	$(selector).datepicker({
		//�ѱ���
		closeText: '�ݱ�',
	    prevText: '������',
	    nextText: '������',
	    currentText: '����',
	    dateFormat: 'yy-mm-dd' ,
		monthNames: [ "1��", "2��", "3��", "4��", "5��", "6��","7��", "8��", "9��", "10��", "11��", "12��" ],
		dayNamesMin: ['��','��','ȭ','��','��','��','��'],
		showOn: 'both',
        buttonImage: path+"/images/common/ico_calendar.gif",
        buttonImageOnly: true ,
        changeMonth: false,
        changeYear: false ,
        yearRange: 'c-100:c+15'

	  });
}


/**
 *  input type ���� �Է½� 1000 ���� �޸�
 *
 * @param  selector
 * @returns
 */

function createNumeric(selector) {
	$(selector).attr("disabled",false);
	jQuery(selector).css('imeMode','disabled').keypress(function(event) {
		if(event.which && (event.which < 48 || event.which > 57) ) {
			event.preventDefault();
		}
	}).keyup(function(){
		if( jQuery(this).val() != null && jQuery(this).val() != '' ) {
			jQuery(this).val( jQuery(this).val().replace(/[^0-9]/g, '') );
		}
	});
}

/**
 * ÷������ Ȯ���� , �뷮 üũ
 *
 * @param $this , type
 * @returns
 */

function fileCheck($this, type){
	var agt = navigator.userAgent.toLowerCase();
	var fileName = $($this).val();
	var maxSize =  10485760;		//10MB

	if (agt.indexOf("msie") != -1) {
		 if(fileName != ""){
			var myFSO = new ActiveXObject("Scripting.FileSystemObject");
			var filepath = $($this).val();
			var thefile = myFSO.getFile(filepath);
			var size = thefile.size;
			if(size > maxSize){
				 $($this).replaceWith( $this = $($this).clone( true ) );
				 return callbackFileCheck("1");	//�뷮 �ʰ���
			 }
		 }
	}else{
		if(fileName != ""){
			var size = document.getElementById($this.id).files[0].size;
			 if(size> maxSize){
				 $($this).val("");
				 return callbackFileCheck("1");	//�뷮 �ʰ���
			 }
		}
	}
	 var fileFormat = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	 if(fileName != ""){
		 if(type =="image"){
			 if(fileFormat !="gif" && fileFormat !="jpg" && fileFormat !="jpeg" && fileFormat !="png"){
				 if (agt.indexOf("msie") != -1) {
					 $($this).replaceWith( $this = $($this).clone( true ) );  //÷������ ����
				 }else{
					 $($this).val("");
				 }
				 return callbackFileCheck("2");		//�̹��� ���� ÷��
			 }
		 }else if(type =="document"){
			 if(fileFormat !="hwp" && fileFormat !="xls" && fileFormat !="xlsx" && fileFormat !="ppt" && fileFormat !="pptx"  && fileFormat !="doc"  && fileFormat !="docx"  && fileFormat !="txt" && fileFormat !="zip"  ){
				 if (agt.indexOf("msie") != -1) {
					 $($this).replaceWith( $this = $($this).clone( true ) );  //÷������ ����
				 }else{
					 $($this).val("");
				 }
				 return callbackFileCheck("3");	//�������� ÷��
			 }
		 }
	 }
}

function callbackFileCheck(val){
	if(val =="1"){alert("<spring:message code='common.util.040' />"); return;}
	if(val =="2"){alert("<spring:message code='common.util.041' />"); return;}
	if(val =="3"){alert("<spring:message code='common.util.042' />"); return;}
}

/**
 * �̸��� ��ȿ�� üũ
 *
 * @param $this
 * @returns  true/false
 */

function emailCheck($this){
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

	if(regex.test($this) == false) {
	    return false;
	} else {
		return true;
	}
}

/**
 * ContextPath ��
 *
 * @param
 * @returns  ctxPath
 */
function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}


/**
 * �˻����� ��ư ����
 *
 * @param type
 * @returns
 */
function changeSearchDt(type){
	$.ajax({
		 url: getContextPath()+"/admin/commonSearchDate.do",
		 data : {"schDtType": type},
		 type: "POST",
		 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		 error: function(request, status, error){
		 	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		 },
		 success: function(map){
		   	$("#schStartDt").val(map.schStartDt);
		   	$("#schEndDt").val(map.schEndDt);
		 }
	});
}

/**
 * Input ������Ʈ�� ���� + .  �� �Է°���
 *
 * @param selector
 * @returns	jQuery Object
 */
function createNumeric(selector) {
	$(selector).attr("disabled",false);
	jQuery(selector).css('imeMode','disabled').keypress(function(event) {
		if(event.which && (event.which < 46 || event.which > 57 || event.which ==47) ) {
			event.preventDefault();
		}
	}).keyup(function(){
		if( jQuery(this).val() != null && jQuery(this).val() != '' ) {
			jQuery(this).val( jQuery(this).val().replace(/[^0-9,.]/g, '') );
		}
	});
}

/**
 * Input ������Ʈ�� ���ڸ� �Է°����ϵ��� ó��
 *
 * @param selector
 * @returns	jQuery Object
 */
function createNumeric2(selector) {
	$(selector).attr("disabled",false);
	jQuery(selector).css('imeMode','disabled').keypress(function(event) {
		if(event.which && (event.which < 48 || event.which > 57) ) {
			event.preventDefault();
		}
	}).keyup(function(){
		if( jQuery(this).val() != null && jQuery(this).val() != '' ) {
			jQuery(this).val( jQuery(this).val().replace(/[^0-9,.]/g, '') );
		}
	});
}

function alertMsg(key){
	var val = "";
	$.ajax({
		 url: getContextPath()+"/admin/scriptAlertMsg.do",
		 data : {"messageKey": key},
		 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		 async: false,
		 type: "POST",
		 error: function(request, status, error){
		 	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		 },
		 success: function(value){
			val =  decodeURIComponent(value.replace(/\+/g, '%20'));

		 }
	});
	return val;
}

/**
 * �ּ� ���� ajax
 *
 * @param selector
 * @returns	jQuery Object
 */

function changeAddr(step , val){
	if(val ==""){
		if(step =="1"){$("#addrGubun2").val(""); $("#addrGubun3").val(""); return false;}
		if(step =="2"){$("#addrGubun3").val(""); return false;}
	}

	$.ajax({
		 url: getContextPath()+"/admin/getStepByAddrListAjax.do",
		 data : {
			 			"addrStep": step ,
			 			"addrId"	: val
			 		},
		 type: "POST",
		 async: false,
		 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		 error: function(request, status, error){
		 	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		 },
		 success: function(list){
		   	var html = "";
		   	for(var i=0; i<list.length; i++){
		   		if(i ==0){
			   		if(step =="1"){
			   			html +="<option value=\"\">"+alertMsg("common.util.046")+"</option>";			//����
			   		}else{
			   			html +="<option value=\"\">"+alertMsg("common.util.047")+"</option>";			//����
			   		}
		   		}
		   		html +="<option value=\""+list[i].id+"\">"+list[i].name+"</option>";
		   	}
		   	var pos = Number(step)+1;
		   	$("#addrGubun"+pos).html(html);
		   	if(pos ==2){
		   		$("#addrGubun3").val("");
		   	}
		 }
	});
}

function MultiSelect(selectBoxId, inputBoxId) {
	var self = this;
	this.SELECTBOX_ID = selectBoxId;
	this.INPUTBOX_ID = inputBoxId;
	this.productArr = new Array();

	this.init = function() {
		var optionCount = $("#"+this.SELECTBOX_ID+" option").size();
	    if(optionCount > 0) {
			for(var i = 0; i < optionCount ; i++) {
				this.productArr.push($("#"+this.SELECTBOX_ID+" option:eq("+i+")").val());
			}
		}
	    this.addInputBox(this.productArr);
	};

	this.addItem = function (seq, nm) {
		if(this.isDup(seq) == true) {alert(alertMsg("admin.event32")); return;}
		$("#"+this.SELECTBOX_ID).append("<option value='" + seq + "'>" + nm + "</option>");
		this.productArr.push(seq); // ���� array �� ���� -> �ߺ����� üũ
		this.addInputBox(this.productArr);  // ���� �����ϱ� ���� input box
	};

	this.isDup = function(seq) {
		//�����ڽ��� �ƹ��͵� ��� ���� �ʴ°�� �ߺ� �� �� ���� (�ߺ����� : false)
		if(this.productArr.length ==0) return false;
		//�����ڽ� �׸�� ���Ͽ� �������� �����ϴ� ��� �ߺ� (�ߺ����� : true)
		for(var i = 0; i <this.productArr.length; i++) {
			if(this.productArr[i] == seq) return true;
		}
		return false
	};

	this.addInputBox = function(arr) {
		var tmpStr;
		for(var i = 0; i < arr.length; i++) {
			if(i==0) tmpStr = arr[i];
			else tmpStr = tmpStr + ","+arr[i];
		}
		$("#"+this.INPUTBOX_ID).val(tmpStr);
	    //alert($("#"+this.INPUTBOX_ID).val());
	};

	this.delItem = function() {
		var idx = $("#"+this.SELECTBOX_ID+" option").index($("#"+this.SELECTBOX_ID+" option:selected"))
		$("#"+this.SELECTBOX_ID+" option:eq("+idx+")").remove();
		this.productArr.splice(idx,1);
		this.addInputBox(this.productArr);
    };
};

var Form = {
	create: function (name, action, method, target) {
		var form = ($("form[id="+name+"]").length > 0) ? document.getElementById(name) : document.createElement("form");
		$(form).empty();
		form.id = name;
		form.name = name;
		form.method = method == null ? "POST" : method;
		form.action = action;
		form.target = target;
		document.body.appendChild(form);
		return form;
	}
};

$.fn.extend({
	formAdd: function (name, value)
	{
		var _this = $(this), input;
		input = document.createElement("input");
		input.type = "hidden";
		input.name = name;
		input.value = value;
		_this.append(input);
	}
});

$.extend({
	fileUpload : function(options) {
		var uploadForm = $("<form method='post' enctype='multipart/form-data'></form>").appendTo("body");
		var uploadElem = $("<input type='file' name='files' id='" + $(options.uploadLabel).attr("for") + "' style='display:none' />").appendTo(uploadForm);


		$(options.uploadLabel).on("click", function() {
			if(options.uploadLimitLen != null){
				if($(options.uploadImgUl).length == Number(options.uploadLimitLen)){
					alert(options.uploadErrMsg);
					return false;
				}else{
					uploadElem.focus();
				}
			}

		});
		uploadElem.on("change", function() {
			var param = {
				   	url : options.uploadUrl+"?gubun="+options.uploadGubun+"&idx="+options.uploadSamplingIdx,
				   	type : "post",
				   	data : uploadForm.serialize(),
				   	dataType: "text",
				   	success : function(data) {
				   		options.successCallback($.parseJSON(data));
				   		uploadForm[0].reset();
				   	},
			   		error: function(x, o, e) {
						alert(x.status + " : "+ o +" : "+ e);
					}
			};

			uploadForm.ajaxSubmit(param);
		});

	}
});

function openPopup(url, name, settings)
{
    //setting Extend
    settings = $.extend(false,
		{
			//Set Default Setting
			width: 100,
			height: 100,
			left: 0,
			top: 0,
			status: 0,
			toolbar: 0,
			location: 0,
			menubar: 0,
			directories: 0,
			resizable: 0,
			scrollbars: 0
		}, settings);

    var strFeatures = "";
    var iLeft = (screen.width - settings.width) / 2;
    var iTop = (screen.height - settings.height) / 2;

    settings.left = iLeft;
    settings.top = iTop;

    strFeatures = this.JSONToString(settings).replace(/{|}/g, "").replace(/:\s*/g, "=").replace(/\"/g, "");

    // open
    var oNewWindow = window.open(url, name, strFeatures, false);

    return oNewWindow;
};

function openPopupToPost(url, params, settings)
{
	var _settings = {},
		form = Form.create("frm1"),
		_params = {};

	params = $.extend(true, _params, params);
	settings = $.extend(true, _settings, settings);
	if (typeof(settings.winname) === "undefined" || settings.winname === "") {
	    settings.winname = "unknown";
	}

	var oNewWindow = openPopup("about:blank", settings.winname, settings);

	for(var item in _params) {
		//POST
		$(form).formAdd(item, _params[item]);
	}
	form.action = url;
	form.target = settings.winname;
	form.submit();

	return oNewWindow;
};

function JSONToString(object)
{
	var results = [];
	for (var property in object) {
		if (typeof (object[property]) == "object") {
			results.push(Util.JSONToString(object[property]));
		}
		else {
			var value = object[property];
			results.push(property.toString() + ": \"" + value + "\"");
		}
	}

	return '{' + results.join(', ') + '}';
};

function locationToPost(url, params)
{
	var temp=document.createElement("form");
	temp.action = url;
	temp.method = "POST";
	temp.style.display = "none";
	for(var x in params) {
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = params[x];
		temp.appendChild(opt);
	}

	document.body.appendChild(temp);
	temp.submit();
	return temp;
};

//����Ʈ �ڽ� UI �ʱ�ȭ
function reloadSelectBox($select){
	var $selectClone = $select.clone(true, true),
		$div = $select.parent('div');

	$div.before($selectClone);
	$div.remove();

	$selectClone.selectbox({customList: true});
}

//���Խ� õ ���� �޸�
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

