package com.internousdev.template.dto;

public class ItemDTO {

	private int id;
	private String itemCategory;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int itemStock;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getItemCategory(){
		return itemCategory;
	}
	public void setItemCategory(String itemCategory){
		this.itemCategory = itemCategory;
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
	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}
}
