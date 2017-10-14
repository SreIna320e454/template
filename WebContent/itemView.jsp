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
	<title>itemView画面</title>
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/itemView.css">
	<link rel="stylesheet" type="text/css" href="./css/hooter.css">
</head>
<body vlink="#FFFFFF">
	<div id="header">
		<p id="header_logo">Antique</p>
		<ul>
			<li class="header_position"><s:if test="#session.id == null"><a class="header_icon" href='<s:url action="HomeAction" />'>ログイン</a></s:if></li>
			<li class="header_position"><s:if test="#session.id != null"><a class="header_icon" href='<s:url action="LogoutAction" />'>ログアウト</a></s:if></li>
			<li class="header_position"><a class="header_icon" href='<s:url action="#" />'>カート</a></li>
		</ul>
	</div>
		<div id="main">
			<div id="top">
				<p>itemView</p>
			</div>

			<div id="text-center">
			<ul>
				<li>
					<s:form action="HomeAction">
						<div class="sample1">
							<img src="./images/goods_icon1.jpg" width="200px">
							<div class="mask">
							<div class="caption"><a href='<s:url action="HomeAction" />'>雑貨</a></div>
							</div>
						</div>
					</s:form></li>
				<li>
				<li>
					<s:form action="HomeAction">
						<div class="sample1">
							<img src="./images/goods_icon2.jpg" width="200px">
							<div class="mask caption">
								<a href='<s:url action="HomeAction" />'>時計</a>
							</div>
						</div>
					</s:form></li>
				<li>
				<li>
					<s:form action="HomeAction">
						<div class="sample1">
							<img src="./images/goods_icon3.jpg" width="200px">
							<div class="mask caption">
								<a href='<s:url action="HomeAction" />'>家具</a>
							</div>
						</div>
					</s:form></li>
			</ul>
			</div>
		</div>

	<div id="footer">
		<ul>
			<li class="hooter_position"><a class="footer_icon" href='<s:url action="#" />'>利用規約</a></li>
		</ul>
	</div>
</body>
</html>