package com.internousdev.template.dto;

public class ItemDTO implements Comparable<ItemDTO>{

	private int itemId;

	private String itemName;

	private int itemPrice;

	private String categoryImage;

	private String categoryName;

	private String itemImage;

	private int itemStock=0;

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
	public String getCategoryImage(){
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage){
		this.categoryImage = categoryImage;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
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
	@Override
	public int compareTo(ItemDTO dto) {
		if(this.getItemPrice()<dto.getItemPrice()){
			return -1;
		}else if(this.getItemPrice()>dto.getItemPrice()){
			return 1;
		}else{
			return 0;
		}
	}
}
