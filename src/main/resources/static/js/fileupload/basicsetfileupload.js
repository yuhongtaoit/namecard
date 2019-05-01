var m = new Map();
var personImages = new Array();
var flag=true;
$(function() {
		$('#logoimage,#shopBgImage').fileupload({
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
			if(flag){
				//获取图片路径并显示
				var inputName = data.fileInput[0].attributes.name.nodeValue;
				if(inputName=='logoimage'){
					var url = getUrl(data.files[0]);
					$("#companyLogo").val(data.files[0].name);
					m.set("logoimage",data.files[0]);
					$("#logoimageview").attr("src", url);
				}else if(inputName=='shopBgImage'){
					var url = getUrl(data.files[0]);
					$("#shopBg").val(data.files[0].name);
					m.set("shopBgImage",data.files[0]);
					$("#shopBgImageView").attr("src", url);
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
	 var companyLogo = $("#companyLogo").val();
	 var shopBg = $("#shopBg").val();
	 var form = new FormData(document.querySelector("form"));
	 form.delete("logoimage");
	 form.delete("shopBgImage");
	 var companyName = $("#companyName").val();
	 if(isNull(companyName)){
		 alert("公司名称不能为空");
		 return;
	 }
	 var companyTel = $("#companyTel").val();
	 if(!checkPhone(companyTel) && !checkTel(companyTel)){
		 alert('请填写正确的电话号码');
		 return;
	 }
	 var num = $("#num").val();
	 if(!isNull(num) && !checkNum(num)){
		 alert("名片个数必须为整数");
		 return;
	 }
	 var redpackMin = $("#redpackMin").val();
	 var redpackMax = $("#redpackMax").val();
	 if(!isNull(redpackMin) && !checkCash(redpackMin)){
		 alert("红包金额必须为数字");
		 return;
	 }
	 if(!isNull(redpackMax) && !checkCash(redpackMax)){
		 alert("红包金额必须为数字");
		 return;
	 }
	 if(m.get("logoimage")==undefined && companyLogo==''){
		 alert('请上传公司logo');
		 return;
	 }
	 if(m.get("shopBgImage")==undefined && shopBg==''){
		 alert('请上传商城背景图片');
		 return;
	 }
	 if(m.get("logoimage")!=undefined){
		 form.append("logoimageKey", m.get("logoimage"));
	 }
	 if(m.get("shopBgImage")!=undefined){
		 form.append("shopBgImageKey", m.get("shopBgImage"));
	 }
	 $.ajax({
	     url:"/basic/basicSetSave",
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
			             url: "/basic/getBasicSet",
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