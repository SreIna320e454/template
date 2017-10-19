package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCartAction extends ActionSupport implements SessionAware{

	private int itemId;
	private String userId;
	private int cartId;
	private String itemName;
	private String itemImage;
	private int itemPrice;
	private int itemCount;
	private int itemStock;
	private ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();
	private ArrayList<CartDTO> searchCartItemInfo = new ArrayList<CartDTO>();
	private Map<String, Object> session = new HashMap<>();

	public String execute(){

		String result = ERROR;

		AddToCartDAO AddToCartDAO = new AddToCartDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (String)session.get("login_user_id");
			searchItemInfo = AddToCartDAO.searchItemInfo(itemId);
			if(searchItemInfo.size()>0){
				AddToCartDAO.addToCart(itemId, userId, itemCount);
				searchCartItemInfo = AddToCartDAO.searchCartItemInfo(userId);
				if(searchCartItemInfo.size()>0){
					result = SUCCESS;
				}
			}
		}
	return result;
	}


	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
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
	public ArrayList<CartDTO> getSearchCartItemInfo(){
		return searchCartItemInfo;
	}
	public void setSearchCartItemInfo(ArrayList<CartDTO> searchCartItemInfo){
		this.searchCartItemInfo = searchCartItemInfo;
	}
	public ArrayList<ItemDTO> getSearchItemInfo(){
		return searchItemInfo;
	}
	public void setSearchItemInfo(ArrayList<ItemDTO> searchItemInfo){
		this.searchItemInfo = searchItemInfo;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

