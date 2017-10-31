package com.internousdev.template.dto;

public class MyPageDTO {

	private int userBuyItemId;

	private int itemId;

	private int totalPrice;

	private String pay;

	private String insertDate;

	private String itemName;

	private int itemCount;

	private int itemPrice;

	public int getUserBuyItemId() {
		return userBuyItemId;
	}

	public void setUserBuyItemId(int userBuyItemId) {
		this.userBuyItemId = userBuyItemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPay() {
		if(pay.equals("1")){
			pay = "現金払い";
			return pay;
		}else{
			pay = "クレジットカード払い";
			return pay;
		}
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


}
