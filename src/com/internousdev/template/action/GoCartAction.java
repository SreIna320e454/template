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
	private int cartId;
	private String itemName;
	private String itemImage;
	private int itemPrice;
	private int itemCount;
	private int itemStock;
	private ArrayList<CartDTO> searchCartItemInfo = new ArrayList<CartDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException{

		String result = SUCCESS;

		GoCartDAO goCartDAO = new GoCartDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (int)session.get("login_user_id");
			searchCartItemInfo = goCartDAO.searchCartItemInfo(userId);
			if(searchCartItemInfo.size()>0){
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
	public int getCartId(){
		return cartId;
	}
	public void setCartId(int cartId){
		this.cartId = cartId;
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
	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}
	public ArrayList<CartDTO> getSearchCartItemInfo(){
		return searchCartItemInfo;
	}
	public void setSearchCartItemInfo(ArrayList<CartDTO> searchCartItemInfo){
		this.searchCartItemInfo = searchCartItemInfo;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
