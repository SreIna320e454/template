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
	<title>ItemView</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/itemView.css">
</head>
<body link="#FFFFFF" vlink="#FFFFFF">

	<s:include value="header.jsp" />

		<div id="main">
			<div id="top">
				<p>ItemView</p>
			</div>

<s:property value="session.get('login_user_id')" />
<s:property value="session.get('item_id')" />
<s:property value="session.get('buyItem_name')" />
<s:property value="session.get('buyItem_price')" />
<s:property value="session.get('category')" />
<s:property value="session.get('login_user_id')" />

		<div id="paddingBottom">
			<div id="text-center">
				<ul>
					<li>
						<div class="sample1">
							<img src="./images/goods_icon2.jpg" width="190px">
							<div class="mask caption">
								<a class="textClick" href='<s:url action="GoItemListAction"><s:param name="category" value="%{'時計'}"/></s:url>'>時計</a>
							</div>
						</div></li>
					<li>
					<li>
						<div class="sample1">
							<img src="./images/goods_icon1.jpg" width="190px">
							<div class="mask caption">
								<a class="textClick" href='<s:url action="GoItemListAction"><s:param name="category" value="%{'雑貨'}"/></s:url>'>雑貨</a>
							</div>
						</div></li>
					<li>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon3.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>家具(未実装)</a>
								</div>
							</div>
						</s:form></li>
				</ul>
			</div>
				<div id="text-center">
				<ul>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon4.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
					<li>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon5.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
					<li>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon6.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
				</ul>
			</div>
			<div id="text-center">
				<ul>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon7.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
					<li>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon8.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
					<li>
					<li>
						<s:form action="#">
							<div class="sample1">
								<img src="./images/goods_icon9.jpg" width="190px">
								<div class="mask caption">
									<a class="textClick" href='<s:url action="#" />'>(未実装)</a>
								</div>
							</div>
						</s:form></li>
				</ul>
			</div>
		</div>
		</div>

	<s:include value="footer.jsp" />

</body>
</html>