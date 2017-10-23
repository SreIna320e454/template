package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddCmtDAO;
import com.internousdev.template.dto.AddCmtDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCmtAction extends ActionSupport implements SessionAware{

	private String userId;
	private int itemId;
	private String itemComment;
	private ArrayList<AddCmtDTO> comment = new ArrayList<AddCmtDTO>();
	Map<String, Object> session = new HashMap<>();

	public String execute(){

		String result = ERROR;

		AddCmtDAO AddCmtDAO = new AddCmtDAO();

			comment = AddCmtDAO.comment(itemId, itemComment);
			if(comment.size()>0){
				result = SUCCESS;
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
	public String getItemComment(){
		return itemComment;
	}
	public void setItemComment(String itemComment){
		this.itemComment = itemComment;
	}
	public ArrayList<AddCmtDTO> getComment(){
		return comment;
	}
	public void setComment(ArrayList<AddCmtDTO> comment){
		this.comment = comment;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
