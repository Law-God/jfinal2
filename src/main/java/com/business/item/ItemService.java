package com.business.item;

import com.model.Item;
import com.jfinal.plugin.activerecord.Page;

/**
* Service
*/
public class ItemService {

private static final Item dao = new Item().dao();

	public Page<Item> paginate(int pageNumber, int pageSize) {
    	return dao.paginate(pageNumber, pageSize, "select *", "from item order by itemid desc");
    }

    public Item findById(int id) {
    	return dao.findById(id);
    }

    public void deleteById(int id) {
    	dao.deleteById(id);
    }
}