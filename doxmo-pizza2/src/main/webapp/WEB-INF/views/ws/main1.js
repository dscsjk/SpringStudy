/**
 * @메인배너
 */
if(typeof CNTLib === 'undefined'){
	CNTLib = {};
}

CNTLib.Main = function(el,pt){
	apiutil.log("create");
	this.$el = $(el);
	this.pagetype = pt; //pt list = "목록" : search "매장" 
	this.init();
	
};
CNTLib.Main.prototype ={
		init : function(){
			apiutil.log("init");
			this.initVar();
			this.bindEvent();
		},
		initVar : function(){
			apiutil.log("initVar:"+this.pagetype);
			if(this.pagetype == "main"){
				this.htLayer = {
						list : this.$el.find(".roll_visual:first")						
				};
				this.htTopLayer = $('#intro_popup');
				this.tpl = {
						nodata : "검색된 게시물이 없습니다.",
						loading : "<li><p align='center'><img src='/resources/images/common/ajax-loader.gif'/></p></li>",
						list_empty : "<li>등록된 게시물이 없습니다.</li>",
						list_item : "<li><a href=\"{=LINK}\"><img src=\"{=IMG}\" alt=\"{=SUBJECT}\" class=\"pconly\" /><img src=\"{=IMG_M}\" alt=\"\" class=\"monly\" /></a></li>"
				}
			}
			
			
			
			this.api = apiutil.sApi;
			this.thispage = 1;
		},
		bindEvent : function(){
			apiutil.log("bindEvent:"+this.pagetype);			
			if(this.pagetype == "main"){	
				apiutil.log("list event");
				this.htLayer.list.find('button').bind('click',$.proxy(this.onClick,this));				
				//this.getBannerList(this.thispage);	
				//this.getTopBannerList();
			}
			
		},
		getBannerList : function(pageno){
			this.thispage = pageno;
			apiutil.log("getList");
			var param = [];
			param.push("id=Banner");
			param.push("ac=select");			
			this.htLayer.list.html(this.tpl.loading);			
			param.push("page="+this.thispage);
			param.push("orderby=sortkey");		
			param.push("display=Y");
			apiutil.log(param.join('&'));
			
			var self = this;
			$.ajax({
				type: 'get',
				url : this.api,
				data : param.join('&'),
				dataType : 'jsonp',
				contentType:'application/json; charset=utf-8',
				error:function(){
					//apiutil.log('에러:주문 데이터 송수신에 문제가 있습니다.');
				},
				success: function(data){
					
					if(data != null){
						try {
							var ev = data;	
							self.paintBannerList(ev);
						} catch(e){
							alert(e);
						}
					} else {
						this.htLayer.list.html(this.tpl.list_empty);
					}				
				}
			});
		}, 
		paintBannerList:function(data){
			apiutil.log(data);
			if(this.pagetype == "main"){	
				this.htLayer.list.html("");
				for (var i = 0; i < data.length; i++){					
					var ev = data[i];
					if(ev.seq == "") {
						this.htLayer.list.html(this.tpl.list_empty);						
					} else {
						this.htLayer.list.append(this.tpl.list_item.replace(/{=LINK}/g,ev.etc4)
							.replace(/{=SUBJECT}/g,ev.subject)
							.replace(/{=IMG}/g,ev.etc6)
							.replace(/{=IMG_M}/g,ev.etc6)
							);
					}
					
				}
				//슬라이더 셋팅
				$('.roll_visual').bxSlider({
				  auto: true,
				  speed:1400
				});
			}
		}
		/*
		getTopBannerList : function(){			
			apiutil.log("getList");
			var param = [];
			param.push("id=TopBanner");
			param.push("ac=selecttop1");			
			
			apiutil.log(param.join('&'));
			var self = this;
			$.ajax({
				type: 'get',
				url : this.api,
				data : param.join('&'),
				dataType : 'jsonp',
				contentType:'application/json; charset=utf-8',
				error:function(){
					//apiutil.log('에러:주문 데이터 송수신에 문제가 있습니다.');
				},
				success: function(data){
					apiutil.log(data);
					if(data != null){
						try {
							var ev = data[0];
							if(ev.seq != '') {
								var  target = "";
								if(ev.link2 == "Y"){
									target = " target='_blank' ";
								}
								var html =	"<div class=\"ly_inner\"> ";
								html += " <a href=\"{=URL}\" "+target+"><img src=\"{=IMGURL}\" class=\"pconly\"  alt=\"{=SUBJECT}\" /></a>" ;
								html += " <a href=\"{=URL}\" "+target+"><img src=\"{=IMGURL_M}\" class=\"monly\"  alt=\"{=SUBJECT}\" /></a> ";
								html += "<div class=\"ui_box\">";
								html += "	<label><input type=\"checkbox\" id=\"intro_check\" /><span>오늘하루 보지않기</span></label>";
								html += "	<a href=\"#none\" class=\"intro_close\">닫기</a>";
								html += "	</div>";
								html += "</div>";
								
								self.htTopLayer.html(html.replace(/{=URL}/g,ev.link1).replace(/{=SUBJECT}/g,ev.subject).replace(/{=IMGURL}/g,ev.etc5).replace(/{=IMGURL_M}/g,ev.etc6));
								
								var intro = $('#intro_popup');
								var close = $(".intro_close");
								var durian = 500;
								var easing = 'easeOutQuart';
								
								if($.cookie("intro") == "done"){
									intro.slideUp(durian);
									$('body').removeClass('in_intro');
									$('.quick_order').css('top','100px');
								} else {
									intro.slideDown(durian);
									$('body').addClass('in_intro');
								}
								
								close.click(function(){
								   intro.animate({height : 0}, durian , easing , function(){
								   //setQuickPosition();
									  if (document.getElementById('intro_check').checked)
									   {
										   $.cookie("intro","done",1);
									   }
								   })
									 $('.quick_order').css('top','100px');
								})
							} else {
								self.htTopLayer.hide();
							}
							
						} catch(e){
							alert(e);
						}
					} else {
						self.htLayer.list.html(this.tpl.list_empty);
					}				
				}
			});
			
		}*/
};