package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class GoItemListDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 商品情報を取得する
	 * @param categoryName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ItemDTO> getItemInfo(String categoryName)throws SQLException{

	ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();

	String sql = "SELECT * FROM item_info_transaction WHERE category_name=?";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryName);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setItemId(rs.getInt("item_id"));
			itemDTO.setItemName(rs.getString("item_name"));
			itemDTO.setItemPrice(rs.getInt("item_price"));
			itemDTO.setCategoryName(rs.getString("category_name"));
			itemDTO.setItemImage(rs.getString("item_image"));
			getItemInfo.add(itemDTO);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
}
	return getItemInfo;
}
}
