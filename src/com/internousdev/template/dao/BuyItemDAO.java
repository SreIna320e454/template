package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ItemDTO ItemDTO = new ItemDTO();

	/**
	 * 商品情報取得メソッド
	 *
	 * @return BuyItemDTO
	 */
	public ItemDTO getBuyItemInfo() {

		String sql = "SELECT item_id, item_name, item_price, category FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				ItemDTO.setItemId(resultSet.getInt("item_id"));
				ItemDTO.setItemName(resultSet.getString("item_name"));
				ItemDTO.setItemPrice(resultSet.getInt("item_price"));
				ItemDTO.setCategoryName(resultSet.getString("category"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return ItemDTO;
	}

	public ItemDTO getBuyItemDTO() {
		return ItemDTO;
	}
}