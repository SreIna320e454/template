package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class MoveItemdetailDAO {

	public ArrayList<ItemDTO> selectItemInfo=new ArrayList<ItemDTO>();

	public ArrayList<ItemDTO> test(int id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ItemDTO dto = new ItemDTO();

		ArrayList<ItemDTO> itemSelect = new ArrayList<ItemDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setCategory(rs.getString("category"));
				dto.setItemImage(rs.getString("item_image"));
				dto.setItemStock(rs.getInt("item_stock"));
				itemSelect.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(!(con==null)){
				con.close();
			}
		}
		return itemSelect;
	}
}
