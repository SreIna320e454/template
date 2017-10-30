package com.internousdev.template.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	 * @throws ParseException
	 */
	public String execute()throws SQLException, ParseException{

		String result = ERROR;

		GoItemDetailDAO goItemDetailDAO = new GoItemDetailDAO();
		ItemCommentDAO addComment = new ItemCommentDAO();
		ItemCommentDAO itemCommentDAO = new ItemCommentDAO();
		CommentDTO getBeforeDate = new CommentDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");

		/*
		 * ログイン情報を確認する
		 */
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
			 * レビューに何も入力されていない場合エラーメッセージを返す
			 */
			if(itemComment==null || itemComment.equals(" ")){
				getComment = itemCommentDAO.getComment(itemId);
				errorMessage = "レビュー失敗 レビューを入力してください";
				result = SUCCESS;
				return result;

			}else{

					/*
					 * 前回のレビュー投稿時間を取得
					 * String型 → Date型 → long型に変換
					 */
					getBeforeDate = itemCommentDAO.getBeforeDate(userName);
					Date beforeDate = sdf.parse(getBeforeDate.getGetBeforeDate());
					long beforeDate2 = beforeDate.getTime();

					/*
					 * 現在の時間を取得
					 * Date型 → long型に変換
					 */
					Date nowDate = new Date();
					long nowDate2 = nowDate.getTime();

					/*
					 * 前回の投稿時間と今回の投稿時間を比較し、３０秒未満であればエラーを返す
					 */
					long timeDifference = (nowDate2 - beforeDate2) / (1000);

					if(timeDifference < 30){
						getComment = itemCommentDAO.getComment(itemId);
						errorMessage = "レビュー失敗 30秒未満の連続投稿はできません";
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