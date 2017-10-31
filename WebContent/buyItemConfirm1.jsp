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
<title>BuyItemConfirm1</title>
<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm1.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
		<div id="container">

			<div id="top">
				<p>BuyItemConfirm1</p>
			</div>

			<div id="containerLeft">
				<div class="block">カート内容</div>
				<s:if test="%{getCartItemInfo.size() > 0 && #session.login_user_id != null}">
					<s:form action="#">
						<table>
							<thead>
								<tr>
									<th width="50" height="30">商品</th>
									<th width="30" height="30">値段</th>
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
								<th width="350"></th>
								<th><a>合計:</a><s:property value="totalPrice" /><a>円</a></th>
							</tr>
						</table>
					</s:form>
				</s:if>
			</div>

			<div id="containerRight">
				<div class="block">住所・支払い方法選択</div>
				<s:form action="GoBuyItemConfirmNextAction">
					<div id="CustomerInfo">
						<table>
							<thead>
								<tr>
									<th width="70"></th>
									<th></th>
								</tr>
							</thead>
							<tr>
								<td><a>郵便番号</a></td>
								<td>(必須)<input type="text" name="postcodeA" style="width: 23px;" placeholder="000" />-
										  <input type="text" name="PostcodeB" style="width: 32px;" placeholder="0000" />
								<a>例:113-0034</a></td>
							</tr>
							<tr>
								<td><a>住所</a></td>
								<td>(必須)<input type="text" name="prefectures"
									placeholder="都道府県" /><a>例:東京都</a></td>
							</tr>
							<tr>
								<td></td>
								<td>(必須)<input type="text" name="streetAddressA"
									placeholder="市区町村" /><a>例:文京区</a></td>
							</tr>
							<tr>
								<td></td>
								<td>(必須)<input type="text" name="streetAddressB"
									placeholder="住居番号" /><a>例:湯島３丁目２−１２</a></td>
							</tr>
							<tr>
								<td></td>
								<td>(任意)<input type="text" name="streetAddressC"
									placeholder="マンション等名" /><a>例:御茶ノ水天神ビル2F</a></td>
							</tr>
							<tr>
								<td>支払い方法</td>
								<td><input type="radio" name="pay" value="1"
									checked="checked">現金払い(手数料がかかります +350円)</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="radio" name="pay" value="2">クレジットカード</td>
							</tr>
						</table>
						<input type="hidden" name="totalPrice" value=<s:property value="totalPrice" /> />
						<s:submit value="すすむ" />
					</div>
				</s:form>
			</div>

		</div>

	</div>

	<s:include value="footer.jsp" />

</body>

</html>