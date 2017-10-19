package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCmtDAO;
import com.internousdev.template.dto.AddToCmtDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCmtAction extends ActionSupport implements SessionAware{

	private int userId;
	private int itemId;
	private String itemComment;
	private ArrayList<AddToCmtDTO> searchCommentInfo = new ArrayList<AddToCmtDTO>();
	private Map<String, Object> session = new HashMap<>();

	public String execute(){

		String result = ERROR;

		AddToCmtDAO AddToCmtDAO = new AddToCmtDAO();
		session.put("itemComment",this.itemComment);
		session.put("userId",this.itemId);

		AddToCmtDAO.comment(this.itemId,this.itemComment);
		searchCommentInfo = AddToCmtDAO.searchCommentInfo(itemId);
		if(searchCommentInfo.size() > 0){
			result = SUCCESS;
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
	public void seItemId(int itemId){
		this.itemId = itemId;
	}
	public String getItemComment(){
		return itemComment;
	}
	public void setItemComment(String itemComment){
		this.itemComment = itemComment;
	}
	public ArrayList<AddToCmtDTO> searchCommentInfo(){
		return searchCommentInfo;
	}
	public void searchCommentInfo(ArrayList<AddToCmtDTO> searchCommentInfo){
		this.searchCommentInfo = searchCommentInfo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
