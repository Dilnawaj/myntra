package com.app.myntra.model;

import lombok.Data;

@Data
public class ItemModel {
    private String id;

    private String image;

    private String company;

    private String item_name;

    private Integer original_price;

    private Integer current_price;

    private  Integer discount_percentage;

    private Integer return_period;

    private String delivery_date;

   private RatingModel rating;

}
