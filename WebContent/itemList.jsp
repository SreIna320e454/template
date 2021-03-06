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
	<title>ItemList</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/itemList.css">
</head>
<body link="#2E2E2E" vlink="#2E2E2E">

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>Category：<s:property value="categoryName" /></p>
		</div>

	<a>ソート:</a><a class="btnClick" href="<s:url action="SortPriceAction"><s:param name="categoryName" value="%{categoryName}" /><s:param name="sort" value="%{'low'}" /></s:url>">価格の安い順/</a>
	<a class="btnClick" href='<s:url action="SortPriceAction"><s:param name="categoryName" value="%{categoryName}" /><s:param name="sort" value="%{'high'}" /></s:url>'>価格の高い順</a>


	<div id="hoge">
		<s:iterator value="getItemInfo">
		<ul>
			<li>
			<s:form action="GoItemDetailAction">
				<div id="block">
					<div id="itemImage">
						<a href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}" /><s:param name="categoryName" value="%{categoryName}" /></s:url>">
						<img src="<s:property value="itemImage" />" width="60%"></a>
					</div>
					<div id="itemName">
						<s:property value="itemName" />
					</div>
					<s:property value="itemPrice" /><a>円</a>
				</div>
			</s:form>
			</li>
		</ul>
		</s:iterator>
	</div>

		<p id="clearFloat"><a href='<s:url action="GoItemViewAction" />'>カテゴリ一覧に戻る</a></p>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>