package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
public class CartItemDeleteDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 選択された商品を削除する
	 * @param userId
	 * @param itemId
	 * @throws SQLException
	 */
	public void delete(int userId, int itemId)throws SQLException{

		String sql = "DELETE FROM cart_list_transaction WHERE user_id=? AND item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, itemId);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
	/**
	 * カート情報を全て削除する
	 * @param userId
	 * @throws SQLException
	 */
	public void deleteAll(int userId)throws SQLException{

		String sql = "DELETE FROM cart_list_transaction WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
