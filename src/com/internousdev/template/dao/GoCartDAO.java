package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.CartDTO;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class GoCartDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

/**
 * カートテーブルに追加する商品の情報を取得しItemDTOに格納するメソッド
 */
	public ArrayList<ItemDTO> searchItemInfo(int itemId){

		ArrayList<ItemDTO> searchItemInfo = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemDTO dto = new ItemDTO();
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
/**
 * カートテーブルに情報を追加するメソッド
 */
	public boolean addToCart(int itemId, int userId, int itemCount){

		boolean errorCheck = true;
		int addCount = 0;

		String sql = "INSERT INTO cart_list_transaction(user_id, item_id, item_count) VALUES(?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, itemId);
			ps.setInt(3, itemCount);
			addCount = ps.executeUpdate();
			if(addCount>0){
				errorCheck = false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return errorCheck;
	}
/**
 * カートテーブルの商品情報を取得しCartDTOに格納するメソッド
 */
	public ArrayList<CartDTO> searchCartItemInfo(int userId){

		ArrayList<CartDTO> cartList = new ArrayList<CartDTO>();

		String sqlA ="SELECT * FROM cart_list_transaction WHERE user_id=?";
		String sqlB ="SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1, userId);
			ResultSet rsA = psA.executeQuery();
			while(rsA.next()){
				CartDTO dto = new CartDTO();
				dto.setCartId(rsA.getInt("cart_id"));
				dto.setItemId(rsA.getInt("item_id"));
				dto.setUserId(rsA.getInt("user_id"));
				dto.setItemCount(rsA.getInt("item_count"));
				cartList.add(dto);

				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1,dto.getItemId());
				ResultSet rsB = psB.executeQuery();
				while(rsB.next()){
					dto.setItemName(rsB.getString("item_name"));
					dto.setItemPrice(rsB.getInt("item_price"));
					dto.setItemStock(rsB.getInt("item_stock"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cartList;
	}
}
