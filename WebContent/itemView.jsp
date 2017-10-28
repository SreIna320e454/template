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

			<div id="paddingBottom">

				<s:iterator value="getCategoryInfo">

					<div id="text-center">
						<ul>
							<li>
							<s:form action="GoItemListAction">
								<div class="ornament">
									<img src="<s:property value="categoryImage" />" width="190px">
									<div class="mask caption">
										<a href="<s:url action="GoItemListAction">
										<s:param name="categoryName" value="%{categoryName}" /></s:url>">
										<s:property value="categoryName" /></a>
									</div>
								</div>
							</s:form>
							</li>
						</ul>
					</div>
				</s:iterator>

			</div>
		</div>

	<s:include value="footer.jsp" />

</body>
</html>