/*!
 * callAjax.js
 * using jquery.js
 * 
 * Date: 2011.01.19
 *
 * useage : callAjax.get.json(params);
 *
 */
//var xhrIndex = 0;
//var jXhr = new Array();
var jXhr = null; // XMLHttpRequest
var CallAjaxService = function(_type) {
	if (_type != undefined && _type != null && _type != "" )
		this.type = _type;
	else
		this.type = 'GET';

	this.async = false;
	this.completeFunc = function(){
		jXhr = null;
	};

	// Call jQuery Ajax
	this.service = function(_url, _data, _dataType, _successFunc, _errMsg, _completeFunc) {
		//if(jXhr != null) jXhr.abort(); // 이미 실행중인 Ajax stop
		//if(jXhr != null && jXhr.status!=200) {alert('jXhr is not null \nxhr.status:'); return;} // 이미 실행중인 Ajax가 있다면 return
		//if(jXhr != null) {alert('jXhr is not null'); return;} // 이미 실행중인 Ajax가 있다면 실행 안함
		if(!this.async && jXhr != null) {
			if(confirm('처리중인 작업이 있습니다.\n계속하시겠습니까?')){
				if(jXhr != null) jXhr.abort();
				jXhr = null;
			} else {
				return;
			}
		}

		if (typeof(_completeFunc)=='function') this.completeFunc = _completeFunc;

		jXhr = $.ajax( {
			cache : false,
			type: this.type,
			url : _url,
			data : _data,
			dataType : _dataType,
			success : _successFunc,
			error : function(xReq, textStatus, errorThrown) {
				console.log('ERROR');
				console.log(xReq);
				console.log(textStatus);
				console.log(errorThrown);
				jXhr = null;
				if (_errMsg != undefined && _errMsg != null && _errMsg != "" )
					alert('Error => '+textStatus+'\n' + _errMsg);
			},
			complete : this.completeFunc
		});
		return jXhr;
	};

	this.json = function(_url, _data, _successFunc, _errMsg, _completeFunc){
		return this.service(_url, _data, 'json', _successFunc, _errMsg, _completeFunc);
	};

	this.jsonp = function(_url, _data, _successFunc, _errMsg, _completeFunc){
		return this.service(_url, _data, 'jsonp', _successFunc, _errMsg, _completeFunc);
	};

	this.xml = function(_url, _data, _successFunc, _errMsg, _completeFunc){
		return this.service(_url, _data, 'xml', _successFunc, _errMsg, _completeFunc);
	};

	this.html = function(_url, _data, _successFunc, _errMsg, _completeFunc){
		return this.service(_url, _data, 'html', _successFunc, _errMsg, _completeFunc);
	};

	this.text = function(_url, _data, _successFunc, _errMsg, _completeFunc){
		return this.service(_url, _data, 'text', _successFunc, _errMsg, _completeFunc);
	};
};

var callAjax = {
	get : new CallAjaxService(),
	post : new CallAjaxService('POST')
};

// EOF