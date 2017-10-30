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

	/**
	 * 商品情報を取得する
	 * @param itemId
	 * @return
	 */
	public ArrayList<ItemDTO> getItemInfo(int itemId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setItemName(rs.getString("item_name"));
				itemDTO.setItemPrice(rs.getInt("item_price"));
				itemDTO.setItemImage(rs.getString("item_image"));
				getItemInfo.add(itemDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return getItemInfo;
	}

	/**
	 * カートテーブルに商品を追加する
	 * @param itemId
	 * @param userId
	 * @param itemCount
	 */
	public void addToCart(int itemId, int userId, int itemCount)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO cart_list_transaction(user_id, item_id, item_count) VALUES(?,?,?)";

		try{

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, itemId);
			ps.setInt(3,itemCount);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	/**
	 * カート情報を取得する
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartDTO> getCartItemInfo(int userId)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		ArrayList<CartDTO> getCartItemInfo = new ArrayList<CartDTO>();

		String sqlA = "SELECT * FROM cart_list_transaction WHERE user_id=?";
		String sqlB = "SELECT * FROM item_info_transaction WHERE item_id=?";

		try{
			PreparedStatement psA = con.prepareStatement(sqlA);
			psA.setInt(1,userId);
			ResultSet rsA = psA.executeQuery();
			while(rsA.next()){
				CartDTO cartDTO = new CartDTO();
				cartDTO.setItemId(rsA.getInt("item_id"));
				getCartItemInfo.add(cartDTO);

				PreparedStatement psB = con.prepareStatement(sqlB);
				psB.setInt(1,cartDTO.getItemId());
				ResultSet rsB = psB.executeQuery();
				while(rsB.next()){
					cartDTO.setItemName(rsB.getString("item_name"));
					cartDTO.setItemPrice(rsB.getInt("item_price"));
					cartDTO.setItemImage(rsB.getString("item_image"));
					cartDTO.setItemCount(rsA.getInt("item_count"));
					cartDTO.setSubtotal(cartDTO.getItemPrice() * cartDTO.getItemCount());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return getCartItemInfo;
	}


}
