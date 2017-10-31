package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		String sqlA = "INSERT INTO user_buy_item_transaction(user_id, total_price, pay, insert_date) VALUES(?,?,?,?)";
		String sqlB = "INSERT INTO user_buy_item_transaction2(user_buy_item_id,item_id, item_count, item_price) VALUES(?,?,?,?)";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA, java.sql.Statement.RETURN_GENERATED_KEYS);
			psA.setInt(1,userId);
			psA.setInt(2,totalPrice);
			psA.setInt(3, pay);
			psA.setString(4, dateUtil.getDate());
			psA.execute();

			ResultSet rs = psA.getGeneratedKeys();

			int BuyItemId = 0;

			if(rs.next()){
				BuyItemId = rs.getInt(1);
				}

			for(int i=0; i < getCartItemInfo.size(); i++){
				PreparedStatement psB  = con.prepareStatement(sqlB);
				psB.setInt(1, BuyItemId);
				psB.setInt(2, getCartItemInfo.get(i).getItemId());
				psB.setInt(3, getCartItemInfo.get(i).getItemCount());
				psB.setInt(4, getCartItemInfo.get(i).getItemPrice());
				countCheck = psB.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return countCheck;
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
