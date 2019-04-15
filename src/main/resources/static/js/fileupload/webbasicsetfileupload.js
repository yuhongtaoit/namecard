var m = new Map();
var cpBsImages = new Array();
var flag = true
$(function() {
		$('#videoContent,#videoImages,#cpBsImage').fileupload({
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
			if(flag){
				var inputName = data.fileInput[0].attributes.name.nodeValue;
				if(inputName=='videoContent'){
					var url = getUrl(data.files[0]);
					$("#video").val(data.files[0].name);
					m.set("video",data.files[0]);
					return;
				}else if(inputName=='videoImages'){
					var url = getUrl(data.files[0]);
					$("#images").val(data.files[0].name);
					m.set("images",data.files[0]);
					$("#videoImagesView").attr("src", url);
				}else if(inputName=='cpBsImage'){
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
				}
				flag=false;
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

function resetFlag(){
	flag=true;
}

function deleteImage(elm){
	$(elm).prev().attr("src", "../images/nopic.jpg");
	$(elm).parent().prev().find("input").val("");
}

function deleteCpBsImage(elm){
	var fileSrc = $(elm).prev().attr("name");
	var cpBsImgArray = toArray($("#cpBsContent").val());
	for(var i=0;i<cpBsImgArray.length;i++){
		if(myTrim(fileSrc) == myTrim(cpBsImgArray[i])){
			cpBsImgArray.splice(i--, 1);
			$(elm).parent().remove();
		}
	}
	$("#cpBsContent").val('['+cpBsImgArray.toString()+']');
	if(cpBsImages!=undefined && cpBsImages.length>0){
		for(var i=0;i<cpBsImages.length;i++){
			if(myTrim(fileSrc) == myTrim(cpBsImages[i].name)){
				cpBsImages.splice(i--, 1);
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
	 var video = $("#video").val();
	 var images = $("#images").val();
	 var cpBsContent = $("#cpBsContent").val();
	 var form = new FormData(document.querySelector("form"));
	 form.delete("videoContent");
	 form.delete("videoImages");
	 form.delete("cpBsImage");
	 if(m.get("video")==undefined && video==''){
		 alert('请上传视频');
		 return;
	 }
	 if(m.get("images")==undefined && images==''){
		 alert('请上传视频封面图片');
		 return;
	 }
	 if(m.get("cpBsImage")==undefined && cpBsContent==''){
		 alert('请上传企业介绍图片');
		 return;
	 }
	 if(m.get("video")!=undefined){
		 form.append("videoKey", m.get("video"));
	 }
	 if(m.get("images")!=undefined){
		 form.append("imagesKey", m.get("images"));
	 }
	 if(cpBsImages!=undefined && cpBsImages.length>0){
		 $.each(cpBsImages, function(i, file){
			 form.append('cpBsFilesKey', file);
		 });
	 }
	 $.ajax({
	     url:"/website/basicSetSave",
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
			             url: "/website/getBasicSet",
			             async:false,
			             success: function(data){
			            	 $("#mainList", window.opener.document).html(data);
			             }
			         });
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