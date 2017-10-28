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

	<!--
		購入画面(購入確認、必要事項入力、購入完了)	5
		購入完了でテーブルに格納するもの→購入日、値段、支払方法、ユーザーID、カートID
		都道府県は選択式で ゆうびんばんごうは１つにまとめたい
		sql上書き
		テーブルに購入確定を追加
		値段合計もDBに格納
		連続で送信できないように→buyitemcomplate にヒントが
		カートの同一商品がまとめられてない 1
		値段の表示(カンマをつけたい
															ログイン画面から商品詳細へ(ifでできる？）
	 	小計
	 	多重ログイン禁止
	 	アカウント作成アクションを確認
	-->

	<a>ソート:</a><a class="btnClick" href="<s:url action="SortPriceLowAction"><s:param name="categoryName" value="%{categoryName}" /></s:url>">価格の安い順/</a>
	<a class="btnClick" href='<s:url action="SortPriceHighAction"><s:param name="categoryName" value="%{categoryName}" /></s:url>'>価格の高い順</a>


	<div id="hoge">
		<s:iterator value="getItemInfo">
		<ul>
			<li>
			<s:form action="GoItemDetailAction">
				<div id="container">
					<div id="itemImage">
						<a href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}" /><s:param name="categoryName" value="%{categoryName}" /></s:url>">
						<img src="<s:property value="itemImage" />" width="60%"></a>
					</div>
					<div id="itemName">
						<s:property value="itemName" />
					</div>
					<s:property value="itemPrice" /><a>円</a>
					<input type="hidden" name="itemId" value=${itemId} />
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