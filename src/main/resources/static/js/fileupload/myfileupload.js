var m = new Map();
$(function() {
		$('#logoimage,#shareimage,#personalimage,#style2bgimage').fileupload({
			//url : '/FileTest/upload',//请求发送的目标地址
			//Type : 'POST',//请求方式 ，可以选择POST，PUT或者PATCH,默认POST
			autoUpload : false,
	        singleFileUploads: false,
			acceptFileTypes : /(gif|jpe?g|png)$/i,//验证图片格式
			maxNumberOfFiles : 1,//最大上传文件数目
			maxFileSize : 1000000, // 文件上限1MB
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
				m.set("logoimage",data.files[0]);
				$("#logoimageview").attr("src", url);
			}else if(inputName=='shareimage'){
				var url = getUrl(data.files[0]);
				m.set("shareimage",data.files[0]);
				$("#shareimageview").attr("src", url);
			}else if(inputName=='personalimage'){
				m.set("personalimage",data.files);
				var personalImageHtml="";
				 $.each(data.files, function(index, file) {
					 var url = getUrl(file);
						personalImageHtml += "<div class='input-group multi-item' style='margin-top:.5em;'>"+
						"<img src="+url+" class='img-responsive img-thumbnail'>"+
						"<em class='close' style='position:absolute; top: 0px; right: -14px;' title='删除这张图片' onclick='deleteMultiImage(this)'>×</em>"+
						"</div>"
					});
				 $("#personalimagediv").append(personalImageHtml);
			}else if(inputName=='style2bgimage'){
				var url = getUrl(data.files[0]);
				m.set("style2bgimage",data.files[0]);
				$("#style2bgimageview").attr("src", url);
			}
//			//绑定开始上传事件
//			$('#save').click(function() {
//				jqXHR = data.submit();
//				//解绑，防止重复执行
//				$("#save").off("click"); 
//			})
			
		})
		//当一个单独的文件处理队列结束触发(验证文件格式和大小)
		.on("fileuploadprocessalways", function(e, data) {
			//获取文件
			file = data.files[0];
			//获取错误信息
			if (file.error) {
			}
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
 
		
		//手动验证
		function validate(file) {
			//获取文件名称
			var fileName = file.name;
			//验证图片格式
			if (!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(fileName)) {
				console.log("文件格式不正确");
				return true;
			}
			//验证excell表格式
			/*  if(!/.(xls|xlsx)$/.test(fileName)){
			 	alert("文件格式不正确");
			 	return true;
			 } */
 
			//获取文件大小
			var fileSize = file.size;
			if (fileSize > 1024 * 1024) {
				alert("文件不得大于一兆")
				return true;
			}
			return false;
		}
 
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
		
	});

function deleteImage(elm){
	$(elm).prev().attr("src", "../images/nopic.jpg");
	$(elm).parent().prev().find("input").val("");
}

function deleteMultiImage(elm){
	$(elm).parent().remove();
}

function save(){
	 var form = new FormData(document.querySelector("form"));
	 form.delete("logoimage");
	 form.delete("shareimage");
	 form.delete("personalimage");
	 form.delete("style2bgimage");
	 form.append("logoimage", m.get("logoimage"));
	 form.append("shareimage", m.get("shareimage"));
//	 form.append("personalimage", m.get("personalimage"));
	 $.each(m.get("personalimage"), function(i, file){
		 form.append('files', file);
	 });
	 form.append("style2bgimage", m.get("style2bgimage"));
	 $.ajax({
	     url:"/namecard/save",
	     type:"post",
	     data:form,
	     processData:false,
	     contentType:false,
	     success:function(data){
	         console.log("over..");
	     },
	     error:function(e){
	         alert("错误！！");
	     }
	 });        
}