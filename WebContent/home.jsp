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
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/home.css">
	<link rel="stylesheet" type="text/css" href="./css/hooter.css">
</head>
<body vlink="#FFFFFF">
	<div id="header">
		<p><a id="header_logo" href="home.jsp">Antique</a></p>
		<ul>
			<li class="header_position"><s:if test="#session.id == null"><a class="header_icon" href='<s:url action="HomeAction" />'>ログイン</a></s:if></li>
			<li class="header_position"><s:if test="#session.id != null"><a class="header_icon" href='<s:url action="LogoutAction" />'>ログアウト</a></s:if></li>
			<li class="header_position"><s:if test="#session.id != null"><a class="header_icon" href='<s:url action="#" />'>カート</a></s:if></li>
		</ul>
	</div>
	<div id="main">
			<!--
			<s:form action="HomeAction">
				<input id="border" type="image" src="./images/home_icon.png" name="id" alt="商品一覧へ">
			</s:form>
			-->
		<div id="text-center">
			<a href="itemList.jsp"><img src="./images/home_icon.png" alt="商品一覧へ"></a>
			<p><a id="btn_enter" href='itemList.jsp'>ENTER</a></p>
		</div>
	</div>

	<div id="footer">
		<ul>
			<li class="hooter_position"><a class="footer_icon" href='<s:url action="#" />'>利用規約</a></li>
		</ul>
	</div>
</body>
</html>