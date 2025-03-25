package com.app.myntra.controller;

import com.app.myntra.model.AllItem;
import com.app.myntra.model.ItemModel;
import com.app.myntra.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    ResponseEntity<ItemModel> addItem(@RequestBody ItemModel itemModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.add(itemModel));
    }

    @PutMapping
    ResponseEntity<ItemModel> updateItem(@RequestBody ItemModel itemModel, @RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.update(itemModel, id));
    }

    @GetMapping("/{id}")
    ResponseEntity<ItemModel> getItem(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItem(id));
    }

    @GetMapping
    ResponseEntity<AllItem> getAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getAllItems());
    }
    @DeleteMapping
    ResponseEntity<String> deleteItem(@RequestParam Integer id)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(itemService.deleteItem(id));
    }
}
