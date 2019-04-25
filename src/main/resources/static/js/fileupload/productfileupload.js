var m = new Map();
var cpBsImages = new Array();
var cpBsContentImages = new Array();
$(function() {
		$('#cpBsImage,#cpBsContentImage').fileupload({
			autoUpload : false,
	        singleFileUploads: false,
			acceptFileTypes : /(gif|jpe?g|png)$/i,//验证图片格式
			maxNumberOfFiles : 1,//最大上传文件数目
			maxFileSize : 10000000, // 文件上限1MB
			minFileSize : 100,//文件下限  100b
			messages : {//文件错误信息
				acceptFileTypes : '文件类型不匹配',
				maxFileSize : '文件过大',
				minFileSize : '文件过小'
			}
		})
		//图片添加完成后触发的事件
		.on("fileuploadadd", function(e, data) {
			//获取图片路径并显示
			var inputName = data.fileInput[0].attributes.name.nodeValue;
			if(inputName=='cpBsImage'){
				m.set("cpBsImage",data.files);
				var imageHtml="";
				 $.each(data.files, function(index, file) {
					 cpBsImages.push(file);
					 var url = getUrl(file);
					 imageHtml += "<div class='input-group multi-item' style='margin-top:.5em;'>"+
						"<img src="+url+" name="+file.name+" class='img-responsive img-thumbnail'>"+
						"<em class='close' style='position:absolute; top: 0px; right: -14px;' title='删除这张图片' onclick='deleteCpBsImage(this)'>×</em>"+
						"</div>"
					});
				 $("#cpBsImagediv").append(imageHtml);
			}else if(inputName=='cpBsContentImage'){
				m.set("cpBsContentImage",data.files);
				var imageHtml="";
				 $.each(data.files, function(index, file) {
					 cpBsContentImages.push(file);
					 var url = getUrl(file);
					 imageHtml += "<div class='input-group multi-item' style='margin-top:.5em;'>"+
						"<img src="+url+" name="+file.name+" class='img-responsive img-thumbnail'>"+
						"<em class='close' style='position:absolute; top: 0px; right: -14px;' title='删除这张图片' onclick='deleteCpBsContentImage(this)'>×</em>"+
						"</div>"
					});
				 $("#cpBsContentImagediv").append(imageHtml);
			}
			
		})
		//当一个单独的文件处理队列结束触发(验证文件格式和大小)
		.on("fileuploadprocessalways", function(e, data) {
		})
		//上传请求失败时触发的回调函数
		.on("fileuploadfail", function(e, data) {
		})
		//上传请求成功时触发的回调函数
		.on("fileuploaddone", function(e, data) {
			
		})
		//上传请求结束后，不管成功，错误或者中止都会被触发
		.on("fileuploadalways", function(e, data) {
 
		})
		
	});
//获取图片地址
function getUrl(file) {
	var url = null;
	if (window.createObjectURL != undefined) {
		url = window.createObjectURL(file);
	} else if (window.URL != undefined) {
		url = window.URL.createObjectURL(file);
	} else if (window.webkitURL != undefined) {
		url = window.webkitURL.createObjectURL(file);
	}
	return url;
}

function deleteImage(elm){
	$(elm).prev().attr("src", "../images/nopic.jpg");
	$(elm).parent().prev().find("input").val("");
}

function deleteCpBsImage(elm){
	var fileSrc = $(elm).prev().attr("name");
	var cpBsImagesArray = toArray($("#cpBsImg").val());
	for(var i=0;i<cpBsImagesArray.length;i++){
		if(myTrim(fileSrc) == myTrim(cpBsImagesArray[i])){
			cpBsImagesArray.splice(i--, 1);
			$(elm).parent().remove();
		}
	}
	$("#cpBsImg").val('['+topPicsArray.toString()+']');
	if(cpBsImages!=undefined && cpBsImages.length>0){
		for(var i=0;i<topPicImages.length;i++){
			if(myTrim(fileSrc) == myTrim(cpBsImages[i].name)){
				cpBsImages.splice(i--, 1);
				$(elm).parent().remove();
			}
		}
	}
}

function deleteCpBsContentImage(elm){
	var fileSrc = $(elm).prev().attr("name");
	var cpBsContentArray = toArray($("#cpBsContent").val());
	for(var i=0;i<cpBsContentArray.length;i++){
		if(myTrim(fileSrc) == myTrim(cpBsContentArray[i])){
			cpBsContentArray.splice(i--, 1);
			$(elm).parent().remove();
		}
	}
	$("#cpBsContent").val('['+cpBsImgArray.toString()+']');
	if(cpBsContentImages!=undefined && cpBsContentImages.length>0){
		for(var i=0;i<cpBsImages.length;i++){
			if(myTrim(fileSrc) == myTrim(cpBsContentImages[i].name)){
				cpBsContentImages.splice(i--, 1);
				$(elm).parent().remove();
			}
		}
	}
}

function myTrim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}

function myStartWith(val,flag){
	if(val.indexOf(flag)==0){
		return true;
	}else{
		return false;
	}
}

function toArray(val){
	if(myStartWith(val,"[")){
		return val.substring(val.indexOf("[")+1, val.lastIndexOf("]")).split(",");
	}else{
		return val.split(",");
	}
}

Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) return i;
	}
	return -1;
};

Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};

function save(){
	 var topPic = $("#cpBsImg").val();
	 var cpBsImg = $("#cpBsContent").val();
	 var form = new FormData(document.querySelector("form"));
	 form.delete("cpBsImage");
	 form.delete("cpBsContentImage");
	 var cpBsName = $("#cpBsName").val();
	 if(isNull(cpBsName)){
		 alert("产品标题不能为空");
		 return;
	 }
	 var cpBsPrice = $("#cpBsPrice").val();
	 if(isNull(cpBsPrice)){
		 alert("产品价格不能为空");
		 return;
	 }
	 if(!isNull(cpBsPrice) && !checkCash(cpBsPrice)){
		 alert("产品价格必须为数字");
		 return;
	 }
	 if(m.get("cpBsImage")==undefined && topPic==''){
		 alert('请上传产品首页图片');
		 return;
	 }
	 if(m.get("cpBsContentImage")==undefined && cpBsImg==''){
		 alert('请上传产品详情图片');
		 return;
	 }
	 if(cpBsContentImages!=undefined && cpBsContentImages.length>0){
		 $.each(cpBsContentImages, function(i, file){
			 form.append('cpBsContentFilesKey', file);
		 });
	 }
	 if(cpBsImages!=undefined && cpBsImages.length>0){
		 $.each(cpBsImages, function(i, file){
			 form.append('cpBsImgFilesKey', file);
		 });
	 }
	 $.ajax({
	     url:"/product/save",
	     type:"post",
	     data:form,
	     processData:false,
	     enctype : 'multipart/form-data',
	     contentType:false,
	     success:function(data){
	         var json = eval(data);
				if(json.success){
					$.ajax({
			             type: "GET",
			             url: "/product/getProductList",
			             async:false,
			             success: function(data){
			            	 $("#mainList", window.opener.document).html(data);
			             }
			         });
					opener.initPaginator(true);
					alert(json.message);
					window.close();
				}else{
					alert(json.message);
					window.close();
				}
	     },
	     error:function(e){
	         alert("错误！！");
	     }
	 });        
}