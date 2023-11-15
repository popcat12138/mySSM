package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.IDrugDao;
import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.DrugEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements IDrugService{

    @Autowired
    IDrugDao drugDao;

    @Override
    public DrugEntity addDrug(DrugEntity drugEntity) {
        drugDao.addDrug(drugEntity);
        return drugEntity;
    }

    @Override
    public DrugEntity findDrugById(int id) {
        return drugDao.findDrugById(id);
    }

    @Override
    public List<DrugEntity> findPage(Integer pageNum, Integer pageSize, String drugName,String type,Integer userId) {
        return drugDao.findPage(pageNum, pageSize, drugName,type,userId);
    }

    @Override
    public int findPageTotal(String drugName,String type,Integer userId) {
        return drugDao.findPageTotal(drugName,type,userId);
    }

    @Override
    public DrugEntity updateDrugInfo(DrugEntity drugEntity) {
        drugDao.updateDrugInfo(drugEntity);
        return drugEntity;
    }

    @Override
    public int deleteDrug(Integer id) {
        return drugDao.deleteDrugById(id);
    }
}
