package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemListDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemListAction extends ActionSupport implements SessionAware{

	private int itemId;

	private String categoryName;

    public ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();

    private Map<String, Object> session;

    /**
     * カテゴリ別商品一覧画面へ遷移するアクション
     */
    public String execute()throws SQLException{

        String result=ERROR;

        GoItemListDAO dao = new GoItemListDAO();
        /*
         * 商品情報を取得
         */
        getItemInfo = dao.getItemInfo(categoryName);

        if(getItemInfo.size()>0){
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
	public String getCategoryName(){
		return categoryName;
	}
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
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
