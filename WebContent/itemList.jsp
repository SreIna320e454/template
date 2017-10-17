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
	<title>Category：clock</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/itemList.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>Category：clock</p>
		</div>
<img src="../goodsImages/clock/MoonPhase01.jpg">
		<s:iterator value="searchItemInfo">
			<s:property value="itemName" />
			<img src="<s:property value="itemImage" />">
		</s:iterator>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>