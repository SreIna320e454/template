package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemListDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemListAction extends ActionSupport implements SessionAware{

	private int itemId;
	private String userId;
	private String itemName;
	private int itemPrice;
	private String category;
	private String itemImage;
    public ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();
    private Map<String, Object> session = new HashMap<>();

    public String execute(){

        String result=ERROR;

        GoItemListDAO dao = new GoItemListDAO();

        searchItemInfo = dao.test(category);

        if(searchItemInfo.size()>0){
	        result=SUCCESS;
        	}
        return result;
        }

	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
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
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public String getItemImage(){
		return itemImage;
	}
	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}
    public ArrayList<ItemDTO> getSearchItemInfo() {
        return searchItemInfo;
    }
    public void setSearchItemInfo(ArrayList<ItemDTO> searchItemInfo) {
        this.searchItemInfo = searchItemInfo;
   }
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
