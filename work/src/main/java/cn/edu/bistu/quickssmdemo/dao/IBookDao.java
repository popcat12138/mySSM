package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IBookDao {
    int addBook(BookEntity bookEntity);

    BookEntity findBookById(Integer id);

    List<BookEntity> findPage(Integer pageNum, Integer pageSize, @Param("title") String title,@Param("type") String type,@Param("userId") Integer userId);

    int findPageTotal(@Param("title") String title,@Param("type") String type,@Param("userId") Integer userId);

    int updateBookInfo(BookEntity bookEntity);

    int deleteBookById(Integer id);

    List<BookEntity> findMoreCollect();
}
