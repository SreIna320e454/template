package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CommentDTO;
import com.internousdev.template.util.DBConnector;

public class ItemCommentDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	/**
	 * レビューをDBに格納する
	 * @param itemId
	 * @param userName
	 * @param itemComment
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public void addComment(int itemId, String userName, String itemComment)throws SQLException{

		String sql = "INSERT INTO item_comment_transaction(item_id, user_name, item_comment) VALUES(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, userName);
			ps.setString(3,itemComment);
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	/**
	 * レビューを取得する
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CommentDTO>getComment(int itemId)throws SQLException{

		ArrayList<CommentDTO> getComment = new ArrayList<CommentDTO>();

		String sql = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CommentDTO commentDTO = new CommentDTO();
				commentDTO.setUserName(rs.getString("user_name"));
				commentDTO.setItemComment(rs.getString("item_comment"));
				getComment.add(commentDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
	}
		return getComment;
	}
}
