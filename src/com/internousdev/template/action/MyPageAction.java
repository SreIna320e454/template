package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private int userId;

	private String userName;

	private ArrayList<MyPageDTO> getMyPageInfo = new ArrayList<MyPageDTO>();

	private Map<String, Object> session;

	public String execute()throws SQLException{

		String result = ERROR;

		MyPageDAO myPageDAO = new MyPageDAO();

		/*
		 * ログイン情報を確認
		 */
		if(!(session.containsKey("login_user_id"))){
			result = LOGIN;
			return result;

		}else{

			/*
			 * ユーザーIDから商品購入情報を取得
			 */
			userId = (int)session.get("login_user_id");
			getMyPageInfo = myPageDAO.getMyPageInfo(userId);
			if(getMyPageInfo.size() > 0){
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

	public ArrayList<MyPageDTO> getGetMyPageInfo() {
		return getMyPageInfo;
	}

	public void setGetMyPageInfo(ArrayList<MyPageDTO> getMyPageInfo) {
		this.getMyPageInfo = getMyPageInfo;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
