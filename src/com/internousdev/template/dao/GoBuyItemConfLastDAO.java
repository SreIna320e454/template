package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.UserInfoDTO;
import com.internousdev.template.util.DBConnector;

public class GoBuyItemConfLastDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

/**
 * 入力された各情報をDBに格納するメソッド
 * @param userId
 * @param postCodeA
 * @param postCodeB
 * @param prefectures
 * @param streetAddressA
 * @param streetAddressB
 * @param streetAddressC
 */
	public void inputUserInfo(int userId, int postCodeA, int postCodeB, String prefectures, String streetAddressA, String streetAddressB, String streetAddressC){

		String sql = "INSERT INTO user_information(user_id, postcode_a, postcode_b, prefectures, street_address_a, street_address_b, street_address_c) VALUES(?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(1, postCodeA);
			ps.setInt(1, postCodeB);
			ps.setString(1, prefectures);
			ps.setString(1, streetAddressA);
			ps.setString(1, streetAddressB);
			ps.setString(1, streetAddressC);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

/**
 * DBからユーザ情報を引き出すメソッド
 * @param userId
 * @return
 */
	public ArrayList<UserInfoDTO> selectUserInfo(int userId){

		ArrayList<UserInfoDTO> selectUserInfo = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM user_information WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setPostCodeA(rs.getInt("postcode_a"));
				userInfoDTO.setPostCodeB(rs.getInt("postcode_b"));
				userInfoDTO.setPrefectures(rs.getString("prefectures"));
				userInfoDTO.setStreetAddressA(rs.getString("street_Address_a"));
				userInfoDTO.setStreetAddressB(rs.getString("street_Address_b"));
				userInfoDTO.setStreetAddressC(rs.getString("street_Address_c"));
				selectUserInfo.add(userInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return selectUserInfo;
	}
}
