package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;


/**
 * カート情報を購入情報テーブルに移動する
 * @author internousdev
 *
 */
public class GoBuyItemComplateDAO {

	public int cartMoveUserBuyinfo(int userId, int totalPrice, int pay, ArrayList<CartDTO> getCartItemInfo)throws SQLException{

		int countCheck = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO user_buy_item_transaction(user_id, total_price, pay, item_id, item_count, item_price, insert_date) VALUES(?,?,?,?,?,?,?)";

		try{
			for(int i=0; i < getCartItemInfo.size(); i++){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setInt(2,totalPrice);
			ps.setInt(3, pay);
				ps.setInt(4, getCartItemInfo.get(i).getItemId());
				ps.setInt(5, getCartItemInfo.get(i).getItemCount());
				ps.setInt(6, getCartItemInfo.get(i).getItemPrice());
			ps.setString(7, dateUtil.getDate());
			countCheck = ps.executeUpdate();
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return countCheck;
	}

	public int cartMoveUserBuyinfo2(int userId, int totalPrice, int pay, ArrayList<CartDTO> getCartItemInfo){

		int countCheck = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
	}
	/**
	 * カート情報を削除する
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public int CartItemRemove(int userId)throws SQLException{

		int countCheck = 0;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM cart_list_transaction WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			countCheck = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return countCheck;
	}
}
