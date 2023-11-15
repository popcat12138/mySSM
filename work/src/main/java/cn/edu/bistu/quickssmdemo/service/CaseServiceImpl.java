package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.ICaseDao;
import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.CaseEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements ICaseService{

    @Autowired
    ICaseDao caseDao;

    @Override
    public CaseEntity addCase(CaseEntity caseEntity) {
        caseDao.addCase(caseEntity);
        return caseEntity;
    }

    @Override
    public CaseEntity findCaseById(int id) {
        return caseDao.findCaseById(id);
    }

    @Override
    public List<CaseEntity> findPage(Integer pageNum, Integer pageSize, String caseTitle,Integer userId) {
        return caseDao.findPage(pageNum, pageSize, caseTitle,userId);
    }

    @Override
    public int findPageTotal(String caseTitle,Integer userId) {
        return caseDao.findPageTotal(caseTitle,userId);
    }

    @Override
    public CaseEntity updateCaseInfo(CaseEntity caseEntity) {
        caseDao.updateCaseInfo(caseEntity);
        return caseEntity;
    }

    @Override
    public int deleteCase(Integer id) {
        return caseDao.deleteCaseById(id);
    }

    @Override
    public List<CaseEntity> findMoreCollect() {
        return caseDao.findMoreCollect();
    }
}
