package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.AddCmtDTO;
import com.internousdev.template.util.DBConnector;

public class AddCmtDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

/**	public void adComment(int itemId, String itemComment){

		String sql = "INSERT INTO item_comment_transaction(item_id, item_comment) VALUES(?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, itemComment);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<AddCmtDTO> searchCommentInfo(int itemId){

		ArrayList<AddCmtDTO> searchCommentInfo = new ArrayList<AddCmtDTO>();

		String sql = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AddCmtDTO dto = new AddCmtDTO();
				dto.setItemComment(rs.getString("item_comment"));
				searchCommentInfo.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return searchCommentInfo;
	} */

	public ArrayList<AddCmtDTO>comment(int itemId, String itemComment){
		ArrayList<AddCmtDTO> comment = new ArrayList<AddCmtDTO>();
		String sqlA = "INSERT INTO item_comment_transaction(item_id, item_comment) VALUES(?,?)";
		String sqlB = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareCall(sqlA);
			psA.setInt(1, itemId);
			psA.setString(2, itemComment);
			int commentAmount = psA.executeUpdate();
			if(commentAmount>0){
				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1, itemId);
				ResultSet rs = psB.executeQuery();
				while(rs.next()){
					AddCmtDTO dto = new AddCmtDTO();
					dto.setItemComment(rs.getString("item_comment"));
					comment.add(dto);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return comment;
	}
}
