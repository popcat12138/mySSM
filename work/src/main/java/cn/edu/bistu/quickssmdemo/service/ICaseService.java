package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.CaseEntity;

import java.util.List;

public interface ICaseService {

    CaseEntity addCase(CaseEntity caseEntity);

    CaseEntity findCaseById(int id);

    List<CaseEntity> findPage(Integer pageNum, Integer pageSize,String userName,Integer userId);

    int findPageTotal(String userName,Integer userId);

    CaseEntity updateCaseInfo(CaseEntity caseEntity);

    int deleteCase(Integer id);

    List<CaseEntity> findMoreCollect();
}
