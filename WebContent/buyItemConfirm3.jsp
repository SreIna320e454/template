
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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BuyItemConfirm3</title>
<style type="text/css">
/* ========TAG LAYOUT======== */
</style>
<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm3.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
		<div id="container">
			<div id="top">
				<p>BuyItemConfirm3</p>
			</div>
			<div id="containerLeft">
				<div class="block">カート内容</div>
				<s:if test="%{getCartItemInfo.size() > 0 && #session.login_user_id != null}">
					<s:form action="#">
						<table>
							<thead>
								<tr>
									<th width="100" height="30">商品</th>
									<th width="50" height="30">値段</th>
									<th width="30" height="30">個数</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="getCartItemInfo">
									<tr>
										<td align="left"><a><s:property value="itemName" /></a></td>
										<td><s:property value="itemPrice" /><a>円</a></td>
										<td><s:property value="itemCount" /><a>個</a></td>
									</tr>
								</s:iterator>

							</tbody>
						</table>
						<table>
							<tr>
								<td>小計:<s:property value="totalPrice" /></td>
								<td>手数料:350円</td>
							</tr>
						</table>
					</s:form>
				</s:if>

			</div>
			<div id="containerRight">
				<div class="block">住所・支払い方法選択</div>
					<div id="CustomerInfo">
						<table>
							<thead>
								<tr>
									<th width="70"></th>
									<th></th>
								</tr>
							</thead>
							<s:iterator value="getUserInfo">
							<tr>
								<td><a>郵便番号</a></td>
								<td><s:property value="postCodeA" />-<s:property value="postCodeB" /></td>
							</tr>
							<tr>
								<td><a>住所</a></td>
								<td><s:property value="prefectures" /></td>
							</tr>
							<tr>
								<td></td>
								<td><s:property value="streetAddressA" /></td>
							</tr>
							<tr>
								<td></td>
								<td><s:property value="streetAddressB" /></td>
							</tr>
							<tr>
								<td></td>
								<td><s:property value="streetAddressC" /></td>
							</tr>
							</s:iterator>
						</table>
					</div>
			</div>
		</div>
		<div style="clear:left;">
			<a><font size="6">合計:<s:property value="totalPriceAddCommission" />円</font></a>
				<input type="hidden" name="subtotal" value=<s:property value="subtotal" /> />
				<input type="hidden" name="pay" value=<s:property value="pay" /> />
			<s:submit value="この内容で購入する" />
		</div>
	</div>

			<s:include value="footer.jsp" />
</body>

</html>