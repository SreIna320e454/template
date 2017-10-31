package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dao.GoBuyItemComplateDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyItemComplateAction extends ActionSupport implements SessionAware{

	int userId;
	int totalPrice;
	int pay;
	private Map<String, Object> session;

	/**
	 * 購入完了画面へ遷移するアクション
	 */
	public String execute()throws SQLException{

		String result = SUCCESS;

		ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();
		AddToCartDAO addToCartDAO = new AddToCartDAO();
		GoBuyItemComplateDAO goBuyItemComplateDAO = new GoBuyItemComplateDAO();

		/*
		 * ログイン情報を確認
		 */
		if(!(session.containsKey("login_user_id"))){
			result = LOGIN;
			return result;

		}else{

			userId = (int)session.get("login_user_id");

			/*
			 * カート情報を取得
			 */
			getCartItemInfo = addToCartDAO.getCartItemInfo(userId);

			/*
			 * カートの中身を購入情報に移動する
			 */
			int countCheck = goBuyItemComplateDAO.cartMoveUserBuyinfo(userId, totalPrice, pay, getCartItemInfo);
			if(countCheck > 0){
				countCheck = 0;

				/*
				 * カート情報を削除する
				 */
				countCheck = goBuyItemComplateDAO.CartItemRemove(userId);
				if(countCheck > 0){
					result = SUCCESS;
					return result;
				}
			}
			return result;
		}
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
