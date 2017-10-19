package com.internousdev.template.dao;

import java.util.Comparator;

import com.internousdev.template.dto.ItemDTO;

public class ItemListSortDAO implements Comparator{

	public int compare(ItemDTO dto, ItemDTO dto2){
		if(dto.getItemPrice()<dto2.getItemPrice()){
			return -1;
		}else if(dto.getItemPrice()>dto2.getItemPrice()){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public int compare(Object o1, Object o2) {
		return compare(o1,o2);
	}
}
