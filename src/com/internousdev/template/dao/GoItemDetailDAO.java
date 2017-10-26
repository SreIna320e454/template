package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;
public class GoItemDetailDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 商品情報を取得する
	 * @param itemId
	 * @param categoryName
	 * @return
	 */
	public ItemDTO getItemInfo(int itemId)throws SQLException{

		ItemDTO itemDTO = new ItemDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				itemDTO.setItemName(rs.getString("item_name"));
				itemDTO.setItemPrice(rs.getInt("item_price"));
				itemDTO.setItemImage(rs.getString("item_image"));
				itemDTO.setItemStock(rs.getInt("item_stock"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemDTO;
	}

}
