package com.internousdev.template.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.GoItemViewDAO;
import com.internousdev.template.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoItemViewAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session = new HashMap<>();

	ArrayList<ItemDTO> getCategoryInfo = new ArrayList<ItemDTO>();

	/**
	 * 商品カテゴリ一覧へ遷移するアクション
	 */
	public String execute()throws SQLException{

		String result = ERROR;

		GoItemViewDAO dao = new GoItemViewDAO();
        /*
         * カテゴリ情報を取得
         */
		getCategoryInfo =dao.getCategoryInfo();
		if(getCategoryInfo.size()>0){
			result = SUCCESS;
		}
		return result;
	}

	public ArrayList<ItemDTO> getGetCategoryInfo(){
		return getCategoryInfo;
	}
	public void setGetCategoryInfo(ArrayList<ItemDTO> getCategoryInfo){
		this.getCategoryInfo = getCategoryInfo;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
