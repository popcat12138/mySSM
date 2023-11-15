package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.ICombinationDao;
import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.CombinationEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombinationServiceImpl implements ICombinationService{

    @Autowired
    ICombinationDao combinationDao;

    @Override
    public CombinationEntity addCom(CombinationEntity combinationEntity) {
        combinationDao.addCom(combinationEntity);
        return combinationEntity;
    }

    @Override
    public CombinationEntity findComById(int id) {
        return combinationDao.findComById(id);
    }

    @Override
    public List<CombinationEntity> findPage(Integer pageNum, Integer pageSize, String combName,Integer userId,List<String> recipe,String state) {
        return combinationDao.findPage(pageNum, pageSize, combName,userId,recipe,state);
    }

    @Override
    public int findPageTotal(String combName,Integer userId) {
        return combinationDao.findPageTotal(combName,userId);
    }

    @Override
    public CombinationEntity updateComInfo(CombinationEntity combinationEntity) {
        combinationDao.updateComInfo(combinationEntity);
        return combinationEntity;
    }

    @Override
    public int deleteComb(Integer id) {
        return combinationDao.deleteComById(id);
    }
}
