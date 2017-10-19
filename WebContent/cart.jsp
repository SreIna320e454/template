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
	<title>Cart</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/cart.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>

		<s:iterator value="cartList">
			<s:property value="itemName" />
		</s:iterator>

		<table>
			<tr>
				<th width="100" height="30">イメージ</th>
				<th width="250" height="30">商品</th>
				<th width="100" height="30">値段</th>
				<th width="100" height="30">個数</th>
				<th width="70" height="30">変更</th>
				<th width="70" height="30">削除</th>
			</tr>
		</table>

		<s:submit value="購入"/>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>