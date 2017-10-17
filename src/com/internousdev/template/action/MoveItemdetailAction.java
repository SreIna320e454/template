package com.internousdev.template.action;
import java.util.ArrayList;

import com.internousdev.template.dao.MoveItemdetailDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MoveItemdetailAction extends ActionSupport{

	private int id;
	private String itemName;
	private int itemPrice;
	private String itemImage;
	private int itemStock;
	public ArrayList<ItemDTO> detailItemInfo = new ArrayList<ItemDTO>();

    public String execute(){

    	String result = ERROR;

    	MoveItemdetailDAO dao = new MoveItemdetailDAO();

    	detailItemInfo = dao.test(id);

    	if(detailItemInfo.size()>0){
    		result = SUCCESS;
    	}
    	return result;
    	}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getItemStock() {
        return itemStock;
    }
    public void setItemStocks(int itemStock) {
        this.itemStock = itemStock;
    }
    public ArrayList<ItemDTO> getDetailItemInfo(){
    	return detailItemInfo;
    }
    public void setDetailItemInfo(ArrayList<ItemDTO> detailItemInfo){
    	this.detailItemInfo = detailItemInfo;
    }
}
