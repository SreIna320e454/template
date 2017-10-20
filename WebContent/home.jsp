<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/home.css">

</head>
<body vlink="#FFFFFF">

	<s:include value="header.jsp" />

	<div id="main">
			<!--
			<s:form action="HomeAction">
				<input id="border" type="image" src="./images/home_icon.png" name="id" alt="商品一覧へ">
			</s:form>
			-->
			<s:property value="#session.loginUser"/>
		<div id="text-center">
			<a href="itemView.jsp"><img src="./images/home_icon.png" alt="商品一覧へ"></a>
			<p><a id="btn_enter" href='itemView.jsp'>ENTER</a></p>
		</div>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>