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
	<meta charset="utf-8">
	<title>BuyItemComplate画面</title>

	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/buyItemComplate.css">
	<link rel="stylesheet" type="text/css" href="./css/hooter.css">
</head>
<body>
	<div id="header">
		<p><a id="header_logo" href="home.jsp">Antique</a></p>
		<ul>
			<li class="header_position"><s:if test="#session.id == null"><a class="header_icon" href='<s:url action="HomeAction" />'>ログイン</a></s:if></li>
			<li class="header_position"><s:if test="#session.id != null"><a class="header_icon" href='<s:url action="LogoutAction" />'>ログアウト</a></s:if></li>
			<li class="header_position"><a class="header_icon" href='<s:url action="#" />'>カート</a></li>
		</ul>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItemComplate</p>
		</div>
		<div>
			<p>購入手続きが完了致しました。</p>
			<div>
				<a href='<s:url action="MyPageAction" />'>マイページ</a><span>から購入履歴の確認が可能です。</span>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>

