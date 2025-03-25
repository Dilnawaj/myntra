package com.app.myntra.entity;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String image;

    private String company;

    private String item_name;

    private Integer original_price;

    private Integer current_price;

    private  Integer discount_percentage;

    private Integer return_period;

    private String delivery_date;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;
    public  Item()
    {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Integer original_price) {
        this.original_price = original_price;
    }

    public Integer getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Integer current_price) {
        this.current_price = current_price;
    }

    public Integer getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(Integer discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public Integer getReturn_period() {
        return return_period;
    }

    public void setReturn_period(Integer return_period) {
        this.return_period = return_period;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
