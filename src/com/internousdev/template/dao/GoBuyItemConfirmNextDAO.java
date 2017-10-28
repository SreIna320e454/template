package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.UserInfoDTO;
import com.internousdev.template.util.DBConnector;

public class GoBuyItemConfirmNextDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

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
	public int setUserInfo(int userId, int postCodeA, int postCodeB, String prefectures, String streetAddressA, String streetAddressB, String streetAddressC)throws SQLException{

		int countTest = 0;

		String sql = "INSERT INTO user_information(user_id, postcode_a, postcode_b, prefectures, street_address_a, street_address_b, street_address_c) VALUES(?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, postCodeA);
			ps.setInt(3, postCodeB);
			ps.setString(4, prefectures);
			ps.setString(5, streetAddressA);
			ps.setString(6, streetAddressB);
			ps.setString(7, streetAddressC);
			countTest = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
	}
		return countTest;
	}

	/**
	 * DBからユーザー情報を引き出す
	 * @param userId
	 * @return
	 */
	public UserInfoDTO getUserInfo(int userId)throws SQLException{

		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_information WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				userInfoDTO.setPostCodeA(rs.getInt("postcode_a"));
				userInfoDTO.setPostCodeB(rs.getInt("postcode_b"));
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
