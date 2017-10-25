package com.internousdev.template.dto;

public class UserInfoDTO {

	private int postCodeA;
	private int postCodeB;
	private String prefectures;
	private String streetAddressA;
	private String streetAddressB;
	private String streetAddressC;
	private int pay;

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
}
