var m = new Map();
var personImages = new Array();
$(function() {
		$('#logoimage,#shareimage,#personalimage,#style2bgimage').fileupload({
			autoUpload : false,
	        singleFileUploads: false,
			acceptFileTypes : /(gif|jpe?g|png)$/i,//验证图片格式
			maxNumberOfFiles : 1,//最大上传文件数目
			maxFileSize : 10000000000, // 文件上限1MB
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
			if(inputName=='logoimage'){
				var url = getUrl(data.files[0]);
				$("#cardLogo").val(data.files[0].name);
				m.set("logoimage",data.files[0]);
				$("#logoimageview").attr("src", url);
			}else if(inputName=='shareimage'){
				var url = getUrl(data.files[0]);
				$("#shareImg").val(data.files[0].name);
				m.set("shareimage",data.files[0]);
				$("#shareimageview").attr("src", url);
			}else if(inputName=='personalimage'){
				m.set("personalimage",data.files);
				var personalImageHtml="";
				 $.each(data.files, function(index, file) {
					 personImages.push(file);
					 var url = getUrl(file);
						personalImageHtml += "<div class='input-group multi-item' style='margin-top:.5em;'>"+
						"<img src="+url+" name="+file.name+" class='img-responsive img-thumbnail'>"+
						"<em class='close' style='position:absolute; top: 0px; right: -14px;' title='删除这张图片' onclick='deleteMultiImage(this)'>×</em>"+
						"</div>"
					});
				 $("#personalimagediv").append(personalImageHtml);
			}else if(inputName=='style2bgimage'){
				var url = getUrl(data.files[0]);
				$("#templateImg").val(data.files[0].name);
				m.set("style2bgimage",data.files[0]);
				$("#style2bgimageview").attr("src", url);
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

function deleteMultiImage(elm){
	var fileSrc = $(elm).prev().attr("name");
	var photosArray = toArray($("#photo").val());
	for(var i=0;i<photosArray.length;i++){
		if(myTrim(fileSrc) == myTrim(photosArray[i])){
			photosArray.splice(i--, 1);
			$(elm).parent().remove();
		}
	}
	$("#photo").val(photosArray.toString());
	if(personImages!=undefined && personImages.length>0){
		for(var i=0;i<personImages.length;i++){
			if(myTrim(fileSrc) == myTrim(personImages[i].name)){
				personImages.splice(i--, 1);
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
	 var cardLogo = $("#cardLogo").val();
	 var shareImg = $("#shareImg").val();
	 var templateImg = $("#templateImg").val();
	 var personalimages = $("#photo").val();
	 var form = new FormData(document.querySelector("form"));
	 form.delete("logoimage");
	 form.delete("shareimage");
	 form.delete("personalimage");
	 form.delete("style2bgimage");
	 if(m.get("logoimage")==undefined && cardLogo==''){
		 alert('请上传头像图片');
		 return;
	 }
	 if(m.get("shareimage")==undefined && shareImg==''){
		 alert('请上传分享图片');
		 return;
	 }
	 if(m.get("personalimage")==undefined && personalimages==''){
		 alert('请上传个人图片');
		 return;
	 }
	 if(m.get("style2bgimage")==undefined && templateImg==''){
		 alert('请上传背景图片');
		 return;
	 }
	 if(m.get("logoimage")!=undefined){
		 form.append("logoimageKey", m.get("logoimage"));
	 }
	 if(m.get("shareimage")!=undefined){
		 form.append("shareimageKey", m.get("shareimage"));
	 }
	 if(personImages!=undefined && personImages.length>0){
		 $.each(personImages, function(i, file){
			 form.append('filesKey', file);
		 });
	 }
	 if(m.get("style2bgimage")!=undefined){
		 form.append("style2bgimageKey", m.get("style2bgimage"));
	 }
	 $.ajax({
	     url:"/namecard/save",
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
			             url: "/namecard/getNamecardList",
			             async:false,
			             success: function(data){
			            	 $("#mainList", window.opener.document).html(data);
			             }
			         });
					opener.initPaginator();
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