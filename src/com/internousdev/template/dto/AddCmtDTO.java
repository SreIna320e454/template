package com.internousdev.template.dto;

public class AddCmtDTO {

	private int userId;
	private int itemId;
	private String itemComment;

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
	public String getItemComment(){
		return itemComment;
	}
	public void setItemComment(String itemComment){
		this.itemComment = itemComment;
	}
}
