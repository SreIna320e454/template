
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<title>BuyItemConfirm</title>
	<style type="text/css">
	/* ========TAG LAYOUT======== */
	</style>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm.css">
	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>
</head>
<body>

	<s:include value="header.jsp" />

	<div id="main">
	<div id="container">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>
		<div id="containerLeft">
			<div class="contain">
				カート内容
			</div>
			<s:if test="%{searchCartItem.size() > 0 && #session.login_user_id != null}">
				<s:form action="#">
					<table>
						<thead>
							<tr>
								<th width="260" height="30">商品</th>
								<th width="100" height="30">値段</th>
								<th width="70" height="30">個数</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="searchCartItem">
								<tr>
									<td align="left">
										<a id="textDeco"><s:property value="itemName" /></a>
									</td>
									<td>
										<s:property value="itemPrice" /><a>円</a>
									</td>
									<td>
										<s:property value="itemCount" /><a>個</a>
									</td>
								</tr>
							</s:iterator>
								<tr>
									<td></td>
									<td><a>合計:</a><s:property value="totalPrice" /><a>円</a></td>
									<td></td>
								</tr>
						</tbody>
					</table>
				</s:form>
			</s:if>
			<s:else>
				カートには何も入っていません。
			</s:else>
		</div>
		<div id="containerRight">
			<div class="contain">
				住所・支払い方法選択
			</div>
			<div id="CustomerInfo">
				<table>
					<thead>
						<tr>
							<th width="70"></th>
							<th></th>
						</tr>
					</thead>
					<tr>
						<td><a>郵便番号</a></td>
						<td>(必須)<input type="text" name="PostCodeA" style=width:23px; placeholder="000"/>-<input type="text" name="PostCode2" style=width:30px; placeholder="0000"/><a>例:113-0034</a></td>
					</tr>
					<tr>
						<td><a>住所</a></td>
						<td>(必須)<input type="text" name="Prefectures" placeholder="都道府県"/><a>例:東京都</a></td>
					</tr>
					<tr>
						<td></td>
						<td>(必須)<input type="text" name="StreetAddressA" placeholder="市区町村"/><a>例:文京区</a></td>
					</tr>
					<tr>
						<td></td>
						<td>(必須)<input type="text" name="StreetAddressB" placeholder="住居番号"/><a>例:湯島３丁目２−１２</a></td>
					</tr>
					<tr>
						<td></td>
						<td>(任意)<input type="text" name="StreetAddressC" placeholder="マンション等名"/><a>例:御茶ノ水天神ビル2F</a></td>
					</tr>
					<tr>
						<td>支払い方法</td>
						<td><input type="radio" name="pay" value="1" checked="checked">現金払い(手数料がかかります +350円)</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="radio" name="pay" value="2">クレジットカード</td>
					</tr>
				</table>
				<s:submit value="すすむ" />
			</div>
		</div>
		<p style="clear:left;">戻る</p>
		</div>
	</div>

	<s:include value="footer.jsp" />
</body>

</html>