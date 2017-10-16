package com.internousdev.template.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.internousdev.template.dao.MoveItemdetailDAO;
import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MoveItemdetailAction extends ActionSupport{

	private List<ItemDTO> itemSelect;
	private int id;
	private String itemName;
	private int categoryId;
	private int itemPrice;
	private String category;
	private String itemImage;
	private int itemStock;
	private ArrayList<ItemDTO> displayList = new ArrayList<ItemDTO>();
	private ArrayList<Integer> stockList;
    private List<CartDTO> itemIdList;
    private int itemCount;
    private Map<String, Object> session;
    private int userId;
    private boolean msg;

    public String execute()throws SQLException{

    	String result = ERROR;

    	MoveItemdetailDAO dao = new MoveItemdetailDAO();
    	displayList = dao.test(id);
    	if(displayList.size()!=0){
    		result = SUCCESS;
    	}
    	return result;
    }

    public String execute2() throws SQLException{

    	String result = ERROR;

    	MoveItemdetailDAO dao = new MoveItemdetailDAO();
    	stockList = new ArrayList<Integer>();
    	itemSelect = dao.test(id);

    	if(session.containsKey("userId")){
    		setUserId((int) session.get("userId"));
    	}
    	for (int i = 1; i <= itemSelect.get(0).getItemStock(); i++) {
            if (i >= 10) {
                break;
            }
            stockList.add(i);
        }
        for (CartDTO dto : itemIdList) {
            if (dto.getItemId() == id) {
                setMsg(true);
            }
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
    public int getcategoryId() {
        return categoryId;
    }
    public void setSortId(int categoryId) {
        this.categoryId = categoryId;
    }
    public int getitemPrice() {
        return itemPrice;
    }
    public void setitemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getCategory(){
    	return category;
    }
    public void setCategory(String category){
    	this.category = category;
    }
    public String getItemImage() {
        return itemImage;
    }
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }
    public ArrayList<ItemDTO> getDisplayList() {
        return displayList;
    }
    public void setDisplayList(ArrayList<ItemDTO> displayList) {
        this.displayList = displayList;
    }
    public ArrayList<Integer> getStockList() {
        return stockList;
    }
    public void setStockList(ArrayList<Integer> stockList) {
        this.stockList = stockList;
    }
    public int getItemCount() {
        return itemCount;
    }
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    public boolean isMsg() {
        return msg;
    }
    public void setMsg(boolean msg) {
        this.msg = msg;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getItemStock() {
        return itemStock;
    }
    public void setItemStocks(int itemStock) {
        this.itemStock = itemStock;
    }


}
