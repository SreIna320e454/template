package com.internousdev.template.dao;

import java.sql.Connection;
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
 商品情報を取得するメソッド
 * */
	public ItemDTO itemDetailInfo(int itemId){

		ItemDTO itemDetailInfo = new ItemDTO();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				itemDetailInfo.setItemId(rs.getInt("item_id"));
				itemDetailInfo.setItemName(rs.getString("item_name"));
				itemDetailInfo.setItemPrice(rs.getInt("item_price"));
				itemDetailInfo.setItemImage(rs.getString("item_image"));
				itemDetailInfo.setItemStock(rs.getInt("item_stock"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemDetailInfo;
	}

/**
* 入力されたレビューをDBに格納し、引き出すメソッド
*/
	public ArrayList<AddCmtDTO>comment(int itemId, String itemComment){
		ArrayList<AddCmtDTO> comment = new ArrayList<AddCmtDTO>();
		String sqlA = "INSERT INTO item_comment_transaction(item_id, item_comment) VALUES(?,?)";
		String sqlB = "SELECT * FROM item_comment_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
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
