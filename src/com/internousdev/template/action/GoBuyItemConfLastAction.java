package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoBuyItemConfLastDAO;
import com.internousdev.template.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyItemConfLastAction extends ActionSupport implements SessionAware{

	private int userId;

	private int postCodeA;

	private int postCodeB;

	private String prefectures;

	private String streetAddressA;

	private String streetAddressB;

	private String streetAddressC;

	private int pay;

	private ArrayList<UserInfoDTO> getUserInfo = new ArrayList<UserInfoDTO>();

	private Map<String, Object>session;

	public String execute()throws SQLException{

		String result = ERROR;

		GoBuyItemConfLastDAO goBuyItemConfLastDAO = new GoBuyItemConfLastDAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (int)session.get("login_user_id");
			goBuyItemConfLastDAO.setUserInfo(userId, postCodeA, postCodeB, prefectures, streetAddressA, streetAddressB, streetAddressC);
			getUserInfo = goBuyItemConfLastDAO.getUserInfo(userId);
			if(getUserInfo.size()>0){
				if(pay==1){
					result = SUCCESS;
				}
			}
			return result;
		}
	}

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getPostCodeA(){
		return postCodeA;
	}
	public void setPostCodeA(int postCodeA){
		this.postCodeA = postCodeA;
	}
	public int getPostCodeB(){
		return postCodeB;
	}
	public void setPostCodeB(int postCodeB){
		this.postCodeB = postCodeB;
	}
	public String getPrefectures(){
		return prefectures;
	}
	public void setPrefectures(String prefectures){
		this.prefectures = prefectures;
	}
	public String getStreetAddressA(){
		return streetAddressA;
	}
	public void setStreetAddressA(String streetAddressA){
		this.streetAddressA = streetAddressA;
	}
	public String getStreetAddressB(){
		return streetAddressB;
	}
	public void setStreetAddressB(String streetAddressB){
		this.streetAddressB = streetAddressB;
	}
	public String getStreetAddressC(){
		return streetAddressC;
	}
	public void setStreetAddressC(String streetAddressC){
		this.streetAddressC = streetAddressC;
	}
	public int getPay(){
		return pay;
	}
	public void setPay(int pay){
		this.pay = pay;
	}
	public ArrayList<UserInfoDTO> getGetUserInfo(){
		return getUserInfo;
	}
	public void setGetUserInfo(ArrayList<UserInfoDTO> getUserInfo){
		this.getUserInfo = getUserInfo;
	}
	public Map<String, Object> session(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
