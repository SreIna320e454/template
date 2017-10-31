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
	<title>MyPage</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/myPage.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>

		<s:if test="getMyPageInfo == null">
			<h3>ご購入情報はありません。</h3>
		</s:if>

		<s:else>
			<h3>ご購入情報は以下になります。</h3>
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>購入個数</th>
					<th>支払い方法</th>
					<th>購入日</th>
				</tr>
				<s:iterator value="getMyPageInfo">
					<tr>
						<td><s:property value="itemName" /></td>
						<td><s:property value="totalPrice" /><span>円</span></td>
						<td><s:property value="itemCount" /><span>個</span></td>
						<td><s:property value="pay" /></td>
						<td><s:property value="insertDate" /></td>
					</tr>
				</s:iterator>
				</table>

			<s:form action="MyPageAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete" />
			</s:form>

		</s:else>

		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>

		<div id="text-right">
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
		</div>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>