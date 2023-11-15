package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import cn.edu.bistu.quickssmdemo.service.IBookService;
import cn.edu.bistu.quickssmdemo.service.IUserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/book")
public class BookController {
    @Resource
    private IBookService bookService;

    @RequestMapping("bookManagePage")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "") String type,
                           @RequestParam(defaultValue = "") Integer userId){
        System.out.println("ppp");
        pageNum=(pageNum-1)*pageSize;
        List<BookEntity> data=bookService.findBookPage(pageNum, pageSize, title,type,userId);
        Integer total=bookService.findPageTotal(title,type,userId);
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }


    @RequestMapping("addOrUpdateBook")
    public Result save(@RequestBody BookEntity bookEntity){
        if(bookEntity.getId()!=null){
            bookService.updateBookInfo(bookEntity);
        }else {
            bookService.addBook(bookEntity);
        }
        return Result.success(bookEntity);
    }

    @RequestMapping("/getBook/{id}")
    public Result getBook(@PathVariable Integer id){
        BookEntity bookEntity=bookService.findBookById(id);
        return Result.success(bookEntity);
    }

    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        bookService.deleteBook(id);
        return Result.success();
    }

    @RequestMapping("moreCollect")
    public Result moreCollect(){
        Map<String,Object> res=new HashMap<>();
        List<BookEntity> data=bookService.findMoreCollect();
        res.put("data",data);
        return Result.success(res);
    }
}
