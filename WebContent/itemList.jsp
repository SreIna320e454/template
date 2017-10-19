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

		<!-- ここにメニュー（左)を追加
		カート
		購入画面(購入確認、必要事項入力、購入完了)
		検索フォーム
		商品の評価を入力
		カートの商品から商品詳細画面に飛べるようにする	-->
<a  href='<s:url action="SortPriceLowAction"><s:param name="category" value="%{'時計'}"/></s:url>'>価格の安い順(時計だけ)/</a>
<a  href='<s:url action="SortPriceHighAction"><s:param name="category" value="%{'時計'}"/></s:url>'>価格の高い順(時計だけ)/</a>
		<s:iterator id="wrap" value="searchItemInfo">
			<div id="container">
				<div id="itemImage">
					<a href="<s:url action="MoveItemdetailAction"><s:param name="itemId" value="%{itemId}" /></s:url>">
					<img src="<s:property value="itemImage" />" width="60%"></a>
				</div>
				<div id="itemName">
					<s:property value="itemName" />
				</div>
				<s:property value="itemPrice" /><a>円</a>
			</div>
		</s:iterator>

		<a id="clearFloat" href='<s:url action="GoItemViewAction" />'>商品一覧に戻る</a>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>