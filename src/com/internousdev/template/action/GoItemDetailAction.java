package com.internousdev.template.action;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemDetailDAO;
import com.internousdev.template.dto.AddCmtDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemDetailAction extends ActionSupport implements SessionAware{

	private int itemId;
	private int userId;
	private String userName;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int itemStock;
	private String categoryName;
	private String itemComment;
	private Date date;
	public ItemDTO getItemInfo = new ItemDTO();
	private ArrayList<AddCmtDTO> addComment = new ArrayList<AddCmtDTO>();
	private Map<String, Object> session = new HashMap<>();

    public String execute(){


    	GoItemDetailDAO dao = new GoItemDetailDAO();

    	getItemInfo = dao.getItemInfo(itemId,categoryName);

    	if(session.containsKey("login_user_id")==true){
    		userName = (String)session.get("user_name");
    		addComment = dao.addComment(itemId, userName, itemComment, date);
    		}

    	String result = SUCCESS;
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
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
	public String getItemComment(){
		return itemComment;
	}
	public void setItemComment(String itemComment){
		this.itemComment = itemComment;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public ArrayList<AddCmtDTO> getAddComment(){
		return addComment;
	}
	public void setAddComment(ArrayList<AddCmtDTO> addComment){
		this.addComment = addComment;
	}
    public ItemDTO getGetItemInfo(){
    	return getItemInfo;
    }
    public void setGetItemInfo(ItemDTO getItemInfo){
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
