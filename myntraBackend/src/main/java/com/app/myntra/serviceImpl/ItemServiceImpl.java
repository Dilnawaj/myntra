package com.app.myntra.serviceImpl;

import com.app.myntra.entity.Item;
import com.app.myntra.entity.Rating;
import com.app.myntra.exception.CustomException;
import com.app.myntra.model.AllItem;
import com.app.myntra.model.ItemModel;
import com.app.myntra.repo.ItemRepository;
import com.app.myntra.repo.RatingRepo;
import com.app.myntra.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public ItemModel add(ItemModel itemModel) {
        return modelMapper.map(itemRepo.save(modelMapper.map(itemModel, Item.class)), ItemModel.class);
    }

    @Override
    public ItemModel update(ItemModel itemModel, Integer id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.value(), "Item not found"));
        getItem(itemModel, item);
        Optional<Rating> ratingOpt = ratingRepo.findById(item.getRating().getId());
        if (ratingOpt.isPresent()) {
            Rating rating = ratingOpt.get();
            rating.setCount(itemModel.getRating().getCount());
            rating.setStars(itemModel.getRating().getStars());
        }
        return modelMapper.map(itemRepo.save(item), ItemModel.class);


    }


    private static void getItem(ItemModel itemModel, Item item) {
        item.setItem_name(itemModel.getItem_name());
        item.setCompany(itemModel.getCompany());
        item.setCurrent_price(itemModel.getCurrent_price());
        item.setImage(itemModel.getImage());
        item.setDelivery_date(itemModel.getDelivery_date());
        item.setDiscount_percentage(itemModel.getDiscount_percentage());
        item.setOriginal_price(itemModel.getOriginal_price());
        item.setReturn_period(itemModel.getReturn_period());

    }

    @Override
    public String deleteItem(Integer id) {
        Item item = itemRepo.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.value(), "Item not found"));
        itemRepo.delete(item);
        JSONObject json = new JSONObject();
        json.put("status", "Item deleted successfully");
        return (json.toString());
    }

    @Override
    public ItemModel getItem(Integer id) {
        return modelMapper.map(itemRepo.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND.value(), "Item not found")), ItemModel.class);
    }

    @Override
    public AllItem getAllItems() {
        List<ItemModel> data =itemRepo.findAll().stream().map(item -> modelMapper.map(item, ItemModel.class)).collect(Collectors.toList());
       return new AllItem(data);
    }

}
