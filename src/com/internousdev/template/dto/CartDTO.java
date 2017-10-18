package com.internousdev.template.dto;

public class CartDTO {

	private int cartId;
	private int userId;
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int itemCount;
	private int subtotal;
	private int itemStock;

	public int getCartId(){
		return cartId;
	}
	public void setCartId(int cartId){
		this.cartId = cartId;
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
	public String getItemImage(){
		return itemImage;
	}
	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}
	public int getItemCount(){
		return itemCount;
	}
	public void setItemCount(int itemCount){
		this.itemCount = itemCount;
	}
	public int getSubtotal(){
		return subtotal;
	}
	public void setSubtotal(int subtotal){
		this.subtotal = subtotal;
	}
	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}
}
