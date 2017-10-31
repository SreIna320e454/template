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

public class GoItemDetailAction extends ActionSupport implements SessionAware{

	private int itemId;

	private String categoryName;

	private ItemDTO getItemInfo = new ItemDTO();

	private ArrayList<CommentDTO> getComment = new ArrayList<CommentDTO>();

	private Map<String, Object> session = new HashMap<>();

	/**
	 * 商品詳細画面へ遷移するアクション
	 */
    public String execute()throws SQLException{

    	String result = ERROR;

    	GoItemDetailDAO goItemDetailDAO = new GoItemDetailDAO();

		/*
		 * 商品情報を取得
		 */
    	getItemInfo = goItemDetailDAO.getItemInfo(itemId);
    	/*
    	 * レビュー情報を取得
    	 */
    	ItemCommentDAO itemCommentDAO = new ItemCommentDAO();
    	getComment = itemCommentDAO.getComment(itemId);

    	result = SUCCESS;
    	return result;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
	public ArrayList<CommentDTO> getGetComment(){
		return getComment;
	}
	public void setGetComment(ArrayList<CommentDTO> getComment){
		this.getComment = getComment;
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
