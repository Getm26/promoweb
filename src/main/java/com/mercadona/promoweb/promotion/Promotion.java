package com.mercadona.promoweb.promotion;

import org.springframework.stereotype.Indexed;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelname;


    public Promotion() {
    }

    public Promotion(Long id, String labelname) {
        this.id = id;
        this.labelname = labelname;
    }

    public Promotion(String labelname) {
        this.labelname = labelname;
    }

    public Long getId() {
        return id;
    }

    public String getLabelname() {
        return labelname;
    }



}
