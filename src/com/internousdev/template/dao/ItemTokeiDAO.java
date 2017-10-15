package com.internousdev.template.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import com.internousdev.template.dto.ItemDTO;
import com.internousdev.template.util.DBConnector;

public class ItemTokeiDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	ItemDTO dto = new ItemDTO();

	String sql = "SELECT id, item_category, item_name, item_price, item_image, item_stock, FROM item_info_transaction";

	public ArrayList<ItemDTO> test(){

	try{
		PreparedStatement ps = con.prepareStatement(sql);

	}
}
}
