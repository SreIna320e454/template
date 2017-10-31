package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.UserInfoDTO;
import com.internousdev.template.util.DBConnector;

public class GoBuyItemConfirmNextDAO {

	/**
	 * 入力されたユーザー情報をDBに格納する
	 * @param userId
	 * @param postCodeA
	 * @param postCodeB
	 * @param prefectures
	 * @param streetAddressA
	 * @param streetAddressB
	 * @param streetAddressC
	 */
	public int setUserInfo(int userId, String postcode, String prefectures, String streetAddressA, String streetAddressB, String streetAddressC)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO user_information(user_id, postcode, prefectures, street_address_a, street_address_b, street_address_c) VALUES(?,?,?,?,?,?)";

		int countCheck = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, postcode);
			ps.setString(3, prefectures);
			ps.setString(4, streetAddressA);
			ps.setString(5, streetAddressB);
			ps.setString(6, streetAddressC);
			countCheck = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return countCheck;
	}

	/**
	 * DBからユーザー情報を引き出す
	 * @param userId
	 * @return
	 */
	public UserInfoDTO getUserInfo(int userId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_information WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userInfoDTO.setPostcode(rs.getString("postcode"));
				userInfoDTO.setPrefectures(rs.getString("prefectures"));
				userInfoDTO.setStreetAddressA(rs.getString("street_address_a"));
				userInfoDTO.setStreetAddressB(rs.getString("street_address_b"));
				userInfoDTO.setStreetAddressC(rs.getString("street_address_c"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
	}
		return userInfoDTO;
	}
}
