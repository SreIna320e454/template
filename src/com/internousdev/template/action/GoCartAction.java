package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware{

	private int itemId;

	private int userId;

	private String itemName;

	private String itemImage;

	private int itemPrice;

	private int itemCount;

	private int totalPrice;

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object> session;

	/**
	 * カート画面へ遷移するアクション
	 */
	public String execute() throws SQLException{

		String result = SUCCESS;

		GoCartDAO goCartDAO = new GoCartDAO();

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
			getCartItemInfo = goCartDAO.getCartItemInfo(userId);
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
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemImage(){
		return itemImage;
	}
	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}
	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}
	public int getItemCount(){
		return itemCount;
	}
	public void setItemCount(int itemCount){
		this.itemCount = itemCount;
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
