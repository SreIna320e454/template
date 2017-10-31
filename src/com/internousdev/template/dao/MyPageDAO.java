package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {

	/**
	 * 商品購入履歴取得
	 *
	 * @param item_transaction_id
	 * @param user_master_id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MyPageDTO> getMyPageInfo(int userId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		ArrayList<MyPageDTO> getMyPageInfo = new ArrayList<MyPageDTO>();

		String sqlA = "SELECT * FROM user_buy_item_transaction2 WHERE user_id=?";
		String sqlB = "SELECT * FROM user_buy_item_transaction WHERE user_buy_item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1,userId);
			ResultSet rsA = psA.executeQuery();
			while(rsA.next()){
				MyPageDTO myPageDTO = new MyPageDTO();
				myPageDTO.setUserBuyItemId(rsA.getInt("user_buy_item_id"));
				myPageDTO.setItemName(rsA.getString("item_name"));
				myPageDTO.setItemCount(rsA.getInt("item_count"));
				myPageDTO.setItemPrice(rsA.getInt("item_price"));
				getMyPageInfo.add(myPageDTO);

				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1, myPageDTO.getUserBuyItemId());
				ResultSet rsB = psB.executeQuery();
				if(rsB.next()){
					myPageDTO.setTotalPrice(rsB.getInt("total_price"));
					myPageDTO.setPay(rsB.getString("pay"));
					myPageDTO.setInsertDate(rsB.getString("insert_date"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return getMyPageInfo;
	}
}
