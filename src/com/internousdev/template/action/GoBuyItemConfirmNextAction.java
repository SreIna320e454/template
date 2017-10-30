package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.AddToCartDAO;
import com.internousdev.template.dao.GoBuyItemConfirmNextDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoBuyItemConfirmNextAction extends ActionSupport implements SessionAware{

	private int userId;

	private int postcodeA;

	private int postcodeB;

	private String prefectures;

	private String streetAddressA;

	private String streetAddressB;

	private String streetAddressC;

	private int pay;

	private int totalPrice;

	private int totalPriceAddCommission;

	private UserInfoDTO getUserInfo = new UserInfoDTO();

	private ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

	private Map<String, Object>session;

	public String execute()throws SQLException{

		String result = ERROR;

		/*
		 * ログイン情報を確認
		 */
		if(session.containsKey("login_user_id")==false){
			result = LOGIN;
			return result;
		}else{
			/*
			 * ユーザー情報をDBに格納、取得する
			 */
			userId = (int)session.get("login_user_id");

			GoBuyItemConfirmNextDAO goBuyItemConfirmNextDAO = new GoBuyItemConfirmNextDAO();
			int countTest =goBuyItemConfirmNextDAO.setUserInfo(userId, postcodeA, postcodeB, prefectures, streetAddressA, streetAddressB, streetAddressC);
			if(countTest>0){
					/*
					 * 現金払いの場合
					 */
					if(pay==1){
						getUserInfo = goBuyItemConfirmNextDAO.getUserInfo(userId);

						AddToCartDAO addToCartDAO = new AddToCartDAO();
						getCartItemInfo = addToCartDAO.getCartItemInfo(userId);

						totalPriceAddCommission = totalPrice + 350;

						result = "buyItemConfirm3";
						return result;
						/*
						 * クレジットカード払いの場合
						 */
					}if(pay==2){
						result = "buyItemConfirm2";
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
	public int getPostcodeA(){
		return postcodeA;
	}
	public void setPostcodeA(int postcodeA){
		this.postcodeA = postcodeA;
	}
	public int getPostcodeB(){
		return postcodeB;
	}
	public void setPostcodeB(int postcodeB){
		this.postcodeB = postcodeB;
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
	public int getTotalPriceAddCommission(){
		return totalPriceAddCommission;
	}
	public void setTotalPriceAddCommission(int totalPriceAddCommission){
		this.totalPriceAddCommission = totalPriceAddCommission;
	}
	public UserInfoDTO getGetUserInfo(){
		return getUserInfo;
	}
	public void setGetUserInfo(UserInfoDTO getUserInfo){
		this.getUserInfo = getUserInfo;
	}
	public ArrayList<CartDTO> getGetCartItemInfo(){
		return getCartItemInfo;
	}
	public void setGetCartItemInfo(ArrayList<CartDTO> getCartItemInfo){
		this.getCartItemInfo = getCartItemInfo;
	}
	public Map<String, Object> session(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
