package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware{

	private int itemId;

	private int userId;

	private int totalPrice;

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object> session;

	/**
	 * カート画面へ遷移するアクション
	 */
	public String execute() throws SQLException{

		String result = SUCCESS;

		AddToCartDAO addToCartDAO = new AddToCartDAO();

		/*
		 * ログイン情報を確認
		 */
		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (int)session.get("login_user_id");
			/*
			 * カート情報を取得
			 */
			getCartItemInfo = addToCartDAO.getCartItemInfo(userId);
			/*
			 * 商品の価格合計を計算
			 */
			for (int i = 0; i < getCartItemInfo.size(); i++) {
				totalPrice += (getCartItemInfo.get(i).getItemPrice()) * (getCartItemInfo.get(i).getItemCount());
			}
			if(getCartItemInfo.size()>0){
				result = SUCCESS;
			}
		}
		return result;
	}


	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
	public ArrayList<CartDTO> getGetCartItemInfo(){
		return getCartItemInfo;
	}
	public void setGetCartItemInfo(ArrayList<CartDTO> getCartItemInfo){
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
