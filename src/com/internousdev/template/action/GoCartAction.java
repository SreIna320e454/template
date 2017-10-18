package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dao.GoCartDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport{

	private int userId;
	private int itemId;
	private int cartId;
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private int itemStock;

	private ArrayList<CartDTO> cartList;
	private ArrayList<ItemDTO> searchItemInfo;


	public String execute()throws SQLException{

		String result = SUCCESS;

		GoCartDAO dao = new GoCartDAO();
		searchItemInfo = dao.searchItemInfo(itemId);
		if(dao.addToCart(userId, itemId, itemCount)){
			cartList = dao.searchCartItemInfo(userId);
			if(cartList.size()>0){
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
	public ArrayList<CartDTO> getCartList(){
		return cartList;
	}
	public void setCartList(ArrayList<CartDTO> cartList){
		this.cartList = cartList;
	}
	public ArrayList<ItemDTO> getSearchItemInfo(){
		return searchItemInfo;
	}
	public void setSearchItemInfo(ArrayList<ItemDTO> searchItemInfo){
		this.searchItemInfo = searchItemInfo;
	}
}
