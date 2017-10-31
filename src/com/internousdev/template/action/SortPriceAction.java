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

public class SortPriceAction extends ActionSupport implements SessionAware{

	private int itemId;

	private String categoryName;

	private String sort;

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

        	if(sort.equals("high")){
            	/*
            	 * 値段の高い順に並べ替える
            	 */
            	Collections.sort(getItemInfo);
            	getItemInfo.sort(Comparator.reverseOrder());
    	        result=SUCCESS;
    	        return result;

        	}else if(sort.equals("low")){

            	/*
            	 * 値段の低い順に並べ替える
            	 */
            	Collections.sort(getItemInfo);
    	        result=SUCCESS;
    	        return result;
        	}

        }
        return result;
        }

	public int getItemId(){
		return itemId;
	}
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
    public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
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