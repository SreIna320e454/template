package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CommentDTO;
import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class ItemCommentDAO {

	private DBConnector db = new DBConnector();

	private Connection con = db.getConnection();

	private DateUtil dateUtil = new DateUtil();
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

		String sql = "INSERT INTO item_comment_transaction(item_id, user_name, item_comment, insert_date) VALUES(?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, userName);
			ps.setString(3,itemComment);
			ps.setString(4, dateUtil.getDate());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
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
				commentDTO.setCommentDate(rs.getString("insert_date"));
				getComment.add(commentDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
	}
		return getComment;
	}

	/**
	 * 前回投稿されたレビューの時間を取得する
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public CommentDTO getBeforeDate(String userName)throws SQLException{

		CommentDTO getBeforeDate = new CommentDTO();

		String sql = "SELECT * FROM item_comment_transaction WHERE user_name=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				getBeforeDate.setGetBeforeDate(rs.getString("insert_date"));
			}
		}catch(Exception e){
			e.printStackTrace();
	}
		return getBeforeDate;
	}
}
