package com.example.mapper;

import com.example.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookMapper {
    @Select("select * from books")
    List<Book> GetAll();

    @Update("INSERT INTO `books` (`Id`, `Name`, `Type`, `PublishDate`, `Price`) VALUES (#{id}, #{name}, #{type}, #{publishDate}, #{price})")
    @Transactional
    void AddBook(Book book);

    @Update("update `books` set `Name` = #{name},`Type` = #{type},`PublishDate` = #{publishDate}, `Price` = #{price} where `Id` = #{id}")
    @Transactional
    void UpdateBookById(Book book);

    @Delete("delete from `books` where `Id` = #{id}")
    @Transactional
    void DeleteBookById(String id);

    @Select("select * from books where `Id` = #{id}")
    Book GetBookById(String id);

    @Select("select * from books Limit #{offset},#{pageSize}")
    List<Book> FindBookByPage(Integer offset, Integer pageSize);

    @Select("select Count(id) from books")
    Integer getTotal();
}
