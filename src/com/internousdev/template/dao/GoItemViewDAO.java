package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class GoItemViewDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ArrayList<ItemDTO> getCategoryInfo(){

		ArrayList<ItemDTO> getCategoryInfo = new ArrayList<ItemDTO>();

		String sql = "SELECT category_name, category_image FROM item_categories_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setCategoryName(rs.getString("category_name"));
				itemDTO.setCategoryImage(rs.getString("category_image"));
				getCategoryInfo.add(itemDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return getCategoryInfo;
	}
}
