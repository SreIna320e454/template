
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<title>BuyItemConfirm</title>
	<style type="text/css">
	/* ========TAG LAYOUT======== */
	</style>
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm.css">
	<link rel="stylesheet" type="text/css" href="./css/hooter.css">
	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>
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
			<p>BuyItemConfirm</p>
		</div>
		<div>
			<s:form>
				<tr>
					<td>商品名</td>
					<td><s:property value="buyItemInfoMap.buyItem_name" /></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><s:property value="buyItemInfoMap.total_price" /><span>円</span></td>
				</tr>
				<tr>
					<td>購入個数</td>
					<td><s:property value="buyItemInfoMap.count" /><span>個</span></td>
				</tr>
				<tr>
					<td>支払い方法</td>
					<td><s:property value="buyItemInfoMap.pay" /></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('HomeAction')" /></td>
					<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')" /></td>
				</tr>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>