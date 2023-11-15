package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDao userDao;


    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        UserEntity user=new UserEntity();
        user.setUserName(userEntity.getUserName());
        userDao.registerUser(userEntity);
        return user;
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public UserEntity findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<UserEntity> findPage(Integer pageNum, Integer pageSize,String userName) {
        return userDao.findPage(pageNum,pageSize,userName);
    }

    @Override
    public int findPageTotal(String userName) {
        return userDao.findPageTotal(userName);
    }

    @Override
    public boolean login(UserEntity userEntity) {
        try{
            UserEntity userTest=userDao.findUserByUserName(userEntity.getUserName());
            if(userTest==null || !userTest.getPassword().equals(userEntity.getPassword())){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserEntity updateUserInfo(UserEntity userEntity) {

                userDao.updateUserInfo(userEntity);

        return userDao.findUserById(userEntity.getId());
    }

}
