package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;

public class GoCartDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();


	public ArrayList<CartDTO> getCartItemInfo(int userId)throws SQLException{

		ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

		String sqlA = "SELECT * FROM cart_list_transaction WHERE user_id=?";
		String sqlB = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1,userId);
			ResultSet rsA = psA.executeQuery();
			while(rsA.next()){
				CartDTO cartDTO = new CartDTO();
				cartDTO.setItemId(rsA.getInt("item_id"));
				cartDTO.setItemCount(rsA.getInt("item_count"));
				getCartItemInfo.add(cartDTO);

				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1, cartDTO.getItemId());
				ResultSet rsB = psB.executeQuery();
				while(rsB.next()){
					cartDTO.setItemName(rsB.getString("item_name"));
					cartDTO.setItemPrice(rsB.getInt("item_price"));
					cartDTO.setItemImage(rsB.getString("item_image"));
					cartDTO.setItemStock(rsB.getInt("item_stock"));
					}
				}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(!(con==null)){
				con.close();
			}
		}
		return getCartItemInfo;
	}
}
