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
<body link="#2E2E2E" vlink="#2E2E2E">

	<s:include value="header.jsp" />

	<div id="main">
		<div id="top">
			<p>Category：<s:property value="category" /></p>
		</div>

	<!--
				購入画面(購入確認、必要事項入力、購入完了)	5
	△	並び替え カテゴリごとにできるようにする valueはカテゴリIDからやれば？
	○	商品の評価をユーザーから入力できるようにする	2 → ユーザー名を出せるようにする	jsで「この内容でよろしい？」
		→ログインしてる人だけレビューできるように ログインしていない場合は入力フォームも隠す
			何も書いてないと送信できないようにする
			時間も表示したい
		カートの同一商品がまとめられてない 1
		画像の余白
		値段の表示(カンマをつけたい
				ログイン画面から商品詳細へ
	○	商品詳細から商品リストへ
	-->


		<a class="btnClick" href='<s:url action="SortPriceLowAction" />' ><input type="hidden" name="category" value=${category} >価格の安い順(時計だけ)/</a>
		<a class="btnClick" href='<s:url action="SortPriceHighAction"><s:param name="category" value="%{'時計'}"/></s:url>'>価格の高い順(時計だけ)/</a>

	<div id="hoge">
		<s:iterator value="searchItemInfo">
		<ul>
		<li>
		<s:form action="GoItemDetailAction">
			<div id="container">
				<div id="itemImage">
					<a href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}" /></s:url>">
					<img src="<s:property value="itemImage" />" width="60%"></a>
					<input type="hidden" name="itemId" value="<s:property value='itemId'/>" /><s:submit value="テスト" />
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

		<p id="clearFloat" style="clear:left;"><a href='<s:url action="GoItemViewAction" />'>商品一覧に戻る</a></p>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>