package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.IBookDao;
import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    IBookDao bookDao;

    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        bookDao.addBook(bookEntity);
        return bookEntity;
    }

    @Override
    public BookEntity findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<BookEntity> findBookPage(Integer pageNum, Integer pageSize, String title,String type,Integer userId) {
        return bookDao.findPage(pageNum,pageSize,title,type,userId);
    }

    @Override
    public int findPageTotal(String title,String type,Integer userId) {
        return bookDao.findPageTotal(title,type,userId);
    }

    @Override
    public BookEntity updateBookInfo(BookEntity bookEntity) {
        bookDao.updateBookInfo(bookEntity);
        return bookEntity;
    }

    @Override
    public int deleteBook(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public List<BookEntity> findMoreCollect() {
        return bookDao.findMoreCollect();
    }
}
