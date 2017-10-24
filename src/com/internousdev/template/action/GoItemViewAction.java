package com.internousdev.template.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemViewDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemViewAction extends ActionSupport implements SessionAware{

	private String categoryName;
	private String categoryImage;
	private Map<String, Object> session = new HashMap<>();
	ArrayList<ItemDTO> searchCategoryInfo = new ArrayList<ItemDTO>();

	public String execute(){

		String result = ERROR;

		GoItemViewDAO dao = new GoItemViewDAO();

		searchCategoryInfo =dao.searchCategoryInfo();
		if(searchCategoryInfo.size()>0){
			session.put("category_nametest", searchCategoryInfo);
			result = SUCCESS;
		}
		return result;
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
	public ArrayList<ItemDTO> getSearchCategoryInfo(){
		return searchCategoryInfo;
	}
	public void setSearchCategoryInfo(ArrayList<ItemDTO> searchCategoryInfo){
		this.searchCategoryInfo = searchCategoryInfo;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
