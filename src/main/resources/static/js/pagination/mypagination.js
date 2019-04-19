function init(flag) {
	$("#pagination").pagination({
		dataSource: function(done){
			$.ajax({
			    type : "GET",
			    url : "/product/getProductTotal",
				dataType : "json",
				success : function(data) {
					var json = eval(data);
					if(json.success){
						var total = json.message;
						var result = [];
						
						for(var i = 1; i <= total; i++){
							result.push(i);
						}
						
						done(result);
					}
				}
		  	});
	        
	    },
		showPrevious:true,
		showNext:true,
		prevText:'上一页', // "前一页"分页按钮上显示的文字
		nextText:'下一页', // "后一页"分页按钮上显示的文字
		pageRange: 3,
		autoHidePrevious:true,
		autoHideNext:true,
		pageSize: 2,
		callback:function (response, pagination) {
			$.ajax({
			    type : "GET",
			    url : "/product/getProductList",
				success : function(data) {
					$('#mainList').html(data);
				}
		  	});
	    } // 点击分页按钮的回调函数
	});
}