var cookieManager = {
	//ex) cookieManager.setCookie("test", "yes");
	//ex) cookieManager.setCookie("test", "yes", 1);
	//ex) cookieManager.setCookie("test", "yes", 365, "/", "d2.co.kr");
	setCookie : function(name, value) {
		var argv = this.setCookie.arguments;
		var argc = this.setCookie.arguments.length;
		var expireDay = (2 < argc && argv[2] != 0) ? argv[2] : null;
		var path = (3 < argc) ? argv[3] : null;
		var domain = (4 < argc) ? argv[4] : null;
		var secure = (5 < argc) ? argv[5] : false;
		var expireDate = new Date();
		if (expireDay != null) expireDate.setDate(expireDate.getDate() + expireDay);
		document.cookie = name + "=" + escape(value)
						+ ((expireDay == null) ? "" : ("; expires=" + expireDate.toGMTString()))
						+ ((path == null) ? "" : ("; path=" + path))
						+ ((domain == null) ? "" : ("; domain=" + domain))
						+ ((secure == true) ? "; secure" : "");
	}
	,
	getCookie : function(name) {
		var nameOfCookie = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + nameOfCookie.length);
			if (document.cookie.substring(x, y) == nameOfCookie) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;
					return unescape(document.cookie.substring(y, endOfCookie));
				}
				x = document.cookie.indexOf(" ", x) + 1;
				if (x == 0) break;
		}
		return "";
	}
	,
	clearCookie : function(name) {
		var expireDate = new Date();
	 	expireDate.setDate(expireDate.getDate() - 1);
		document.cookie = name + "=" + "; expires=" + expireDate.toGMTString();
	}
	,
	getDomain : function() {
		var dm = document.domain;
		var dmArr = dm.split('.');
		if (dmArr.length == 1) return null;
		var dmNew = dmArr[dmArr.length - 2] + '.' + dmArr[dmArr.length - 1];
		return (dmArr[dmArr.length - 1].length == 2) ? dmArr[dmArr.length - 3] + '.' + dmNew : dmNew;
	}
	,
	makePCID : function(name, length) {
		var today = new Date();
		var expireDay = 365 * 10;
		var cookie = this.getCookie(name);
		if (cookie) return false;
		var values = new Array();
		for (i=0; i<length; i++) {
			values[i] = "" + Math.random();
		}
		var value = today.getTime();
		for (i=0; i<length; i++) {
			value += values[i].charAt(2);
		}
		var domain = this.getDomain();
    	this.setCookie(name, value, expireDay, "/", domain);
	}
}

//cookieManager.makePCID("PCID", 10);
