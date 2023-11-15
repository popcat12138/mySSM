package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.UserEntity;

import java.util.List;

public interface IUserService {


    UserEntity registerUser(UserEntity userEntity);

    UserEntity findUserByUserName(String userName);

    UserEntity findUserById(int id);

    List<UserEntity> findPage(Integer pageNum, Integer pageSize,String userName);

    int findPageTotal(String userName);

    boolean login(UserEntity userEntity);

    UserEntity updateUserInfo(UserEntity userEntity);

}
