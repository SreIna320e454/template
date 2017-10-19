package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class MoveItemdetailDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public ItemDTO test(int itemId){

		ItemDTO detailItemInfo = new ItemDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				detailItemInfo.setItemId(rs.getInt("item_id"));
				detailItemInfo.setItemName(rs.getString("item_name"));
				detailItemInfo.setItemPrice(rs.getInt("item_price"));
				detailItemInfo.setItemImage(rs.getString("item_image"));
				detailItemInfo.setItemStock(rs.getInt("item_stock"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return detailItemInfo;
	}
}
