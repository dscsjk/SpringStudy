/**
 * ������ ��, �� ���� ����
 *
 * @return : String
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * ������ �� ����
 *
 * @return : String
 */
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/, "");
};

/**
 * ������ �� ���� ����
 *
 * @return : String
 */
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/, "");
};

/**
 * ���ڿ��� byte ���� ��ȯ
 *
 * @return : int
 */
String.prototype.byte = function() {
	var cnt = 0;
	for (var i = 0; i < this.length; i++) {
		if (this.charCodeAt(i) > 127)
			cnt += 2;
		else
			cnt++;
	}
	return cnt;
};

/**
 * ���������� ��ȯ
 *
 * @return : String
 */
String.prototype.integer = function() {
	if (!isNaN(this)) {
		return parseInt(this, 10);
	} else {
		return null;
	}
};

/**
 * ���ڸ� ���� ����
 *
 * @return : String
 */
String.prototype.num = function() {
	return (this.trim().replace(/[^0-9]/g, ""));
};

/**
 * ���ڿ� 3�ڸ����� , �� �� ��ȯ
 *
 * @return : String
 */
String.prototype.cvtNumber = function() {
	var num = this.trim();
	while ((/(-?[0-9]+)([0-9]{3})/).test(num)) {
		num = num.replace((/(-?[0-9]+)([0-9]{3})/), "$1,$2");
	}
	return num;
};


Number.prototype.cvtNumber = function() {
	if(this==0) return 0;
	var reg = /(^[+-]?\d+)(\d{3})/;
	var n = (this + '');
	while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
	return n;
};


/**
 * ������ �ڸ���(cnt)�� �µ��� ��ȯ
 *
 * @return : String
 */
String.prototype.digits = function(cnt) {
	var digit = "";
	if (this.length < cnt) {
		for (var i = 0; i < cnt - this.length; i++) {
			digit += "0";
		}
	}
	return digit + this;
};

/**
 * " -> &#34; ' -> &#39;�� �ٲپ ��ȯ
 *
 * @return : String
 */
String.prototype.quota = function() {
	return this.replace(/"/g, "&#34;").replace(/'/g, "&#39;");
};

/**
 * html ����
 *
 * @return : String
 */
String.prototype.stripHtml = function() {
	return this.replace(/(<([^>]+)>)/ig, "");
};

/**
 * ���� Ȯ���ڸ� ��������
 *
 * @return : String
 */
String.prototype.ext = function() {
	return (this.indexOf(".") < 0) ? "" : this.substring(
			this.lastIndexOf(".") + 1, this.length);
};

/**
 * URL���� �Ķ���� ������ ������ url ���
 *
 * @return : String
 */
String.prototype.uri = function() {
	var arr = this.split("?");
	arr = arr[0].split("#");
	return arr[0];
};

/**
 * ���ԽĿ� ���̴� Ư�����ڸ� ã�Ƽ� �̽������� �Ѵ�.
 *
 * @return : String
 */
String.prototype.meta = function() {
	var str = this;
	var result = "";
	for (var i = 0; i < str.length; i++) {
		if ((/([\$\(\)\*\+\.\[\]\?\\\^\{\}\|]{1})/).test(str.charAt(i))) {
			result += str.charAt(i).replace(
					(/([\$\(\)\*\+\.\[\]\?\\\^\{\}\|]{1})/), "\\$1");
		} else {
			result += str.charAt(i);
		}
	}
	return result;
};

/**
 * ���ԽĿ� ���̴� Ư�����ڸ� ã�Ƽ� �̽������� �Ѵ�.
 *
 * @return : String
 */
String.prototype.remove = function(pattern) {
	return (pattern == null) ? this : eval("this.replace(/[" + pattern.meta()
			+ "]/g, \"\")");
};

/**
 * �ּ� �ִ� �������� ���� str.isLength(min [,max])
 *
 * @return : boolean
 */
String.prototype.isLength = function() {
	var min = arguments[0];
	var max = arguments[1] ? arguments[1] : null;
	var success = true;
	if (this.length < min) {
		success = false;
	}
	if (max && this.length > max) {
		success = false;
	}
	return success;
};

/**
 * �ּ� �ִ� ����Ʈ���� ���� str.isByteLength(min [,max])
 *
 * @return : boolean
 */
String.prototype.isByteLength = function() {
	var min = arguments[0];
	var max = arguments[1] ? arguments[1] : null;
	var success = true;
	if (this.byte() < min) {
		success = false;
	}
	if (max && this.byte() > max) {
		success = false;
	}
	return success;
};

/**
 * �����̳� ������ Ȯ��
 *
 * @return : boolean
 */
String.prototype.isBlank = function() {
	var str = this.trim();
	for (var i = 0; i < str.length; i++) {
		if ((str.charAt(i) != "\t") && (str.charAt(i) != "\n")
				&& (str.charAt(i) != "\r")) {
			return false;
		}
	}
	return true;
};

/**
 * ���ڷ� �����Ǿ� �ִ��� ���� arguments[0] : ����� ���ڼ�
 *
 * @return : boolean
 */
String.prototype.isNum = function() {
	return (/^[0-9]+$/).test(this.remove(arguments[0])) ? true : false;
};

/**
 * ��� ��� - arguments[0] : �߰� ����� ���ڵ�
 *
 * @return : boolean
 */
String.prototype.isEng = function() {
	return (/^[a-zA-Z]+$/).test(this.remove(arguments[0])) ? true : false;
};

/**
 * �����&nbsp; �� ��� - arguments[0] : �߰� ����� ���ڵ�
 *
 * @return : boolean
 */
String.prototype.isblankEng = function() {
	return (/^[a-zA-Z\s]+$/).test(this.remove(arguments[0])) ? true : false;
},

/**
 * ���ڿ� ��� ��� - arguments[0] : �߰� ����� ���ڵ�
 *
 * @return : boolean
 */
String.prototype.isEngNum = function() {
	return (/^[0-9a-zA-Z]+$/).test(this.remove(arguments[0])) ? true : false;
};

/**
 * ���ڿ� ��� ��� - arguments[0] : �߰� ����� ���ڵ�
 *
 * @return : boolean
 */
String.prototype.isNumEng = function() {
	return this.isEngNum(arguments[0]);
};

/**
 * ���̵� üũ ����� ���ڸ� üũ ù���ڴ� ����� ���� - arguments[0] : �߰� ����� ���ڵ�
 *
 * @return : boolean
 */
String.prototype.isUserid = function() {
	return (/^[0-9a-zA-Z]+$/).test(this.remove(arguments[0])) ? true : false;
};

/**
 * �̸����� ��ȿ���� üũ
 *
 * @return : boolean
 */
String.prototype.isEmail = function() {
	return (/\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/).test(this.trim());
};

/**
 * ��ȭ��ȣ üũ - arguments[0] : ��ȭ��ȣ ������
 *
 * @return : boolean
 */
String.prototype.isPhone = function (separator) {
    var sep = separator ? separator : "";

    var regStr = "(02|0[3-9]{1}[0-9]{1})" + sep + "?[1-9]{1}[0-9]{2,3}" + sep + "?[0-9]{4}$";
    var re = new RegExp(regStr);
    var rtnVal = re.test(this);

    return rtnVal;
};

/**
 * �ڵ�����ȣ üũ - arguments[0] : �ڵ��� ������
 *
 * @return : boolean
 */
String.prototype.isMobile = function(separator) {
	var sep = separator ? separator : "";

    var regStr = "^01[016789]" + sep + "?[1-9]{1}[0-9]{3,4}" + sep + "?[0-9]{4}$";
    var re = new RegExp(regStr, "");
    var rtnVal = re.test(this);

    return rtnVal;
};

/**
 * �ڵ�����ȣ üũ - arguments[0] : �ڵ��� ������
 *
 * @return : boolean
 */
String.prototype.isMobile2 = function() {
	var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
	return regExp.test(this);
};

/**
 * ���ڿ� Ÿ��
 * @returns
 */
String.prototype.format = function() {
	var num = parseFloat(this);
	return isNaN(num) ? "0" : num.format();
};

/**
 * ���ڿ��� ���Ե� ����
 * @return : integer
 */
String.prototype.indexCount = function(div) {
	var str = this,
		counter = 0,
		pos = str.indexOf(div);

	while(pos > -1){
		counter++;
	    pos =  str.indexOf(div, pos + 1);
	}
	return counter;
};

/**
 * replaceAll
 * @return : String
 */
String.prototype.replaceAll = function(str, rps) {
	return this.split(str).join(rps);
};

/**
 * ���� Ÿ��
 */
Number.prototype.format = function() {
	if (this == 0)
		return 0;

	var reg = /(^[+-]?\d+)(\d{3})/;
	var n = (this + '');

	while (reg.test(n))
		n = n.replace(reg, '$1' + ',' + '$2');

	return n;
};

/**
 * �迭 �ߺ� ����
 */
Array.prototype.unique = function() {
	var a = {};
	for (var i = 0; i < this.length; i++) {
		if (typeof a[this[i]] == "undefined") {
			a[this[i]] = 1;
		}
	}
	this.length = 0;
	for ( var i in a) {
		this[this.length] = i;
	}
	return this;
};

/**
 * ��¥ �� �Լ� sDate: �� ��� ��¥ ù��° ex: 2009-04-29 eDate: �� ��� ��¥ �ι�° ex:
 * 2009-04-28
 */
function compDate(sDate, eDate) {
	var start_dates = sDate.split("-");
	var end_dates = eDate.split("-");
	var date1 = new Date(start_dates[0], start_dates[1], start_dates[2])
			.valueOf();
	var date2 = new Date(end_dates[0], end_dates[1], end_dates[2]).valueOf();
	if ((date2 - date1) < 0) {
		return false;
	} else {
		return true;
	}
}

/**
 * name (form.�̸� ) , ivalue(Value) ��) optionValueSel(form.job , 2) �ش� �ɼǿ��� �����
 * �������� ����Ʈ ��Ų��.
 */
function optionValueSel(name, ivalue) {
	var i, sel = 0;
	for (i = 0; i < name.length; i++) {
		if (name.options[i].value == ivalue) {
			sel = i;
		}
	}
	name.options[sel].selected = true;
}

/**
 * ��) optionValueRtn(form.name) �ش� �ɼǿ��� ���õ� ������� ���� ��Ų��.
 */
function optionValueRtn(name) {
	var name_value = "";
	for (var i = 0, len = name.length; i < len; i++) {
		if (name[i].selected == true) {
			name_value = name[i].value;
			break;
		}
	}
	return name_value;
}

/**
 * ��) optionTextRtn(form.name) �ش� �ɼǿ��� ���õ� �ؽ�Ʈ���� ���� ��Ų��.
 */
function optionTextRtn(name) {
	var name_value = "";
	for (var i = 0, len = name.length; i < len; i++) {
		if (name[i].selected == true) {
			name_value = name[i].text;
			break;
		}
	}
	return name_value;
}

/**
 * ��) optionSelectedCnt(form.name) select���� ���õ� option�� ������ ���� ��Ų��.
 */
function optionSelectedCnt(name) {
	var cnt = 0;
	for (var i = 0, len = name.length; i < len; i++) {
		if (name[i].selected == true) {
			cnt++;
		}
	}
	return cnt;
}

/**
 * ��) optionSelectedCnt(form.name) select���� ���õ� option�� ������ ���� ��Ų��.
 */
function selectedCnt(name) {
	var cnt = 0;
	if (name) {
		if (!name.length) {
			if (name.checked) {
				cnt++;
			}
		} else {
			for (var i = 0; i < name.length; i++) {
				if (name[i].checked == true) {
					cnt++;
				}
			}
		}
	}
	return cnt;
}

/**
 * ��) checkRadio(name) ���� ��ư���� ������ ���� ������� �����Ѵ� �����Ѱ��� ���ٸ� "" ������ �����Ѵ�.
 */
function checkRadio(name) {
	var radio = document.getElementsByName(name);
	if (radio) {
		if (!radio.length) {
			if (radio.checked) {
				return radio.value;
			}
		} else {
			for (var i = 0; i < radio.length; i++) {
				if (radio[i].checked) {
					return radio[i].value;
				}
			}
		}
	}
	return "";
}

/**
 * ��) checkInsert ( name (form�̸� ) , ivalue(Int�� Value) ) radio�� checkbox ���� �ش�
 * ������� �������� ���� �ǵ��� �Ѵ�.
 */
function checkInsert(name, ivalue) {
	if (name) {
		if (!name.length) {
			if (name.value == ivalue) {
				name.checked = true;
			}
		} else {
			for (var i = 0; i < name.length; i++) {
				if (name[i].value == ivalue) {
					name[i].checked = true;
				}
			}
		}
	}
}

/**
 * ���� document.write
 */
function dw(str) {
	document.write(str);
}

/**
 * ���ȿ� �ִ� ������ ���ڵ��ؼ� �����Ѵ�. ��) formData2QueryString(document.pageForm) ����)
 * gotoPage=3&col=1&search=
 */
function formData2QueryString(docForm) {
	var submitContent = '';
	var formElem;
	var lastElemName = '';
	for (var i = 0, len = docForm.elements.length; i < len; i++) {

		formElem = docForm.elements[i];

		switch (formElem.type) {
		// Text fields, hidden form elements
		case 'text':
		case 'hidden':
		case 'password':
		case 'textarea':
		case 'select-one':
			submitContent += formElem.name + '=' + escape(formElem.value) + '&';
			break;

		// Radio buttons
		case 'radio':
			if (formElem.checked) {
				submitContent += formElem.name + '=' + escape(formElem.value)
						+ '&';
			}
			break;

		// Checkboxes
		case 'checkbox':
			if (formElem.checked) {
				// Continuing multiple, same-name checkboxes
				if (formElem.name == lastElemName) {
					// Strip of end ampersand if there is one
					if (submitContent.lastIndexOf('&') == submitContent.length - 1) {
						submitContent = submitContent.substr(0,
								submitContent.length - 1);
					}
					// Append value as comma-delimited string
					submitContent += ',' + escape(formElem.value);
				} else {
					submitContent += formElem.name + '='
							+ escape(formElem.value);
				}
				submitContent += '&';
				lastElemName = formElem.name;
			}
			break;
		}
	}

	// Remove trailing separator
	submitContent = submitContent.substr(0, submitContent.length - 1);
	return submitContent;
}

/**
 * �Լ� : window_center(����,����) ���� : ����â�� ������ ���� ��� : window_center (����,����) ��)
 * window_center(100,100)
 */
function window_center(w, h) {
	var width = screen.width;
	var height = screen.height;
	var x = (width / 2) - (w / 2);
	var y = (height / 2) - (h / 2);
	window.resizeTo(w, h);
	window.moveTo(x, y);
}

function getWeekEnd(str) {
	var weekInfo = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
	var d = toTimeObject(str);
	var day = d.getDay();
	return weekInfo[day];
}

function lastday(calyear, calmonth) {
	var monthDays = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	if (((calyear % 4 == 0) && (calyear % 100 != 0)) || (calyear % 400 == 0)) {
		monthDays[1] = 29;
	}
	var nDays = monthDays[calmonth - 1];
	return nDays;
}

function toTimeObject(time) {
	var year = time.substr(0, 4);
	var month = time.substr(4, 2) - 1;
	var day = time.substr(6, 2);
	return new Date(year, month, day);
}

function GetSelectedVal(objSelect) {
	var selectedval = "";
	for (var i = 0, len = objSelect.options.length; i < len; i++) {
		if (objSelect.options[i].selected == true) {
			selectedval = objSelect.options[i].value;
			break;
		}
	}
	return selectedval;
}

function GetSelectedTxt(objSelect) {
	var selectedtext = "";
	for (var i = 0, len = objSelect.options.length; i < len; i++) {
		if (objSelect.options[i].selected == true) {
			selectedtext = objSelect.options[i].text;
			break;
		}
	}
	return selectedtext;
}

function allblur() {
	for (var i = 0, len = document.links.length; i < len; i++) {
		var obj = document.links[i];
		if (obj.addEventListener) {
			obj.addEventListener("focus", oneblur, false);
		} else if (obj.attachEvent) {
			obj.attachEvent("onfocus", oneblur);
		}
	}
}

function oneblur(e) {
	var evt = e ? e : window.event;
	if (evt.target) {
		evt.target.blur();
	} else if (evt.srcElement) {
		evt.srcElement.blur();
	}
}

/**
 * Source Select�� ���(option)�� Target Select�� �̵��Ѵ�.
 *
 * @author neoburi@nowonplay.com, 2005.12.27
 */
function moveElement(sourceObj, targetObj, isSort) {
	var elms = sourceObj.options;
	for (var i = 0, k = elms.length; i < k; i++) {
		if (elms[i].selected) {
			targetObj
					.add(new Option(elms[i].text, elms[i].value, false, false));
		}
	}
	removeElement(sourceObj);
	sourceObj.selectedIndex = -1;
}

/**
 * Source Select�� ���(option)�� �����Ѵ�.
 *
 * @author neoburi@nowonplay.com, 2005.12.27
 */
function removeElement(sourceObj) {
	var elms = sourceObj.options;
	var posArr = new Array();
	var increase = 0;
	for (var i = 0, k = elms.length; i < k; i++) {
		if (elms[i].selected) {
			posArr[increase++] = elms[i].value;
		}
	}
	for (var i = 0, k = posArr.length; i < k; i++) {
		for (x = 0, y = elms.length; x < y; x++) {
			if ((posArr[i] == elms[x].value) && elms[x].selected) {
				sourceObj.remove(x);
				x = 0;
				y--;
			}
		}
	}
}

/**
 * Source Select�� ���(option)�� ���ϼ����� �ٲ۴�.
 *
 * @author �ƹ���, 2005.12.27
 */
function move_option_in(src, to) {
	if (!src)
		return;
	var src_index = src.selectedIndex;
	if (src_index < 0)
		return;
	if (to == "up") {
		if (src_index == -1 || src_index == 0)
			return;
		var tempoption = new Option(src.options[src_index].text,
				src.options[src_index].value);
		src.options[src_index] = new Option(src.options[src_index - 1].text,
				src.options[src_index - 1].value);
		src.options[src_index - 1] = tempoption;
		src.options[src_index - 1].selected = true;
	} else if (to == "down") {
		if (src_index >= src.options.length - 1)
			return;
		var tempoption = new Option(src.options[src_index].text,
				src.options[src_index].value);
		src.options[src_index] = new Option(src.options[src_index + 1].text,
				src.options[src_index + 1].value);
		src.options[src_index + 1] = tempoption;
		src.options[src_index + 1].selected = true;
	}
}

/**
 * object�� Left Position�� �����Ѵ�.
 */
function g_getLeftPos(obj) {
	var parentObj = null;
	var clientObj = obj;
	var left = obj.offsetLeft + document.body.clientLeft;
	while ((parentObj = clientObj.offsetParent) != null) {
		left = left + parentObj.offsetLeft;
		clientObj = parentObj;
	}
	return left;
}

/**
 * object�� Top Position�� �����Ѵ�.
 */
function g_getTopPos(obj) {
	var parentObj = null;
	var clientObj = obj;
	var top = obj.offsetTop + document.body.clientTop;

	while ((parentObj = clientObj.offsetParent) != null) {
		top = top + parentObj.offsetTop;
		clientObj = parentObj;
	}
	return top;
}

/**
 * �ڵ尪�� �о�´�
 */
function g_getValue(obj) {
	if (typeof obj != "object")
		return null;
	if (select == null)
		return null;
	return obj.options[obj.selectedIndex].value;
}

/**
 * objVal�� form file value 'C:\My Documents\My Pictures\���ڵ���\xxxx.jpg' limitExt��
 * 'jpg|gif|png|bmp' Ȯ���ڰ� �ش��ϴ� Ȯ���ڰ� �ƴҰ�� ���� false
 */
function fileExtCheck(objVal, limitExt) {
	var val = objVal.toLowerCase();
	if (!val) {
		return false;
	}
	var fileExt = val.substr(val.lastIndexOf('.') + 1, val.length);
	if (limitExt.indexOf(fileExt) == -1) {
		return false;
	}
	return true;
}

function n2c(num) {
	return (parseInt(num) < 10 || num.length < 2) ? "0" + num : "" + num;
}

function isNextChar(str, pos) {
	var code1 = str.charAt(pos).charCodeAt(0);
	var code2 = str.charAt(pos + 1).charCodeAt(0);
	return (code1 == (code2 - 1)) ? true : false;
}

function isPreviousChar(str, pos) {
	var code1 = str.charAt(pos).charCodeAt(0);
	var code2 = str.charAt(pos + 1).charCodeAt(0);
	return (code1 == (code2 + 1)) ? true : false;
}

function isContainSequentialString(str) {
	for (var i = 0; i < str.length - 3; i++) {
		if ((isNextChar(str, i) && isNextChar(str, i + 1) && isNextChar(str,
				i + 2))
				|| (isPreviousChar(str, i) && isPreviousChar(str, i + 1) && isPreviousChar(
						str, i + 2))) {
			return true;
		}
	}
	return false;
}

function isContains(source, search) {
	return source.search(search) != -1 ? true : false;
}

/**
 * ���Ͼ��ε�� actionUrl�� �������ش� ��) http://aa.bb.co.kr/aaaa/bbb/ab.jsp �ΰ�� /aaaa/bbb
 * ����
 */
function getActionUrl() {
	var url = location.href;
	var urlArr = (url).split("/");
	url = "";
	for (var i = 3; i < urlArr.length - 1; i++) {
		url += "/" + urlArr[i];
	}
	return url;
}

/**
 * ���� : �Է��� email�� �����ڿ�
 *
 * @���� ��Ȯ�� �� �ִ��� ��) checkEmail("test@test.co.kr") ���) true ���� : �̸����� �´ٸ� True ,
 *     Ʋ���ٸ� false
 */
function checkEmail(email) {
	var str = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_';
	var flag = 0;
	var comma = 0;
	for (var i = 0; i < email.length; i++) {
		for (var j = 0; j < str.length; j++) {
			if (email.charAt(i) == str.charAt(j)) {
				break;
			}
		}
		if (j == str.length) {
			if (email.charAt(i) == '@') {
				flag++;
			} else if (email.charAt(i) == '.') {
				comma++;
			} else {
				return false;
			}
		}
	}
	if (flag != 1) {
		return false;
	} else if ((comma < 1) || (comma > 3)) {
		return false;
	} else {
		return true;
	}
}

function check_email(str) {
	var regDoNot = /(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;
	var regMust = /^[a-zA-Z0-9\-\.\_]+\@[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3})$/;
	return (!regDoNot.test(str) && regMust.test(str)) ? true : false;
}

/**
 * AUTO TAB
 */
function autoTab(input, len, e) {
	var isNN = (navigator.appName.indexOf("Netscape") != -1);
	var keyCode = (isNN) ? e.which : e.keyCode;
	var filter = (isNN) ? [ 0, 8, 9 ] : [ 0, 8, 9, 16, 17, 18, 37, 38, 39, 40,
			46 ];
	if (input.value.length >= len && !containsElement(filter, keyCode)) {
		input.value = input.value.slice(0, len);
		input.form[(getIndex(input) + 1) % input.form.length].focus();
	}
	function containsElement(arr, ele) {
		var found = false, index = 0;
		while (!found && index < arr.length)
			if (arr[index] == ele)
				found = true;
			else
				index++;
		return found;
	}
	function getIndex(input) {
		var index = -1, i = 0;
		while (i < input.form.length && index == -1)
			if (input.form[i] == input)
				index = i;
			else
				i++;
		return index;
	}
	return true;
}

/**
 * ���ڿ��� byte ����ū �ڸ���. str : ���ڿ� maxLen : ����Ʈ �ִ��
 */
var strCutByte = function(str, maxLen) {
	var ret = '';
	var msglen = 0;
	for (var i = 0, len = str.length; i < len; i++) {
		var ch = str.charAt(i);
		if (escape(ch).length > 4) {
			msglen += 2;
		} else {
			msglen++;
		}
		if (msglen > maxLen)
			break;
		ret += ch;
	}
	return ret;
};

function OnlyNumber() {
	var key = event.keyCode;
	console.debug(key);
	if (!(key == 8 || key == 9 || key == 13 || key == 46// || key == 144 //?
//			|| (key >= 37 && key <= 40) //up, down, left, right
			|| (key >= 48 && key <= 57) //0~9
			|| (key >= 96 && key <= 105)
			//|| key == 110 || key == 190 // .
		)) {
		event.returnValue = false;
	}
}

function onlyNumber(event) {
	event = event || window.event;

	var key = (event.which) ? event.which : event.keyCode;
//	console.debug(key);
	if( ( key >=48 && key <= 57 ) || ( key >= 96 && key <= 105 )	//num
			|| (key >= 37 && key <= 40) //up, down, left, right
			|| (key == 8 || key == 9 || key == 13 || key == 46)) {
		return;
	} else {
		return false;
	}
}

/**
 * �ڸ����� �°� ���� ���� ex) addZero(3, 1) return "001"
 *
 * @param digit
 *            �ڸ���
 * @param num
 *            ����
 */
function addDigitZero(digit, num) {
	var numLen = (num + "").length;
	var convertNum = "";
	for (var i = 0, len = (digit - numLen); i < len; i++) {
		convertNum += "0";
	}

	return convertNum + "" + num;
}

/**
 * ��/��/�Ͽ� �ش��ϴ� ���� ��¥��, ������ ��¥�� ��ȸ�Ѵ�. ex) monthOfEndDay('20130213','.') return
 * {startDt:"2013.02.01", endDt:"2013.02.28'}
 *
 * @param day
 *            ��¥
 * @param div
 *            ��¥ ����
 */
function monthOfEndDay(day, div) {
	var dayInfo = day.split(div);
	var year = dayInfo[0];
	var month = dayInfo[1];
	var day = dayInfo[2];
	var date = new Date(year, month, day);
	date.setDate(0);
	var startDt = year + div + month + div + "01";
	var endDt = date.getFullYear() + div + addDigitZero(2, date.getMonth() + 1)
			+ div + addDigitZero(2, date.getDate());
	return {
		startDt : startDt,
		endDt : endDt
	};
}

/**
 * ��¥ ���� ex) formatDate('20130213','.') return 2013.02.13
 *
 * @param ymd
 * @param div
 */
function formatDate(ymd, div) {
	var year = ymd.substring(0, 4), month = ymd.substring(4, 6), day = ymd
			.substring(6, 8);

	return year + div + month + div + day;
}

/**
 * �ش�� ���� �ִ밪
 *
 * @param dateStr
 *            YYYYMM
 */
function getWeekCountOfMonth(dateStr) {
	var year = Number(dateStr.substring(0, 4));
	var month = Number(dateStr.substring(4, 6));

	var nowDate = new Date(year, month - 1, 1);

	var lastDate = new Date(year, month, 0).getDate();
	var monthSWeek = nowDate.getDay();

	var weekSeq = parseInt((parseInt(lastDate) + monthSWeek - 1) / 7) + 1;

	return weekSeq;
}

/**
 * Null ó��
 *
 * @param dateStr
 */
function nvl(data) {
	return data || '';
}

/**
 * �� ����
 *
 * @param monthStr
 * @param isShot
 */
function getMonthEng(monthStr, isShot) {

	var engMonth = '', month = parseInt(monthStr);

	switch (month) {
	case 1:
		engMonth = "January";
		break;
	case 2:
		engMonth = "February";
		break;
	case 3:
		engMonth = "March";
		break;
	case 4:
		engMonth = "April";
		break;
	case 5:
		engMonth = "May";
		break;
	case 6:
		engMonth = "June";
		break;
	case 7:
		engMonth = "July";
		break;
	case 8:
		engMonth = "August";
		break;
	case 9:
		engMonth = "September";
		break;
	case 10:
		engMonth = "October";
		break;
	case 11:
		engMonth = "November";
		break;
	case 12:
		engMonth = "December";
		break;

	default:
		engMonth = "January";
	}

	return (isShot) ? engMonth.substring(0, 3) : engMonth;
}

/**
 * �ܼ� �α� �ܼ��� �����ϴ� ������������ console ����
 */
function consoleLog(log) {

	var console = window.console || {log:function(){}};

	if(!!!console){
		return;
	}

	var len = arguments.length;
	var arrToString = [];

	if(len < 2){
		console.log(log);
	}else{
		var splitStr = arguments[0].split('{}');
		if(splitStr.length > 1){
			var str = '';
			for (var i = 0; i < len; i++) {
				str = ((i + 1) < len) ? arguments[i + 1] : '';
				arrToString[i] = splitStr[i] + str;
			}
		}
	}
	console.log(arrToString.join(''));
}

/**
 * ,������ ���� return
 * @param num
 */
function cvtNumber(num){
	return (num + '').cvtNumber();
}

/**
 * ,������ ���� return
 * @param dt Date
 */
function getDateInfo(date){
	var dt = date || new Date();
	var date = {
		Y: dt.getFullYear(),
		M: (dt.getMonth() + 1),
		D: dt.getDate(),
		h: n2c(dt.getHours()),
		m: n2c(dt.getMinutes()),
		s: n2c(dt.getSeconds())
	};

	return date;
}

/**
 * ���� ��¥
 */
function getToday(dFormat){
	var dt = getDateInfo();
		rValue = '',
		value = '';

	for (var i = 0 , len = dFormat.length; i < len; i++) {
		var chrt = dFormat.charAt(i);
		value = dt[chrt] || chrt;
		rValue += value;
	}

	return rValue;
}

//-----------------------------------------------------------------------------
// ���� : ������ ���� üũ�ؼ� �����̸� �޼��� �������� �ش� ������ ��Ŀ��
// ��) checkSpace(frm,strMsg) checkSpace(��.�̸�, �޼���)
// ����) ������ �ƴϸ� true | �����̸� false
//-----------------------------------------------------------------------------
function checkSpace(frm, strMsg, blnFocus) {
	if(frm.val().isBlank()){
		if(strMsg) alert(strMsg);
		frm.val("");
		frm.focus();
		return false;
	}
	return true;
}

/**************************************************************
���� : ���� �Է� üũ
��) checkNum(frm,strMsg) checkNum(��.�̸�, �޼���)
����) ���ڰ� �´ٸ� true | ���ڰ� �ƴ϶�� �޼��� �˸��� false
**************************************************************/
function checkNum(frm,strMsg){
	var strNum = frm.val();
	if (isNaN(strNum)){
		alert(strMsg);
		frm.val("");
		frm.focus();
		return false;
	}
	return true;
}

/***********************************************************
 * 
 * @param strDate
 * @returns
 */
function stringToDate(strDate) {
	var strYMD = strDate.split(" ")[0];
	var strHIS = strDate.split(" ")[1];
	var dateForm = strYMD.split("-");
	var hisForm = strHIS.split(":");
	return new Date(dateForm[0], dateForm[1] - 1, dateForm[2], hisForm[0], hisForm[1], hisForm[2]);
}

function chatbotcheck() {
var rtnVal;
var serverId = cookieManager.getCookie("SERVER_ID")
rtnVal="Y";
var data = {serverId:serverId};
	 $.ajax({
			type: "POST",
			url: "/global/chatbotCheck.do",
			data : data,
			dataType : "json",
			async: false,
			success:function(data) {
				
				if(data.code_val=="Y"){
					alert(data.code_nm);
					rtnVal= "Y";
				}else{
					rtnVal="N";
				}
				
			},
			error: function (error){
				alert('Error ==> ' + error);
				return false;
			}
		});
	 return rtnVal; 
}

function chatUrl(){
	var url;
	var serverId = cookieManager.getCookie("SERVER_ID")
	
	var data = {serverId:serverId};
	 $.ajax({
			type: "POST",
			url: "/global/domichatUrlCheck.do",
			data : data,
			dataType : "json",
			async: false,
			success:function(data) {
				url= data.code_val;
			},
			error: function (error){
				alert('Error ==> ' + error);
				return false;
			}
		});
	 return url;
}
