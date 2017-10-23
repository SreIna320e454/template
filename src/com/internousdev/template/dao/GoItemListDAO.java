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

	public ArrayList<ItemDTO> test(String category){

	ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();


	String sql = "SELECT * FROM item_info_transaction WHERE category=?";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			ItemDTO dto = new ItemDTO();
			dto.setItemId(rs.getInt("item_id"));
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getInt("item_price"));
			dto.setItemImage(rs.getString("item_image"));
			dto.setCategory(rs.getString("category"));

			searchItemInfo.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return searchItemInfo;
}
}
