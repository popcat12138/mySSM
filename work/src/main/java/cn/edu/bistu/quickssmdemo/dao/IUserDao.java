package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserDao {
    int insertUser(UserEntity record);

    UserEntity findUserById(Integer id);

    UserEntity findUserByUserName(String userName);

    List<UserEntity> findPage( Integer pageNum, Integer pageSize,@Param("userName") String userName);

    int findPageTotal(@Param("userName") String userName);

    int registerUser(UserEntity userEntity);

    int updateUserInfo(UserEntity userEntity);
}
