var ajaxBasketRequest = null;
var addCommonBasket = function(params, callback, returnUrl) {
	if(ajaxBasketRequest != null) {
		alert("ó������ �۾��� �ֽ��ϴ�. ����Ŀ� �ٽ� �õ��� �ּ���.");
		return;
	}

	var basketInitMsg = getBasketInitMsg("O");

	if(basketInitMsg == "" || confirm(basketInitMsg)){
		//alert(p_idx);
		$.ajax({
			type: "POST",
			url: "/basket/basketProc",
			data: params,
			success:function(data) {
				if(data.resultData.result != "success") {
					alert(data.resultData.msg);
					if(data.resultData.result == "needreload")
						location.reload();
				} else {
					//TODO ���μ������� �߰� - ���弱�� ���� ��� ��� ���� ������������ �̵�
					//alert(data.resultData.branch_code);

					if(data.resultData.branch_code == "") { // ���弱�� ���� ��� ��� ���� ������������ �̵�
						location.href = "/basket/branch?returnUrl="+encodeURIComponent(returnUrl);
					}else{
						var strBasketCnt = $(".btn_cart span.cart_count").text();
						var basketCnt = 0;

						if($(".btn_cart span.cart_count").text() == "") {
							basketCnt = parseInt(params.goods_count);
						} else {
							basketCnt = parseInt($(".btn_cart span.cart_count").text()) + parseInt(params.goods_count);
						}

						if(strBasketCnt == "") {
							basketCnt = parseInt(params.goods_count);
						}
						$(".btn_cart span.cart_count").text(basketCnt);

						if(jQuery.isFunction(callback))
							callback();
						$('.pop_toast').fadeIn(200, function() {
							window.setTimeout(function(){$('.pop_toast').fadeOut(200);}, 500);
						});
					}
				}
			},
			error: function (error){
				alert("��ٱ��� ����.");
				location.reload();
			},
			beforeSend: function() {
				ajaxBasketRequest = "Y";
				$("#defaultLoading").show();
		    },
		    complete: function() {
		    	ajaxBasketRequest = null;
		    	$("#defaultLoading").hide();
		    }
		});
	}

};


var addBasket = function(action_code, goods_code, goods_count, toppingStr, p_idx, callback, returnUrl) {
	var param = {
		action_code : action_code
		, goods_code : goods_code
		, goods_count : goods_count
		, toppingStr : toppingStr
		, p_idx : p_idx
	};

	addCommonBasket(param, callback, returnUrl);
};

var addEcoupon = function(action_code, goods_code, goods_count, dc_input_code, dc_info2, dc_info3, toppingStr, p_idx, callback) {
	var param = {
		action_code : action_code
		, goods_code : goods_code
		, goods_count : goods_count
		, dc_input_code : dc_input_code
		, dc_info2 : dc_info2
		, dc_info3 : dc_info3
		, toppingStr : toppingStr
		, p_idx : p_idx
	};
	addCommonBasket(param, callback, "/ecoupon/index");
};


var addVoucherBasket = function(orderGubun, code){
	var basketInitMsg = getBasketInitMsg(orderGubun);

	if(basketInitMsg == "" || confirm(basketInitMsg)){
		var param = {
			actionCode : 'add'
			, orderGubun : orderGubun
			, code : code
			, pcnt : $("#"+code+"_qty").val()
		};
		voucherBasketProc(param);
	}
};

var changeVoucherBasket = function(orderGubun, code){
	var param = {
		actionCode : 'change'
		, orderGubun : orderGubun
		, code : code
		, pcnt : $("#"+code+"_qty").val()
	};
	voucherBasketProc(param);
};

var removeVoucherBasket = function(orderGubun, code){
	if(confirm("�ش� ��ǰ�� ��ٱ��Ͽ��� �����Ͻðڽ��ϱ�?")){
		var param = {
			actionCode : 'change'
			, orderGubun : orderGubun
			, code : code
			, pcnt : 0
		};
		voucherBasketProc(param);
	}
};

var voucherBasketProc = function(param){
	if(ajaxBasketRequest != null) {
		alert("ó������ �۾��� �ֽ��ϴ�. ����Ŀ� �ٽ� �õ��� �ּ���.");
		return;
	}
	$.ajax({
		type: "POST",
		url: "/voucher/basket/basketProc",
		data: param,
		success:function(data) {
			if(data.resultData.result != "success") {
				alert(data.resultData.msg);
				location.reload();
			} else {
				if(param.actionCode == "add"){
					$(".btn_cart span.cart_count").text(parseInt(data.resultData.goodsCnt));
					$('.pop_toast').fadeIn(200, function() {
						window.setTimeout(function(){$('.pop_toast').fadeOut(200);}, 500);
					});

				}else{
					location.reload();
				}
			}
		},
		error: function (error){
			alert("��ٱ��� ����.");
			location.reload();
		},
		beforeSend: function() {
			ajaxBasketRequest = "Y";
			$("#defaultLoading").show();
	    },
	    complete: function() {
	    	ajaxBasketRequest = null;
	    	$("#defaultLoading").hide();
	    }
	});
}

var getBasketInitMsg = function(orderGubun){
	var msg = "";

	$.ajax({
		type: "POST",
		url: "/basket/basket_type_info",
		async: false,
		success:function(data) {
			if(orderGubun != data.resultData.basketType && data.resultData.goodsCnt > 0){
				if(orderGubun == "J"){
					msg = "������ǰ���� ��ٱ��Ͽ� �߰��Ͻ� ���, ��ٱ��� ���� �Ϲ� ��ǰ, ���θ� ����, ����� ��ǰ���� ��� �����˴ϴ�. ����Ͻðڽ��ϱ�?";
				}else if(orderGubun == "M"){
					msg = "����ϻ�ǰ���� ��ٱ��Ͽ� �߰��Ͻ� ���, ��ٱ��� ���� �Ϲ� ��ǰ, ���θ� ����, ������ǰ���� ��� �����˴ϴ�. ����Ͻðڽ��ϱ�?";
				}else{
					msg = "��ǰ�� ��ٱ��Ͽ� �߰��Ͻ� ���, ��ٱ��� ���� ���θ� ����, ���� ��ǰ��, ����� ��ǰ���� ��� �����˴ϴ�. ����Ͻðڽ��ϱ�?";
				}
			}
		},
		error: function (error){
		}
	});

	return msg;
}