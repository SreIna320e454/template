package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCartAction extends ActionSupport implements SessionAware{

	private int itemId;

	private int userId;

	private int cartId;

	private String itemName;

	private String itemImage;

	private int itemPrice;

	private int itemCount;

	private int itemStock;

	private int totalPrice;

	private ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object> session;

	public String execute()throws SQLException{

		String result = ERROR;

		AddToCartDAO AddToCartDAO = new AddToCartDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (int)session.get("login_user_id");
			getItemInfo = AddToCartDAO.getItemInfo(itemId);
			if(getItemInfo.size()>0){
				AddToCartDAO.addToCart(itemId, userId, itemCount);
				getCartItemInfo = AddToCartDAO.getCartItemInfo(userId);
				if(getCartItemInfo.size()>0){
					for (int i = 0; i < getCartItemInfo.size(); i++) {
						totalPrice += (getCartItemInfo.get(i).getItemPrice()) * (getCartItemInfo.get(i).getItemCount());
					}
					result = SUCCESS;
				}
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
	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId = itemId;
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
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
	public ArrayList<ItemDTO> getGetItemInfo(){
		return getItemInfo;
	}
	public void setGetItemInfo(ArrayList<ItemDTO> getItemInfo){
		this.getItemInfo = getItemInfo;
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

