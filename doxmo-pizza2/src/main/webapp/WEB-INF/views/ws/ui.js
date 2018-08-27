$(document).ready(function(){

	// Gnb(s)
	$('.gnb_menu>li').bind('mouseenter keyup',function(){
		$('.gnb_menu>li').children('a').removeClass('active')
		$(this).children('a').addClass('active')
	})
	$('.gnb_menu>li,.gnb_menu .list_depth2').bind('mouseleave',function(){
		$('.gnb_menu>li').children('a').removeClass('active')
	})
	$('.util_left .btn_menu').click(function(e){
		e.preventDefault()
		$('.whole_menu_area').addClass('active')
	})
	$('.whole_menu_wrap .btn_close2').click(function(e){
		e.preventDefault()
		$('.whole_menu_area').removeClass('active')
	})

	$(window).scroll(function(){
		var sctop = $(window).scrollTop(); //스크롤 위치
		var hdtg = $(".top_bnr.active").next('#wrap').find('#header')
		var cttg = $(".top_bnr.active").next('#wrap').find('#container')
		var top_bnr = $(".top_bnr").height();
		// console.log(top_bnr)
		if(sctop > top_bnr){
			hdtg.addClass('fixed');
			cttg.addClass('fixed');
		}
		else{
			hdtg.removeClass('fixed');
			cttg.removeClass('fixed');
		}
	});

	$('.top_event_wrap .btn_event_close').click(function(e){
		e.preventDefault()
		$(this).parent().parent().removeClass('active')
		$('.main_floating').css('top',275+'px');
	})

	// Gnb(e)

	// Input Clear(s)
	var i_text = $('.form_item>.i_label').next('.i_text');
	$('.form_item>.i_label').css('position','absolute');
	i_text
	.focus(function(){
		$(this).prev('.i_label').addClass('hidden');
	})
	.blur(function(){
		if($(this).val() == ''){
			$(this).prev('.i_label').removeClass('hidden');
		} else {
			$(this).prev('.i_label').addClass('hidden');
		}
	})
	.change(function(){
		if($(this).val() == ''){
			$(this).prev('.i_label').removeClass('hidden');
		} else {
			$(this).prev('.i_label').addClass('hidden');
		}
	})
	.blur();
	// Input Clear(e)

	// Tab(s)
	$('.tab > .btn_tab>li>a').click(function(e){
		e.preventDefault()
		var idx = $(this).parent().index()
		var tcw = $(this).closest('.btn_tab').next('.tab_content_wrap')

		$(this).parent().addClass('active').siblings().removeClass('active')
		tcw.children().eq(idx).addClass('active').siblings().removeClass('active')
	})
	$('.tab > .btn_tab>li>a').on('click',function(e){
		e.preventDefault()
	})
	// Tab(e)

	// Main_customer(s)
	var main_dm_h = $(document).height() //페이지 총 높이
	var main_wd_h = $(window).height() // 브라우저 높이
	var main_sctop = $(window).scrollTop(); //스크롤 위치
	if(main_wd_h <800){
		$(".customer_bottom").show()
	}
	$(window).scroll(function(){
		if(main_wd_h <800){
			if($(this).scrollTop() > 190){
				$(".customer_bottom").fadeOut()
			} else{
				$(".customer_bottom").fadeIn()
			}
		}
	})
	// Main_customer(e)

	// Main_quick(s)
	$(window).scroll(function(){
		var sctop = $(window).scrollTop(); //스크롤 위치
		var floating = $(".main_floating")
		var top_banner = $('.top_event').hasClass('active');

		if(top_banner){
			if(sctop > 400){
				floating.stop().animate(
					{top:sctop+200+"px"},500
				);
			}
			else{
				floating.stop().animate(
					{top:270+"px"},500
				);
			}
		}else if(!top_banner){
			if(sctop > 200){
				floating.stop().animate(
					{top:sctop+150+"px"},500
				);
			}
			else{
				floating.stop().animate(
					{top:150+"px"},500
				);
			}
		}else{
			return;
		}
	});
	// Main_quick(e)

	// Prd_detail(s)
	$(window).scroll(function(){
		var sctop = $(window).scrollTop();
        // var tabtop = $('.prd_detail_view').offset().top - 100;

        // console.log(tabtop)
        if($(this).scrollTop() > 700){
        	$(".prd_order_option").fadeIn()
        } else{
        	$(".prd_order_option").fadeOut()
        }
    })
	// Prd_detail(e)

	// TOP(s)
	$(window).scroll(function(){
		var sctop = $(window).scrollTop();
		if(sctop > 50){
			$('.btn_top').fadeIn()
		} else{
			$('.btn_top').fadeOut()
		}
	})
	// TOP(e)

	// Btn_pop(s)
	$('.join_form .form_pw .btn').on('click',function(){
		var top = $(window).scrollTop();
		$('#userinfo_confirm_change').find('.pop_wrap').css('top',top+30+'px');
	})
	$('.lst_order_guide .btn').on('click',function(){
		var top = $(window).scrollTop();
		$('#quick_order_set').find('.pop_wrap').css('top',top+30+'px');
	})
	$('.withdraw a').on('click',function(){
		var top = $(window).scrollTop();
		$('#userinfo_confirm').find('.pop_wrap').css('top',top+30+'px');
	})
	$('.coupon_publisher .publisher_kind a').on('click',function(e){
		e.preventDefault();
	})
	// Btn_pop(e)



	// Ie8(s)
	var canUse = false;
    var browserName = "Unknown";
    var browserVer = "";
    var browserVerMain = "";

    if (/MSIE/.test(navigator.userAgent)) {
        browserName = "Internet Explorer";
        browserVer = /MSIE ([\d\.]+)\;/.exec(navigator.appVersion)[1];
        browserVerMain = /(\d+)\./.exec(browserVer)[1];

        if(browserVerMain == "8") {
            var main_img = $('.main_visual .slides li img')
            var main_img_num = $('.main_visual .slides li').length;
            for (var i = 0; i < main_img_num; i++) {
                main_img.eq(i).css('margin-left','-'+main_img.eq(i).width()/2+'px')
            }
        }
    }
    // Ie8(e)

    // company_quick(s)
	// $(window).scroll(function(){
	// 	var dm_h = $(document).height();
	// 	var sctop = $(window).scrollTop(); //스크롤 위치
 //        var wd_h = $(window).height();
	// 	var cntop = $('#container').offset().top;
 //        var scrollBottom = dm_h - wd_h - sctop;
	// 	var mvt = 500;
 //        var jop_f = $('.jop_floating')
	// 	var tit_off = $('.jop_area .jop_position').offset().top;
	// 	var tit_off2 = $('.jop_area .jop_position2').offset().top;
	// 	var tit_off3 = $('.jop_area .jop_position3').offset().top;
	// 	var tit_off4 = $('.jop_area .jop_position4').offset().top;
	// 	var tit_off5 = $('.jop_area .jop_position5').offset().top;
	// 	var tit_off6 = $('.jop_area .jop_floating').offset().top;

	// 	if(sctop > 270){
	// 		jop_f.stop().animate(
	// 			{top:sctop-173+"px"},500
	// 		);
	// 	}
	// 	else{
	// 		jop_f.stop().animate(
	// 			{top:0+"px"},500
	// 		);
	// 	};

	// 	if(sctop > 575){
	// 		$('.jop_floating ul li:eq(0)').addClass('active').siblings().removeClass('active')
	// 	};
	// 	if(sctop > 1430){
	// 		$('.jop_floating ul li:eq(1)').addClass('active').siblings().removeClass('active')
	// 	};
	// 	if(sctop > 1850){
	// 		$('.jop_floating ul li:eq(2)').addClass('active').siblings().removeClass('active')
	// 	};
	// 	if(sctop > 2580){
	// 		$('.jop_floating ul li:eq(3)').addClass('active').siblings().removeClass('active')
	// 	};
	// 	if(sctop > 3080){
	// 		$('.jop_floating ul li:eq(4)').addClass('active').siblings().removeClass('active')
	// 	};
	// });
	// $('.jop_floating ul li a').click(function(e){
	// 	e.preventDefault();
	// 	var idx = $(this).parent().index()
	// 	console.log(idx)
	// 	$('.jop_floating ul li:eq('+idx+')').addClass('active').siblings().removeClass('active')

	// 	if (idx == 0) {
	// 		$('html,body').stop().animate(
	// 			{scrollTop:575},500
	// 		);
	// 	}else if(idx == 1){
	// 		$('html,body').stop().animate(
	// 			{scrollTop:1431},500
	// 		);
	// 	}else if(idx == 2){
	// 		$('html,body').stop().animate(
	// 			{scrollTop:1851},500
	// 		);
	// 	}else if(idx == 3){
	// 		$('html,body').stop().animate(
	// 			{scrollTop:2581},500
	// 		);
	// 	}else{
	// 		$('html,body').stop().animate(
	// 			{scrollTop:3081},500
	// 		);
	// 	}
	// })
	// company_quick(s)

})

// Layerpop(s)
function pop_layer_view(layer, st){
	if(st != 'close'){

		$(layer).addClass('open');
		var top = $(window).scrollTop();
		$(layer).find('.pop_wrap').css('top',top+30+'px');
	}else{
		$(layer).removeClass('open');
	}
}
$(document).ready(function(){
	$('.pop_wrap .btn_close').click(function(e){
		e.preventDefault();
		var layer = $(this).closest('.pop_layer').attr('id');
		layer = '#'+layer;
		pop_layer_view(layer,'close');
	});
});
// Layerpop(e)

$(window).load(function() {
	/* Img over(s) */
	$('.lst_prd_type>ul>li>a,.main .customer_info ul li a').bind('mouseenter keyup',function(){
		$(this).find('img').stop().animate({width : '110%',height : '110%', margin : '-5% 0 0 -5%'},200);
	})
	$('.lst_prd_type>ul>li>a,.main .customer_info ul li a').bind('mouseleave',function(){
		$(this).find('img').stop().animate({width : '100%',height : '100%', margin : '0'},200);
	})

	$('.main .main_bnr_wrap .bnr_img a,.main .main_bnr_wrap .bnr_slide .slides li a').bind('mouseenter keyup',function(){
		$(this).find('img').stop().animate({width : '110%',height : '110%', top : '-3%', left : '-3%'},200);
	})
	$('.main .main_bnr_wrap .bnr_img a,.main .main_bnr_wrap .bnr_slide .slides li a').bind('mouseleave',function(){
		$(this).find('img').stop().animate({width : '100%',height : '100%', top : '0%', left : '0%'},200);
	})
	/* Img over(e) */
})

function nextPop(ingredient){
	$('.pop_content2').addClass("active");
	$('.pop_content3').removeClass("active");
	$('.btn_tab7 .ingredient').addClass("active");
	$('.btn_tab7 .allergy').removeClass("active");
}
function nextPop2(ingredient2){
	$('.pop_content3').addClass("active");
	$('.pop_content2').removeClass("active");
	$('.btn_tab7 .allergy').addClass("active");
	$('.btn_tab7 .ingredient').removeClass("active");
}

