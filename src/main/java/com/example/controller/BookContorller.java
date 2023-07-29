package com.example.controller;

import com.example.event.TestEvent;
import com.example.mapper.BookMapper;
import com.example.pojo.Book;
import com.example.vo.Page;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookContorller {

    @Resource
    BookMapper bookMapper;

    @GetMapping
    public List<Book> FindBooks() {
        return bookMapper.GetAll();
    }

    @PostMapping
    public String AddBook(@RequestBody Book book) {
        bookMapper.AddBook(book);
        return "Success";
    }

    @PutMapping
    public String UpdateBook(@RequestBody Book book) {
        bookMapper.UpdateBookById(book);
        return "Success";
    }

    @DeleteMapping("/{id}")
    public String DeleteBook(@PathVariable("id") String id) {
        bookMapper.DeleteBookById(id);
        return "Success";
    }

    @GetMapping("/{id}")
    public Book FindBook(@PathVariable("id") String id) {
        return bookMapper.GetBookById(id);
    }

    @GetMapping("/page")
    public Page<Book> FindBookByPage(@RequestParam(defaultValue = "1") Integer pageIndex,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        Integer offset = (pageIndex - 1) * pageSize;
        List<Book> books = bookMapper.FindBookByPage(offset, pageSize);
        Page<Book> page = new Page<>();
        page.setData(books);
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotal(bookMapper.getTotal());
        return page;
    }
}


