package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class AddToCartDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

/**商品情報を検索*/
	public ArrayList<ItemDTO> searchItemInfo(int itemId){

		ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemDTO dto = new ItemDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemImage(rs.getString("item_image"));
				dto.setItemStock(rs.getInt("item_stock"));
				searchItemInfo.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return searchItemInfo;
	}
/**カートテーブルに情報を追加*/
	public void addToCart(int itemId, int userId, int itemCount){

		String sql = "INSERT INTO cart_list_transaction(user_id, item_id, item_count) VALUES(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, itemId);
			ps.setInt(3,itemCount);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
/**カートに入った商品情報を表示*/
	public ArrayList<CartDTO> searchCartItemInfo(int userId){

		ArrayList<CartDTO> searchCartItemInfo = new ArrayList<CartDTO>();

		String sqlA = "SELECT * FROM cart_list_transaction WHERE user_id=?";
		String sqlB = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1,userId);
			ResultSet rsA = psA.executeQuery();
			while(rsA.next()){
				CartDTO cartdto = new CartDTO();
				cartdto.setItemId(rsA.getInt("item_id"));
				cartdto.setItemCount(rsA.getInt("item_count"));
				searchCartItemInfo.add(cartdto);

				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1,cartdto.getItemId());
				ResultSet rsB = psB.executeQuery();
				while(rsB.next()){
					cartdto.setItemName(rsB.getString("item_name"));
					cartdto.setItemPrice(rsB.getInt("item_price"));
					cartdto.setItemImage(rsB.getString("item_image"));
					cartdto.setItemStock(rsB.getInt("item_stock"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return searchCartItemInfo;
	}
}
