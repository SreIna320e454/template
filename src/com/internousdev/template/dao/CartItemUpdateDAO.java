package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;

public class CartItemUpdateDAO {

	/**
	 * カート商品の個数を変更する
	 * @param itemCount
	 * @param userId
	 * @param itemId
	 * @throws SQLException
	 */
	public void update(int itemCount, int userId, int itemId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "UPDATE cart_list_transaction SET item_count = ? WHERE user_id=? AND item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemCount);
			ps.setInt(2, userId);
			ps.setInt(3, itemId);
			ps.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
