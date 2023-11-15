package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.config.TokenJWT;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import cn.edu.bistu.quickssmdemo.service.IUserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/userAction")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/getUser/{id}")
    public Result getUser(@PathVariable Integer id){
        UserEntity userEntity=userService.findUserById(id);
        return Result.success(userEntity);
    }

    @RequestMapping("updateUserInfo")
    public Result updateInfo(@RequestBody UserEntity userEntity){
        UserEntity user=userService.updateUserInfo(userEntity);
        return Result.success(user);
    }


    @PostMapping("register")
    public Result save(@RequestBody UserEntity userEntity){
        userService.registerUser(userEntity);
        return Result.success(userEntity);
    }

    @RequestMapping("existUser")
    public Result existUser(String userName){
        System.out.println("userName"+userName);
        if(userService.findUserByUserName(userName)!=null){
            return Result.error("404","已存在");
        }
        else{
            return Result.success();
        }
    }
    


    @PostMapping("/login")
    public Result login(@RequestBody UserEntity user){
        if(userService.login(user)){
            UserEntity userEntity=userService.findUserByUserName(user.getUserName());
            String token=TokenJWT.genToken(user.getUserName(),user.getPassword());
            userEntity.setToken(token);
            return Result.success(userEntity);
        }
        return Result.error("300","密码错误");
    }
}


