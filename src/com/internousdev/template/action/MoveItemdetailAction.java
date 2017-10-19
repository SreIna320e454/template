package com.internousdev.template.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MoveItemdetailDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MoveItemdetailAction extends ActionSupport implements SessionAware{

	private int itemId;
	private int userId;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int itemStock;
	public ArrayList<ItemDTO> detailItemInfo = new ArrayList<ItemDTO>();
	private Map<String, Object> session = new HashMap<>();

    public String execute(){

    	String result = ERROR;

    	MoveItemdetailDAO dao = new MoveItemdetailDAO();

    	detailItemInfo = dao.test(itemId);

    	if(session.containsKey("login_user_id")==false){
    		return result;
    	}else if(detailItemInfo.size()>0){
    		result = SUCCESS;
    	}else{result = SUCCESS;
    	}
    	return result;
    	}

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getUserId(){
    	return userId;
    }
    public void setUserId(int userId){
    	this.userId = userId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemImage() {
        return itemImage;
    }
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    public int getItemStock() {
        return itemStock;
    }
    public void setItemStocks(int itemStock) {
        this.itemStock = itemStock;
    }
    public ArrayList<ItemDTO> getDetailItemInfo(){
    	return detailItemInfo;
    }
    public void setDetailItemInfo(ArrayList<ItemDTO> detailItemInfo){
    	this.detailItemInfo = detailItemInfo;
    }
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
