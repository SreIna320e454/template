package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoBuyItemConfirm2DAO;
import com.internousdev.template.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyItemConfirm2Action extends ActionSupport implements SessionAware{

	private int userId;

	private int postCodeA;

	private int postCodeB;

	private String prefectures;

	private String streetAddressA;

	private String streetAddressB;

	private String streetAddressC;

	private int pay;

	private int totalPrice;

	private UserInfoDTO getUserInfo = new UserInfoDTO();

	private Map<String, Object>session;

	public String execute()throws SQLException{

		String result = ERROR;

		GoBuyItemConfirm2DAO goBuyItemConfLastDAO = new GoBuyItemConfirm2DAO();

		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			userId = (int)session.get("login_user_id");
			int countTest =goBuyItemConfLastDAO.setUserInfo(userId, postCodeA, postCodeB, prefectures, streetAddressA, streetAddressB, streetAddressC);
			if(countTest>0){
				getUserInfo = goBuyItemConfLastDAO.getUserInfo(userId);
					if(pay==1){
						totalPrice += 350;
						result = SUCCESS;
						return result;
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
	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
	public UserInfoDTO getGetUserInfo(){
		return getUserInfo;
	}
	public void setGetUserInfo(UserInfoDTO getUserInfo){
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
