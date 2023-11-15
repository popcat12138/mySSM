package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.DrugEntity;

import java.util.List;

public interface IDrugService {

    DrugEntity addDrug(DrugEntity drugEntity);

    DrugEntity findDrugById(int id);

    List<DrugEntity> findPage(Integer pageNum, Integer pageSize,String drugName,String type,Integer userId);

    int findPageTotal(String drugName,String type,Integer userId);

    DrugEntity updateDrugInfo(DrugEntity drugEntity);

    int deleteDrug(Integer id);
}


