package com.internousdev.template.dto;

public class UserInfoDTO {

	/**
	 * 郵便番号
	 */
	private String postcode;

	/**
	 * 都道府県
	 */
	private String prefectures;

	/**
	 * 市区町村
	 */
	private String streetAddressA;

	/**
	 * 住居番号
	 */
	private String streetAddressB;

	/**
	 * マンション等名
	 */
	private String streetAddressC;

	private int pay;

	public String getPostcode(){
		return postcode;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
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
}
