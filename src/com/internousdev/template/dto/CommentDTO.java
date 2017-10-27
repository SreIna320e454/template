package com.internousdev.template.dto;

public class CommentDTO {

	private int userId;

	private String userName;

	private int itemId;

	private String itemComment;

	private String commentDate;

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
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
	public String getCommentDate(){
		return commentDate;
	}
	public void setCommentDate(String commentDate){
		this.commentDate = commentDate;
	}
}
