package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookService {
    BookEntity addBook(BookEntity bookEntity);

    BookEntity findBookById(Integer id);

    List<BookEntity> findBookPage(Integer pageNum, Integer pageSize,String title,String type,Integer userId);

    int findPageTotal(String title,String type,Integer userId);

    BookEntity updateBookInfo(BookEntity bookEntity);

    int deleteBook(int id);

    List<BookEntity> findMoreCollect();
}
