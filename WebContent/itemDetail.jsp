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
	<title>ItemDetail</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/itemDetail.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">

		<div id="top">
			<p>ItemDetail</p>
		</div>
		<s:iterator value="detailItemInfo">
			<img src="<s:property value="itemImage" />" width="300px">
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="itemName" /><br>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="itemPrice" /><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>購入個数</span>
						</td>
						<td>
						<select name="itemCount">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
							</select>
						</td>
					</tr>
				<!--<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
	  						<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr>-->
				</table>
				<s:form action="AddToCartAction">
					<input type="hidden" name="itemId" value=${itemId} />
					<s:submit value="カートに入れる"/>
				</s:form>
		</s:iterator>

------------------------------------------------------------------------------------------------------------------------------------------
<p>商品レビュー</p>
		<s:form action="MoveItemdetailAction">
				<s:textfield name="itemComment" value="%{itemComment}" />
				<input type="hidden" name="itemId" value=${itemId} />
				<s:submit value="レビューをする" />
			</s:form>
------------------------------------------------------------------------------------------------------------------------------------------
<p>レビュー一覧</p>
			<s:iterator value="comment">
				<div id="container">
					<s:property value="itemComment" />
				</div>
			</s:iterator>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>