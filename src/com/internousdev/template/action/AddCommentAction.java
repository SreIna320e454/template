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

	private String commentDate;

	private String errorMessage;

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
		ItemCommentDAO itemCommentDAO = new ItemCommentDAO();
		ItemCommentDAO getCommentDate = new ItemCommentDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{

			/*
			 * 商品情報を取得
			 */
			getItemInfo = goItemDetailDAO.getItemInfo(itemId);


			userName = (String)session.get("user_name");

			/*
			 * 何も入力されていない場合エラーメッセージを返す
			 */
			if(itemComment==null || itemComment.equals("")){

				getComment = itemCommentDAO.getComment(itemId);

				errorMessage = "追加に失敗しました。レビューを入力してください";
				result = SUCCESS;
				return result;

			}else{
				/*
				 * レビューをDBに格納
				 */
				addComment.addComment(itemId, userName, itemComment);

				/*
				 * レビュー情報を取得
				 */

				getComment = itemCommentDAO.getComment(itemId);
				result = SUCCESS;
				return result;
			}
		}
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
    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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