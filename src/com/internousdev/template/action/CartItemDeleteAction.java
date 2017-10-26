package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dao.CartItemDeleteDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemDeleteAction extends ActionSupport implements SessionAware{

	private int userId;
	private int itemId;
	private int totalPrice;
	private String deleteAll;
	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();
	private Map<String, Object> session;

	/**
	 * カート商品を削除するアクション
	 */
	public String execute()throws SQLException{

		String result = ERROR;

		AddToCartDAO addToCartDAO = new AddToCartDAO();
		CartItemDeleteDAO cartItemDeleteDAO = new CartItemDeleteDAO();

			/*
			 * ログイン情報を確認
			 */
			if(session.containsKey("login_user_id")==false){
				result = LOGIN;
				return result;
			}

			/*
			 * 「全て削除」が押された場合
			 */
			if(!(deleteAll==null)){
				/*
				 * カート情報を全て削除
				 */
				userId = (int)session.get("login_user_id");
				cartItemDeleteDAO.deleteAll(userId);

				getCartItemInfo = addToCartDAO.getCartItemInfo(userId);
				result = SUCCESS;
			}

			/*
			 *	１つの商品を削除する場合
			 */
			if(deleteAll==null){
				/*
				 * 選択された商品を削除
				 */
				userId = (int)session.get("login_user_id");
				cartItemDeleteDAO.delete(userId, itemId);
				/*
				 * 値段の合計を計算
				 */
				getCartItemInfo = addToCartDAO.getCartItemInfo(userId);
				for (int i = 0; i < getCartItemInfo.size(); i++) {
					totalPrice += (getCartItemInfo.get(i).getItemPrice()) * (getCartItemInfo.get(i).getItemCount());
				}
				result = SUCCESS;
			}

		return result;

	}

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
	public String getDeleteAll(){
		return deleteAll;
	}
	public void setDeleteAll(String deleteAll){
		this.deleteAll = deleteAll;
	}
	public ArrayList<CartDTO> getGetCartItemInfo(){
		return getCartItemInfo;
	}
	public void setGetCartItemInfo(ArrayList<CartDTO> getCartItemInfo){
		this.getCartItemInfo = getCartItemInfo;
	}
	public Map<String, Object> session(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
