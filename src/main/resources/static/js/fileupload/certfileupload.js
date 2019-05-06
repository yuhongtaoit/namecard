var m = new Map();
$(function() {
		$('#certfile').fileupload({
			autoUpload : false,
	        singleFileUploads: false,
			maxNumberOfFiles : 1,//最大上传文件数目
			maxFileSize : 10000000000, // 文件上限1MB
			minFileSize : 100,//文件下限  100b
			messages : {//文件错误信息
				maxFileSize : '文件过大',
				minFileSize : '文件过小'
			}
		})
		//图片添加完成后触发的事件
		.on("fileuploadadd", function(e, data) {
			//获取图片路径并显示
			var inputName = data.fileInput[0].attributes.name.nodeValue;
			if(inputName=='certfile'){
				var url = getUrl(data.files[0]);
				$("#certpath").val(data.files[0].name);
				m.set("certfile",data.files[0]);
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

function save(){
	 var certpath = $("#certpath").val();
	 var form = new FormData(document.querySelector("form"));
	 form.delete("certfile");
	 if(m.get("certfile")==undefined && certpath==''){
		 alert('请上传支付证书');
		 return;
	 }
	 if(m.get("certfile")!=undefined){
		 form.append("certFileKey", m.get("certfile"));
	 }
	 $.ajax({
	     url:"/basic/wxPaySetSave",
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
			             url: "/basic/getWxPaySet",
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