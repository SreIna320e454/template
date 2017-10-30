package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dao.CartItemUpdateDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemUpdateAction  extends ActionSupport implements SessionAware{

	private int userId;

	private int itemId;

	private int itemCount;

	private int totalPrice;

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object> session;

	/**
	 * カートの商品数を変更するアクション
	 * @return
	 * @throws SQLException
	 */
	public String execute()throws SQLException{

		String result = ERROR;

		AddToCartDAO addToCartDAO = new AddToCartDAO();
		CartItemUpdateDAO  cartItemUpdateDAO = new CartItemUpdateDAO();

		/*
		 * ログイン情報を確認
		 */
		if(!(session.containsKey("login_user_id"))){
			result = LOGIN;
			return result;

		}else{

			/*
			 * 入力された数字をカートテーブルで更新する
			 */
			userId = (int)session.get("login_user_id");
			cartItemUpdateDAO.update(itemCount, userId, itemId);

			/*
			 * 商品情報を取得
			 */
			getCartItemInfo = addToCartDAO.getCartItemInfo(userId);

			/*
			 * 値段合計を計算
			 */
			for (int i = 0; i < getCartItemInfo.size(); i++) {
				totalPrice += (getCartItemInfo.get(i).getItemPrice()) * (getCartItemInfo.get(i).getItemCount());
			}

			result = SUCCESS;
			return result;
		}

	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
	public ArrayList<CartDTO> getGetCartItemInfo() {
		return getCartItemInfo;
	}
	public void setGetCartItemInfo(ArrayList<CartDTO> getCartItemInfo) {
		this.getCartItemInfo = getCartItemInfo;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
