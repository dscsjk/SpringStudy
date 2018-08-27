if(navigator.cookieEnabled == false){
	alert("브라우져에서 쿠키를 허용하지 않아 정상적으로 사이트 이용이 불가능 할 수 있습니다. 쿠키를 허용해주세요");
}
if (document.all && (!document.documentMode || (document.documentMode && document.documentMode < 8))) {
    //alert('IE7 or older or IE8+ in IE7 compatibility mode');
	 alert('인터넷 익스플로러 7 이하 이거나  인터넷 익스플로러가 호환성 모드로 작동되고 있습니다. 사이트가 정상적으로 작동되지 않을 수 있습니다. 호환성 모드를 끄거나 최신버전 브라우져를 권장합니다');
}


if(typeof UserInfo === 'undefined'){
	UserInfo = {};
}
UserInfo["user_id"] = null;
UserInfo["user_name"] = null;
UserInfo["user_email"] = null;
UserInfo["user_phone"] = null;
UserInfo["user_no"] = null;
window.UserInfo = UserInfo;


apiutil ={
	sApi : "/get.do",
	sIcon : "http://static.naver.com/maps2/icons/pin_spot2.png",
	sLoader : "/resources/images/common/ajax-loader.gif",
	sPath : { path : "/" },
	str_cust_name : "cust_name",
	str_cust_tel : "cust_tel",
	idCartCount : ".cart_count",
	sCartId : "order_cart_id",
	sOrderId : "complete_order_id",
	sStoreId :"order_store_id",
	sCartCount : "order_cart_count",
	sCartPath : { path :"/"},
	sOrderTypePackage : function () {
		var orderType = this.getOrderType()+"C";
		return orderType;
	},
	sOrderTypeDelivery : function (){
		var orderType = this.getOrderType()+"D";
		return orderType;
	},
	sOrderType : "order_type",
	isLogin : function(){
		var str_user_id = $.cookie("mb_id"); 
		if(!this.isEmpty(str_user_id)){
			return true;
		}
		return false;
	},
	
	chkUserInfo : function(ret_url){
		if(this.isLogin()) {
			this.getUserInfo();
		} else {
			callloginPopUp();
		}
		
	},
	getUserInfo : function(){
		//로그인한 쿠키정보를 전역변수로 사용
		UserInfo.user_id = $.cookie("mb_id");
		UserInfo.user_name = $.cookie("mb_nm");
		UserInfo.user_email = $.cookie("mb_email") == "" ? $.cookie("mb_email") : $.cookie("mb_email");
		UserInfo.user_phone = this.autoHypenPhone($.cookie("mb_tel") == "" ? $.cookie("mb_mobile") : $.cookie("mb_mobile"));
		UserInfo.user_no = $.cookie("mb_no");
	},
	setStoreId :function(str){
		//장바구니 번호를 쿠키에 저장해서 사용
		try {
			if(str < 0){
				str = 0;
			}
		} catch(e){
			str = 0;
		}
		$.cookie(this.sStoreId ,str, this.sPath); 
	},
	getStoreId: function(){
		var storeId = $.cookie(this.sStoreId);
		if(this.isEmpty(storeId)){
			return 0;
		}
		return parseInt(storeId);
	},
	setCompleteId : function(str){
		//주문 완료 건에 대하여 저장함
		try {
			if(str < 0){
				str = 0;
			}
		} catch(e){
			str = 0;
		}
		$.cookie(this. sOrderId,str, this.sCartPath);
	},
	getCompleteId : function(){
		//주문 완료 건에 대하여 저장함
		var orderID = $.cookie(this.sOrderId);
		if(this.isEmpty(orderID)){
			return 0;
		}
		return parseInt(orderID);
	},
	
	setCartId : function(str){
		//장바구니 번호를 쿠키에 저장해서 사
		try {
			if(str < 0){
				str = 0;
			}
		} catch(e){
			str = 0;
		}
		$.cookie(this.sCartId,str, this.sCartPath);
	},
	getCartId : function(){
		//장바구니 번호를 쿠키에 저장해서 사
		var cartId = $.cookie(this.sCartId);
		if(this.isEmpty(cartId)){
			return 0;
		}
		return parseInt(cartId);
	},
	setCartCount : function(num){
		//장바구니에 불러올때 재호출하지 않아도 쓸수있도록 쿠키에 아이템수를 저장해놓고 사용
		if(this.getCartId() > 0) {
			$.cookie(this.sCartCount,num,this.sCartPath);
		} else {
			$.cookie(this.sCartCount,0,this.sCartPath);	
		}
	},
	getCartCount : function(){
		if(this.getCartId() > 0) {
			var cnt = $.cookie(this.sCartCount);
			if(this.isEmpty(cnt)){
				cnt = 0;
			}
			return cnt ;
		}
		return 0;
	},
	getCustName : function(){
		return $.cookie(apiutil.str_cust_name);
	},
	getCustTel : function(){
		return $.cookie(apiutil.str_cust_tel);
	},
	getOrderType : function(){
		var hostname = window.location.hostname;
		if(hostname.indexOf("a") == 0 || hostname.indexOf("i") == 0){
			return "W";
		}
		return "M";
	},
	getOrderClass : function(){
		var hostname = window.location.hostname;
		if(hostname.indexOf("a") == 0){
			return "04";
		} else if(hostname.indexOf("i") == 0){
			return "05";
		}
		return "";
	},
	getDateFormat : function(s){
		var sText =[];
		
		sText.push(s.slice(0,4));
		sText.push(s.slice(4,6));
		sText.push(s.slice(6,8));
		
		
		return sText.join("-");
		
	},
	
	getCurrentTime : function(){
		var d = new Date();

		 var s =
			 apiutil.leadingZeros(d.getHours(), 2) + ':' +
			 apiutil.leadingZeros(d.getMinutes(), 2) + ':' +
			 apiutil.leadingZeros(d.getSeconds(), 2);
		 
		 return s;
	},
	
	leadingZeros : function(n, digits) {
		  var zero = '';
		  n = n.toString();

		  if (n.length < digits) {
		    for (i = 0; i < digits - n.length; i++)
		      zero += '0';
		  }
		  return zero + n;
	},
	
	intplus : function(str){
		var reint;
		if( str > 999 ){
			reint = str;
		}else{
			reint = "0"+str;
		}
		return reint;
	},
	
	chr : function(ch){ 
		return String.fromCharCode(ch); 
	},
	
	
	
	trim : function(str){
		return str.replace( /(\s*)/g, "" );
	},
	
	getMoneyFormat : function(Param){
		if(parseInt(Param) == 0){
			return "0";
		}
		if(typeof Param !== "string"){
			Param = Param +"";
		}
		
		var minus = "";
		if(Param.substring(0, 1) == "-") {
			minus = "-";
		}
		
		var strMoney = Param.replace(/,/g, "");
		strMoney = strMoney.replace(/-/g, "");
		strMoney = strMoney.replace(/^0*/, "");
		var strMoneyLength = strMoney.length;
		
		if(strMoneyLength > 3) {
			var mod = strMoneyLength % 3;
			var value = (mod > 0 ? (strMoney.substring(0, mod)) : "");

			for(var i = 0; i < Math.floor(strMoneyLength / 3); i++) {
				if((mod == 0) && (i == 0)) {
					value = value + strMoney.substring(mod + 3 * i, mod + 3 * i + 3);
				} else {
					value = value + "," + strMoney.substring(mod + 3 * i, mod + 3 * i + 3);
				}
			}
			
			return minus + value;
		} else {
			return minus + strMoney;
		}
	},
	round : function (num,ja) { 

		ja=Math.pow(10,ja) 

		return Math.round(num * ja) / ja; 

	} ,
	getStoreTime: function(store_id){
		var param = [];
		param.push("ex=Linked");
		param.push("ac=checksalesstore");
		param.push("branch_id="+store_id);
		var resultStr = '';
		var self = this;
		$.ajax({ type : 'get',url : '/get.do',data : param.join('&'),async : false,dataType : 'jsonp',
			contentType : 'application/json; charset=utf-8',error : function(e) {apiutil.log(e);},
			success : function(data) {
				if (data != null) {
					try {
						if(typeof data[0].a_delivery_time !=='undefined'){
							console.log(data);
							if(data[0].a_delivery_time != ''){
								resultStr = data[0].a_delivery_time;
							}else{
								resultStr = '30';
							} 
						}else{
							resultStr = '30';
						}
					} catch (e) {
						alert(e);
						resultStr = '30';
						return resultStr
					}
				}else{
					resultStr = '30';
					return resultStr
				}
		}});
		return resultStr;
	},	
	
	getStoreSectionName : function (store_section, store_id) {
		console.log(store_id);
		if(store_id == "84"){
			return "포장+레스토랑";
		}
		if(store_id == "124"){
			return "포장(배달불가)";
		}
		if(store_section == "2") {
			return "배달+포장+레스토랑";
		} else if(store_section == "1") {
			return "배달+포장+미니 레스토랑";
		} else {
			return "배달+포장";
		}
	},
    autoHypenPhone : function (str){
    	if(this.isEmpty(str)){
    		str = "";
    	}
    	str = str.replace(/[^0-9]/g, '');
    	var tmp = '';
    	if( str.length < 4){
    		return str;
    	}else if(str.length < 7){
    		tmp += str.substr(0, 3);
    		tmp += '-';
    		tmp += str.substr(3);
    		return tmp;
    	}else if(str.length < 11){
    		if(str.substr(0, 2)=="02"){
    			if(str.length < 10){
    				tmp += str.substr(0, 2);
            		tmp += '-';
            		tmp += str.substr(2, 3);
            		tmp += '-';
            		tmp += str.substr(5);
    			} else {
    				tmp += str.substr(0, 2);
            		tmp += '-';
            		tmp += str.substr(2, 4);
            		tmp += '-';
            		tmp += str.substr(6);
    			}
    			
    		} else {
    			tmp += str.substr(0, 3);
        		tmp += '-';
        		tmp += str.substr(3, 3);
        		tmp += '-';
        		tmp += str.substr(6);
    		}
    		
    		return tmp;
    	}else{				
    		tmp += str.substr(0, 3);
    		tmp += '-';
    		tmp += str.substr(3, 4);
    		tmp += '-';
    		tmp += str.substr(7);
    		return tmp;
    	}
    	return str;
    },
    onlyNumber : function(e){
    	apiutil.log("onlyNumber:"+e.which);
		var el = $(e.target);
		  var key = String.fromCharCode( e.which );
		  apiutil.log(key);
		  var v = el.val();
		  var regex = /[^0-9]/gi;
		  if( regex.test(v) ) {
			  el.val(v.replace(regex,''));
		  }
	},
	mailFormat : function(el){
		  var v = el.val();
		  var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		  if( regex.test(v) === false) {
			  return false;
		  }
		  return true;
	},
	isEmpty : function(str){
		if(str == null || typeof str === "undefined" || str == ""){
			return true;
		}
		return false;
	},
	log : function(str) {
		if(typeof console === 'undefined'){
		//	document.write(str);
		} else {
			//	console.log(str);
		}
		
	},
	createPagingHTMLURL : function (intThisPage, intLastPage, strURL , params){
		 
		var thisPage = parseInt(intThisPage);
		 var LastPage = parseInt(intLastPage);
		 var strPaging = '<a class="prev" href="'+ strURL +'?page=1' + params+'">'
		 +'<img src="/resources/img/common/paging_first.gif" alt="첫페이지로 이동"></a>';

		 if (LastPage == 0){
		  strPaging = '<span ><strong class="active">'+ thisPage +'</strong></span>';
		 }else{
		  if(thisPage -1 > 0){
		   strPaging = strPaging + '<a class="prev" href="'+ strURL +'?page='+ (thisPage -1).toString() + params+'">'
		      + '<img src="/resources/img/common/paging_prev.gif" alt="이전페이지로 이동"></a>';
		  }
		  strPaging = strPaging + '<span>';
		  var intX = parseInt((thisPage - 1) / 10);
		  
		  var intMOD = thisPage;
		  if (intMOD == 0){
		   intX = intX -1;
		  }
		  for (var j = 1+(intX*10) ; j < 10+(10*intX)+1; j++) {
		   if (j <= LastPage){
		    if (j== thisPage){
		     strPaging = strPaging + '<strong class="active">'+ thisPage +'</strong>';
		    }else{
		     strPaging = strPaging
		       + '<a href="'+ strURL +'?page='+j.toString() + params+'">'+ j.toString() +'</a>';
		    }
		   }
		  }
		 strPaging = strPaging + '</span>';
		  if(thisPage + 1 <= LastPage){
		   strPaging = strPaging + '<a class="next" href="'+ strURL +'?page='+ (thisPage +1).toString() + params+'">'
		      + '<img src="/resources/img/common/paging_next.gif" alt="다음페이지로 이동"></a>';
		  }
		  strPaging = strPaging + '<a class="next" href="'+ strURL +'?page='+ LastPage.toString() + params+'">'
		   +'<img src="/resources/img/common/paging_end.gif" alt="마지막페이지로 이동"></a>';
		 }
		 
		 
		 return strPaging;
		},
	createPagingHTML : function (intThisPage, intLastPage, strFunctionName){
		 var thisPage = parseInt(intThisPage);
		 var LastPage = parseInt(intLastPage);
		 var strPaging = '<a class="prev" href="javascript:'+strFunctionName+'(\'1\');">'
		 +'&lt;&lt;</a>';

		 if (LastPage == 0){
		  strPaging = '<span ><strong class="active">'+ thisPage +'</strong></span>';
		 }else{
		  if(thisPage -1 > 0){
		   strPaging = strPaging + '<a class="prev" href="javascript:'+strFunctionName+'(\''+ (thisPage -1).toString() + '\');">'
		      + '&lt;</a>';
		  }
		  //strPaging = strPaging + '<span>';
		  var intX = parseInt((thisPage - 1) / 10);
		  
		  var intMOD = thisPage;
		  if (intMOD == 0){
		   intX = intX -1;
		  }
		  for (var j = 1+(intX*10) ; j < 10+(10*intX)+1; j++) {
		   if (j <= LastPage){
		    if (j== thisPage){
		     strPaging = strPaging + '<span ><strong class="active">'+ thisPage +'</strong></span>';
		    }else{
		     strPaging = strPaging
		       + '<a href="javascript:'+strFunctionName+'(\''+j.toString() +'\');">'+ j.toString() +'</a>';
		    }
		   }
		  }
		  //strPaging = strPaging + '</span>';
		  if(thisPage + 1 <= LastPage){
		   strPaging = strPaging + '<a class="next" href="javascript:'+strFunctionName+'(\''+ (thisPage +1).toString() + '\');">'
		      + '&gt;</a>';
		  }
		  strPaging = strPaging + '<a class="next" href="javascript:'+strFunctionName+'(\''+ LastPage.toString() +'\');">'
		   +'&gt;&gt;</a>';
		 }
		 
		 
		 return strPaging;
		},
		toHtml:function (str){
			var returnText = str;
			returnText=returnText.replace(/&nbsp;/gi," ");
		    returnText=returnText.replace(/&amp;/gi,"&");
		    returnText=returnText.replace(/&quot;/gi,'"');
		    returnText=returnText.replace(/&lt;/gi,'<');
		    returnText=returnText.replace(/&gt;/gi,'>');
		    returnText=returnText.replace(/\r\n|\n|\r/g, '<br />');
			return returnText;
		},
		calBytes:function(str) {
			var tcount = 0;
			var tmpStr = new String(str);
			var temp = tmpStr.length;
			var onechar;
			for ( k=0; k<temp; k++ ) {
				onechar = tmpStr.charAt(k);
				if (escape(onechar).length > 4) {
					tcount += 2;
				} else {
					tcount += 1;
				}
			}
			return tcount;
		}

}
String.prototype.substr2 = function( idx, cnt )
{
	var str = this;
	var len = 0;
	
	for( var i=0; i<str.length; i++ )
	{
		len += ( str.charCodeAt( i ) > 128 ) ? 2 : 1;
		
		if( len > idx )
		{
			str = str.substr( i );
			break;
		}
	}
	
	len = 0;
	for( var i=0; i<str.length; i++ )
	{
		len += ( str.charCodeAt( i ) > 128 ) ? 2 : 1;
		
		if( len > cnt )
		{
			str = str.substring( 0, i );
			break;
		}
	}
	
	return str;
};
String.prototype.getValueByKey = function (k) {
    var p = new RegExp('\\b' + k + '\\b', 'gi');
    var ret = this.search(p) != -1 ? decodeURIComponent(this.substr(this.search(p) + k.length + 1).substr(0, this.substr(this.search(p) + k.length + 1).search(/(&|;|$)/))) : "";
    if(ret == null || ret =="null"){
    	ret = "";
    }
    return ret;
};

String.prototype.isMobile = function () {
    var arg = arguments[0] ? arguments[0] : "";
    return eval("(/01[016789]" + arg + "[1-9]{1}[0-9]{2,3}" + arg + "[0-9]{4}$/).test(this)");
};
String.prototype.isPhone = function () {
    var arg = arguments[0] ? arguments[0] : "";
    return eval("(/(02|0[3-9]{1}[0-9]{1})" + arg + "[1-9]{1}[0-9]{2,3}" + arg + "[0-9]{4}$/).test(this)");
};
String.prototype.isEmail = function () {
    var arg = arguments[0] ? arguments[0]:"";
    return (/\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/).test(this.trim());
};
String.prototype.isPwdNew = function () {
	console.log("isPwdNew:"+this);
    var chk1 = /^[a-zA-Z0-9]{8,16}$/;
    var chk2 = /[a-z]/;
    var chk3 = /[A-Z]/;
    var chk4 = /\d/;
    console.log("arguments[0]:"+arguments[0]);
    console.log("chk1:"+chk1.test(this.replace(arguments[0],"")));
    console.log("chk2:"+chk2.test(this.replace(arguments[0],"")));
    console.log("chk3:"+chk3.test(this.replace(arguments[0],"")));
    console.log("chk4"+chk4.test(this.replace(arguments[0],"")));
    
    return chk1.test(this.replace(arguments[0],""))
    		&& (chk2.test(this.replace(arguments[0],""))
    		|| chk3.test(this.replace(arguments[0],"")))
    		&& chk4.test(this.replace(arguments[0],""))
    		? true : false;
    		
};
String.prototype.isID = function () {
	console.log("isID");
	console.log(arguments);
    var chk1 = /^[a-z0-9]{6,12}$/;
    var chk2 = /[a-z]/;
    var chk3 = /\d/;
    return chk1.test(this.replace(arguments[0],""))
    		//&& chk2.test(this.replace(arguments[0],""))
    		//&& chk3.test(this.replace(arguments[0],""))
    		? true : false;
    		
};


paramString = function (notinkey){
		var returnPARMS = "";
	 	var query = location.search;  
	    query = query.slice(1);      
	    query = query.split('&');   
	    $.each(query, function(i,value){    
	        var token = value.split('=');   
	        var key = token[0];     
	        var data = token[1];
	        var isInsertKey = true;
	        for (var i = 0; i < notinkey.length; i++) {
				if (notinkey[i] == key){
					isInsertKey = false;
				}
			}	
	        if(isInsertKey){
	        	if(data != null){
	        		returnPARMS = returnPARMS + '&' +value;
	        	}
	        }
	    });
	    return returnPARMS;  
} 

getparamMap = function (notinkey){
	var returnMap = new hashMap();
	var returnPARMS = "";
 	var query = location.search;  
    query = query.slice(1);      
    query = query.split('&');   
    $.each(query, function(i,value){    
        var token = value.split('=');   
        var key = token[0];     
        var data = token[1];
        var isInsertKey = true;
        for (var i = 0; i < notinkey.length; i++) {
			if (notinkey[i] == key){
				isInsertKey = false;
			}
		}	
        if(isInsertKey){
        	if(data!= null){
        		if(data!= ""){
        			returnMap.put(key, decodeURIComponent(data));
        		}
        	}
        }
    });
    return returnMap; 
}

if(apiutil.isLogin()){
	apiutil.getUserInfo();
}
if(typeof $(apiutil.idCartCount) !=='undefined'){
	apiutil.log("cart_count1 :"+apiutil.getCartCount());
	$(apiutil.idCartCount).html(apiutil.getCartCount());
} else {
	apiutil.log("cart_count2");
}

hashMap = function() {
	this.map = new Object();
};
hashMap.prototype = {
	put : function(key, value) {
		this.map[key] = value;
	},
	get : function(key) {
		return this.map[key];
	},
	containsKey : function(key) {
		return key in this.map;
	},
	containsValue : function(value) {
		for ( var prop in this.map) {
			if (this.map[prop] == value)
				return true;
		}
		return false;
	},
	isEmpty : function(key) {
		return (this.size() == 0);
	},
	clear : function() {
		for ( var prop in this.map) {
			delete this.map[prop];
		}
	},
	remove : function(key) {
		delete this.map[key];
	},
	keys : function() {
		var keys = new Array();
		for ( var prop in this.map) {
			keys.push(prop);
		}
		return keys;
	},
	values : function() {
		var values = new Array();
		for ( var prop in this.map) {
			values.push(this.map[prop]);
		}
		return values;
	},
	size : function() {
		var count = 0;
		for ( var prop in this.map) {
			count++;
		}
		return count;
	}
};