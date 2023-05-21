package com.mercadona.promoweb.product;

import javax.swing.ImageIcon;

import org.springframework.stereotype.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelname;
    private String description;
    private ImageIcon picture;
    private Integer price;
    private Integer discount;
    private String category;
        
    
    public Product() {
    }

    public Product(Long id, String labelname, String description, ImageIcon picture, Integer price, Integer discount,  String category) {
        this.id = id;
        this.labelname = labelname;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.discount = discount;
        this.category = category;
    }


    public Product(String labelname, String description, ImageIcon picture, Integer price, Integer discount, String category) {
        this.labelname = labelname;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.discount = discount;
        this.category = category;
    
    }


    public Product(String labelname) {
        this.labelname = labelname;
    }

    public Long getId() {
        return id;
    }

    public String getLabelname() {
        return labelname;
    }

    public String getDescription() {
        return description;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getCategory() {
        return category;


}
