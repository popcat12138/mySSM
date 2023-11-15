package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.CombinationEntity;

import java.util.ArrayList;
import java.util.List;

public interface ICombinationService {

    CombinationEntity addCom(CombinationEntity combinationEntity);

    CombinationEntity findComById(int id);

    List<CombinationEntity> findPage(Integer pageNum, Integer pageSize,String combName,Integer userId,List<String> recipe,String state);

    int findPageTotal(String combName,Integer userId);

    CombinationEntity updateComInfo(CombinationEntity combinationEntity);

    int deleteComb(Integer id);
}
