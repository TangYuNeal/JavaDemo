package com.example.vo;

import com.example.pojo.Book;
import lombok.Data;

import java.util.List;
@Data
public class Page<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer total;
    private List<T> data;
}
