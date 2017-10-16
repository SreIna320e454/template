package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.MoveItemlistDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MoveItemlistAction extends ActionSupport {

	private int id;
	private String itemName;
	private int itemPrice;
	private String category;
	private String itemImage;
	private int itemStock;
    public ArrayList<ItemDTO> searchItemInfo=new ArrayList<ItemDTO>();


    /**
     * 実行メソッド
     * @return success or error
     */
    public String execute(){
        String result=ERROR;

        MoveItemlistDAO dao =new MoveItemlistDAO();

        searchItemInfo=dao.test(category);

        if(searchItemInfo.size()>0){
            result=SUCCESS;
            }
        return result;
        }

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public String getItemImage(){
		return itemImage;
	}
	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}
	public int getItemStock(){
		return itemStock;
	}
	public void setItemStock(int itemStock){
		this.itemStock = itemStock;
	}

    public ArrayList<ItemDTO> getSearchItemInfo() {
        return searchItemInfo;
        }

    /**
     * サーチリストを格納するメソッド
     * @param searchList サーチリスト
     */
    public void setSearchItemInfo(ArrayList<ItemDTO> searchItemInfo) {
        this.searchItemInfo = searchItemInfo;
        }


}
