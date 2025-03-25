package com.app.myntra.service;

import com.app.myntra.model.AllItem;
import com.app.myntra.model.ItemModel;

import java.util.List;

public interface ItemService {
   ItemModel add(ItemModel itemModel);

   ItemModel getItem(Integer id);

   AllItem getAllItems();

   ItemModel update(ItemModel itemModel,Integer id);

   String deleteItem(Integer id);
}
