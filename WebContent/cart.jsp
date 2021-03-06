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
<body link="#2E2E2E" vlink="#2E2E2E">

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>Cart</p>
		</div>

	<s:if test="%{getCartItemInfo.size() > 0 && #session.login_user_id != null}">
			<table>
				<thead>
					<tr>
						<th width="100" height="30">イメージ</th>
						<th width="250" height="30">商品</th>
						<th width="100" height="30">値段</th>
						<th width="100" height="30">個数</th>
						<th width="100" height="30">小計</th>
						<th width="70" height="30">数量変更</th>
						<th width="70" height="30">削除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="getCartItemInfo">
						<tr>
							<td>
								<a href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}" /><s:param name="categoryName" value="%{categoryName}" /></s:url>">
								<img src="<s:property value="itemImage" />" width="60px"></a>
							</td>
							<td align="left">
								<a id="textDeco" href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}" /><s:param name="categoryName" value="%{categoryName}" /></s:url>">
								<s:property value="itemName" />
								</a>
							</td>
							<td>
								<s:property value="itemPrice" /><a>円</a>
							</td>
							<td>
								<s:property value="itemCount" /><a>個</a>
							</td>
							<td>
								<s:property value="subtotal" /><a>円</a>
							</td>
							<td>
								<s:form action="CartItemUpdateAction">
								<input type="text" name="itemCount" size="1" />
								<input type="hidden" name="itemId" value=${itemId} />
								<s:submit value="更新" />
								</s:form>
							</td>
							<td><a href="<s:url action='CartItemDeleteAction'><s:param name="itemId" value="%{itemId}" /></s:url> ">削除</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<div class="messageInfo">
				<a>合計:</a><s:property value="totalPrice" /><a>円</a>
			</div>

		<s:form action="CartItemDeleteAction">
			<input type="hidden" name="deleteAll" value="deleteAll" />
 			<s:submit value="全て削除" />
		</s:form>

		<s:form action="GoBuyItemConfirm1Action">
			<input type="hidden" name="totalPrice" value=${totalPrice} />
			<s:submit value="購入画面へ進む" />
		</s:form>
	</s:if>

	<s:else>
		<div class="messageInfo">
			<p>カートに商品がありません</p>
		</div>
	</s:else>

	</div>

	<s:include value="footer.jsp" />

</body>
</html>