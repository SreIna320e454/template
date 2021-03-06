package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyItemConfirm1Action extends ActionSupport implements SessionAware{

	private int userId;

	private int totalPrice;

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object> session;

	/**
	 * 顧客情報入力画面へ遷移するアクション
	 */
	public String execute()throws SQLException{

		String result = ERROR;

		AddToCartDAO addToCartDAO =new AddToCartDAO();

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

			if(getCartItemInfo.size()>0){
				result = SUCCESS;
			}
		}
		return result;
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
