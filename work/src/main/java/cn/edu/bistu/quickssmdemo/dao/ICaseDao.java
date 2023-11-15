package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.CaseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICaseDao {
    int addCase(CaseEntity caseEntity);

    CaseEntity findCaseById(Integer id);

    List<CaseEntity> findPage(Integer pageNum, Integer pageSize, @Param("caseTitle") String caseTitle,@Param("userId") Integer userId);

    int findPageTotal(@Param("caseTitle") String caseTitle,@Param("userId") Integer userId);

    int updateCaseInfo(CaseEntity caseEntity);

    int deleteCaseById(Integer id);

    List<CaseEntity> findMoreCollect();
}
