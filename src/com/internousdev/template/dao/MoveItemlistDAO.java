package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class MoveItemlistDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();

	public ArrayList<ItemDTO> test(String category){

	String sql = "SELECT * FROM item_info_transaction where category=?";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ItemDTO dto = new ItemDTO();
			dto.setId(rs.getInt("id"));
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getInt("item_price"));
			dto.setItemImage(rs.getString("item_image"));
			dto.setItemStock(rs.getInt("item_stock"));

			searchItemInfo.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return searchItemInfo;
}
}
