<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, minimum-scale=1,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="renderer" content="webkit">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="email=no">
<title></title>
</head>
<body>
	<div>
	<form id="f">
		<input type="file" name="license" id="license" />
	</form>
	<input type="button" value="上传证书" onclick="importExcel();" />
	</div>

</body>
<script type="text/javascript">
var ctx = "${ctx}";
function importExcel() {
	var form = new FormData(document.getElementById("f"));
	$.ajax({
		url : ctx + "/uploadLicense/upload",
		type : "post",
		data : form,
		processData : false,
		contentType : false,
		error : function(request) {
			alert('系统错误');
		},
		success : function(data) {
			alert(data.msg);
		}
	});
}
</script>
</html>