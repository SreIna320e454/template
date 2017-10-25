package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class GoItemListDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	/**
	 * 商品情報を取得する
	 * @param categoryName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ItemDTO> getItemInfo(String categoryName)throws SQLException{

	ArrayList<ItemDTO> getItemInfo = new ArrayList<ItemDTO>();

	String sql = "SELECT * FROM item_info_transaction WHERE category_name=?";

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, categoryName);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			ItemDTO dto = new ItemDTO();
			dto.setItemId(rs.getInt("item_id"));
			dto.setItemName(rs.getString("item_name"));
			dto.setItemPrice(rs.getInt("item_price"));
			dto.setCategoryName(rs.getString("category_name"));
			dto.setItemImage(rs.getString("item_image"));
			getItemInfo.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		con.close();
}
	return getItemInfo;
}
}
