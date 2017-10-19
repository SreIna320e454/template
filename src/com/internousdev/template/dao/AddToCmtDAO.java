package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.AddToCmtDTO;
import com.internousdev.template.util.DBConnector;

public class AddToCmtDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	public void comment(int itemId, String itemComment){

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

	public ArrayList<AddToCmtDTO> searchCommentInfo(int itemId){

		ArrayList<AddToCmtDTO> searchCommentInfo = new ArrayList<AddToCmtDTO>();

		String sql = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AddToCmtDTO dto = new AddToCmtDTO();
				dto.setItemComment(rs.getString("item_image"));
				searchCommentInfo.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return searchCommentInfo;
	}
}
