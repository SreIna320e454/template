package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class MoveItemdetailDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ArrayList<ItemDTO> test(int itemId){

		ArrayList<ItemDTO> detailItemInfo = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemImage(rs.getString("item_image"));
				dto.setItemStock(rs.getInt("item_stock"));

				detailItemInfo.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return detailItemInfo;
	}
}
