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
<s:property value="session.get('user_name')" />
<s:property value="session.get('item_id')" />
<s:property value="session.get('item_name')" />
<s:property value="session.get('item_price')" />
<s:property value="session.get('category_name')" />
<s:property value="session.get('category_nametest')" />

			<div id="paddingBottom">

				<s:iterator value="searchCategoryInfo">

					<div id="text-center">
						<ul>
							<li>
							<s:form action="GoItemListAction">
								<div class="sample1">
									<img src="<s:property value="categoryImage" />" width="190px">
									<div class="mask caption">
										<a class="textClick" href='<s:url action="GoItemListAction" />'><s:property value="categoryName"/>
										<input type="hidden" name="categoryName" value="<s:property value='categoryName'/>" /></a>
										<s:submit value="こっち" />
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