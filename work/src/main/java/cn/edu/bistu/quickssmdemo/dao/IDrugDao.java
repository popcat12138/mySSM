package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.DrugEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDrugDao {
    int addDrug(DrugEntity drugEntity);

    DrugEntity findDrugById(Integer id);

    List<DrugEntity> findPage(Integer pageNum, Integer pageSize, @Param("drugName") String drugName,@Param("type") String type,@Param("userId") Integer userId);

    int findPageTotal(@Param("drugName") String drugName,@Param("type") String type,@Param("userId") Integer userId);

    int updateDrugInfo(DrugEntity drugEntity);

    int deleteDrugById(Integer id);
}
