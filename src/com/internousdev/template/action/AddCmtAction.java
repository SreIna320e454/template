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
/**	private ArrayList<AddCmtDTO> searchCommentInfo = new ArrayList<AddCmtDTO>();	*/
	private ArrayList<AddCmtDTO> comment = new ArrayList<AddCmtDTO>();
	private Map<String, Object> session = new HashMap<>();

/**	public String execute(){

		String result = ERROR;

		AddCmtDAO AddToCmtDAO = new AddCmtDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
		AddToCmtDAO.comment(itemId,itemComment);
		searchCommentInfo = AddToCmtDAO.searchCommentInfo(itemId);
			if(searchCommentInfo.size() > 0){
				result = SUCCESS;
			}
		}
		return result;
	} */

	public String execute(){

		String result = ERROR;

		AddCmtDAO AddCmtDAO = new AddCmtDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			comment = AddCmtDAO.comment(itemId, itemComment);
			if(comment.size()>0){
				result = SUCCESS;
			}
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
	public void seItemId(int itemId){
		this.itemId = itemId;
	}
	public String getItemComment(){
		return itemComment;
	}
	public void setItemComment(String itemComment){
		this.itemComment = itemComment;
	}
/**	public ArrayList<AddCmtDTO> getSearchCommentInfo(){
		return searchCommentInfo;
	}
	public void setSearchCommentInfo(ArrayList<AddCmtDTO> searchCommentInfo){
		this.searchCommentInfo = searchCommentInfo;
	}*/
	public ArrayList<AddCmtDTO> getComment(){
		return comment;
	}
	public void setComment(ArrayList<AddCmtDTO> comment){
		this.comment = comment;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
