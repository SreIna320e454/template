package com.internousdev.template.dto;
import java.sql.Date;

public class CommentDTO {

	private int userId;

	private String userName;

	private int itemId;

	private String itemComment;

	private Date commentDate4;

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
	public Date getCommentDate4(){
		return commentDate4;
	}
	public void setCommentDate4(Date commentDate4){
		this.commentDate4 = commentDate4;
	}
}
