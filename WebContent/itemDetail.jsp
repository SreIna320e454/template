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

				<s:iterator value="getItemInfo">
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
						</table>
				</s:iterator>

				<div id="btnPosition">
					<input type="hidden" name="itemId" value=${itemId} />
					<s:submit value="カートに入れる"/>
				</div>

			</s:form>

			<s:form action="GoItemListAction">
				<input type="hidden" name="categoryName" value=${categoryName} />
				<s:submit value="商品一覧に戻る" />
			</s:form>

			<div class="reviewForm">
				<p>Review List</p>
			</div>
			<s:if test="getComment.size>0">
				<s:iterator value="getComment">
					<div id="container">
						<a><font size="3">レビュー:<s:property value="itemComment" /></font></a><br>
						<a>ユーザー名:<s:property value="userName" /></a><br>
						<a>日付：<s:property value="commentDate" /></a>
					</div>
				</s:iterator>

			</s:if>

				<s:property value="timeDifference" />

			<s:else>
				<p>まだレビューがありません。</p>
			</s:else>

			<div class="reviewForm">
				<p>Add review</p>
			</div>
			<s:if test="#session.login_user_id != null">
				<s:form action="AddCommentAction">
					<div class="textAlign">
						<textarea name="itemComment" rows="20" cols="50" maxlength="800" wrap="hard"
	    				placeholder="ここに入力してください(800字まで)"></textarea>
					</div>
					<input type="hidden" name="itemId" value=${itemId} />
					<font size="3" color="red"><s:property value="errorMessage" /></font>
					<s:submit id="submitButton" value="この内容で送信する" />
				</s:form>
			</s:if>
			<s:else>
				<p class="textAlign">レビューを追加するにはログインをしてください。</p>
			</s:else>

		</div>
	</div>

  	<s:include value="footer.jsp" />

</body>
</html>