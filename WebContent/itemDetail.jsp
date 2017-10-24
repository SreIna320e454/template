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
	<title>ItemDetail</title>
	<link rel="stylesheet" type="text/css" href="./css/headerFooter.css">
	<link rel="stylesheet" type="text/css" href="./css/itemDetail.css">
</head>
<body>

	<s:include value="header.jsp" />

	<div id="all">
		<div id="main">
			<div id="top">
				<p>ItemDetail</p>
			</div>

			<s:form action="AddToCartAction">
				<s:iterator value="itemDetailInfo">
					<img src="<s:property value="itemImage" />" width="300px">

						<table>
							<tr>
								<td>
									<span>商品名</span>
								</td>
								<td>
									<s:property value="itemName" /><br>
								</td>
							</tr>
							<tr>
								<td>
									<span>値段</span>
								</td>
								<td>
									<s:property value="itemPrice" /><span>円</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>在庫</span>
								</td>
								<td>
									<span>残り</span><s:property value="itemStock" /><span>個</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>購入個数</span>
								</td>
								<td>
								<select name="itemCount">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
									</select>
								</td>
							</tr>
						<!--<tr>
								<td>
									<span>支払い方法</span>
								</td>
								<td>
			  						<input type="radio" name="pay" value="1" checked="checked">現金払い
									<input type="radio" name="pay" value="2">クレジットカード
								</td>
							</tr>-->
						</table>

						<input type="hidden" name="itemId" value=${itemId} />

						<div id="btnPosition">
							<s:submit value="カートに入れる"/>
						</div>
				</s:iterator>

				<p><a href='<s:url action="GoItemListAction" />'>前ページに戻る</a></p>
			</s:form>
		</div>

		<div id="mainB">
			<div class="caption">
				<p>Review List</p>
			</div>
			<s:if test="%{comment.size()>0}">
				<p class="textAlign">まだレビューがありません</p>
			</s:if>
			<s:else>
				<s:iterator value="comment">
					<div id="container">
						<s:property value="itemComment" />
						<s:property value="userName" />
					</div>
				</s:iterator>
			</s:else>

			<div class="caption">
				<p>Add review</p>
			</div>
			<s:form action="GoItemDetailAction">
				<div class="textAlign">
					<textarea name="itemComment" rows="30" cols="80" maxlength="4000"
    				placeholder="ここに入力してください(4000字まで)"></textarea>
				</div>
						<input type="hidden" name="itemId" value=${itemId} />
				<s:submit id="submitButton" value="この内容で送信する" />
			</s:form>
		</div>
	</div>

	<s:include value="footer.jsp" />

</body>
</html>