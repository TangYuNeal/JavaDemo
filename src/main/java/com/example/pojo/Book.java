package com.example.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String id;
    private String name;
    private int type;
    private Date publishDate;
    private Float price;
}
