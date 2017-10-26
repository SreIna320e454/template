package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.AddCmtDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;
public class GoItemDetailDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 商品情報を取得する
	 * @param itemId
	 * @param categoryName
	 * @return
	 */
	public ItemDTO getItemInfo(int itemId, String categoryName){

		ItemDTO itemDTO = new ItemDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=? and category_name=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, categoryName);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				itemDTO.setItemId(rs.getInt("item_id"));
				itemDTO.setItemName(rs.getString("item_name"));
				itemDTO.setItemPrice(rs.getInt("item_price"));
				itemDTO.setItemImage(rs.getString("item_image"));
				itemDTO.setItemStock(rs.getInt("item_stock"));
				itemDTO.setCategoryName(rs.getString("category_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemDTO;
	}

	/**
	 * レビューをDBに格納し取得するメソッド
	 * @param itemId
	 * @param userName
	 * @param itemComment
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<AddCmtDTO>addComment(int itemId, String userName, String itemComment, Date date)throws SQLException{

		ArrayList<AddCmtDTO> addComment = new ArrayList<AddCmtDTO>();

		String sqlA = "INSERT INTO item_comment_transaction(item_id, user_name, item_comment, insert_date) VALUES(?,?,?,?)";
		String sqlB = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1, itemId);
			psA.setString(2, userName);
			psA.setString(3,itemComment);
			psA.setDate(4, date);

			int commentAmount = psA.executeUpdate();

			if(commentAmount>0){
				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1, itemId);
				ResultSet rs = psB.executeQuery();
				while(rs.next()){
					AddCmtDTO dto = new AddCmtDTO();
					dto.setUserName(rs.getString("user_name"));
					dto.setItemComment(rs.getString("item_comment"));
					addComment.add(dto);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
	}
		return addComment;
	}
}
