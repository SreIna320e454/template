package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class GoBuyItemComplateDAO {

	public void cartItemMoveUserBuyinfo(int userId, int totalPrice, int pay, ArrayList<CartDTO> getCartItemInfo)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO user_buy_item_transaction(user_id, total_price, pay, item_id, item_count, item_price, insert_date) VALUES(?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setInt(2,totalPrice);
			ps.setInt(3, pay);
			for(int i=0; i < getCartItemInfo.size(); i++){
				ps.setInt(4, getCartItemInfo.get(i).getItemId());
				ps.setInt(5, getCartItemInfo.get(i).getItemCount());
				ps.setInt(6, getCartItemInfo.get(i).getItemPrice());
			}
			ps.setString(7, dateUtil.getDate());

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
