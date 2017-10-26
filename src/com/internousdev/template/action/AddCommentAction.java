package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemDetailDAO;
import com.internousdev.template.dao.ItemCommentDAO;
import com.internousdev.template.dto.CommentDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCommentAction extends ActionSupport implements SessionAware{

	private int userId;

	private String userName;

	private int itemId;

	private String itemName;

	private int itemPrice;

	private String itemImage;

	private String categoryName;

	private int itemStock;

	private String itemComment;

	private ItemDTO getItemInfo = new ItemDTO();

	private ArrayList<CommentDTO> getComment = new ArrayList<CommentDTO>();

	private Map<String, Object> session = new HashMap<>();

	/**
	 * レビューを登録するアクション
	 */
	public String execute()throws SQLException{

		String result = ERROR;

		ItemCommentDAO addComment = new ItemCommentDAO();
		GoItemDetailDAO goItemDetailDAO = new GoItemDetailDAO();

		/*
		 * ログイン情報を確認
		 */
		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{

			/*
			 * レビュー情報をDBに格納
			 */
			userName = (String)session.get("user_name");
			addComment.addComment(itemId, userName, itemComment);

			/*
			 * 商品情報を取得
			 */
			getItemInfo = goItemDetailDAO.getItemInfo(itemId);

			/*
			 * レビュー情報を取得
			 */
			ItemCommentDAO itemCommentDAO = new ItemCommentDAO();
			getComment = itemCommentDAO.getComment(itemId);
			if(getComment.size()>0){
				result = SUCCESS;
				return result;
			}
		}
		return result;
	}

	public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
	public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
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
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getItemStock() {
        return itemStock;
    }
    public void setItemStocks(int itemStock) {
        this.itemStock = itemStock;
    }
    public String getItemComment() {
        return itemComment;
    }
    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }
    public ItemDTO getGetItemInfo(){
    	return getItemInfo;
    }
    public void setGetItemInfo(ItemDTO getItemInfo){
    	this.getItemInfo = getItemInfo;
    }
	public ArrayList<CommentDTO> getGetComment(){
		return getComment;
	}
	public void setGetComment(ArrayList<CommentDTO> getComment){
		this.getComment = getComment;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}