package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemListDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SortPriceHighAction extends ActionSupport implements SessionAware{

	private int itemId;
	private String userId;
	private String itemName;
	private int itemPrice;
	private String categoryName;
	private String itemImage;
    public ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();
    private Map<String, Object> session = new HashMap<>();

    /**
     * 商品を値段の高い順に並べ替えるアクション
     */
    public String execute()throws SQLException{

        String result=ERROR;

        GoItemListDAO dao = new GoItemListDAO();
        /*
         * 商品報を取得
         */
        getItemInfo = dao.getItemInfo(categoryName);

        if(getItemInfo.size()>0){
        	/*
        	 * 値段の高い順に並べ替える
        	 */
        	Collections.sort(getItemInfo);
        	getItemInfo.sort(Comparator.reverseOrder());
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
    public ArrayList<ItemDTO> getGetItemInfo() {
        return getItemInfo;
    }
    public void setGetItemInfo(ArrayList<ItemDTO> getItemInfo) {
        this.getItemInfo = getItemInfo;
   }
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}