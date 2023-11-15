package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.CombinationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICombinationDao {
    int addCom(CombinationEntity combinationEntity);

    CombinationEntity findComById(Integer id);

    List<CombinationEntity> findPage(Integer pageNum, Integer pageSize, @Param("combName") String combName,@Param("userId") Integer userId,@Param("recipeList") List<String> recipeList,@Param("state") String state);

    int findPageTotal(@Param("combName") String combName,@Param("userId") Integer userId);

    int updateComInfo(CombinationEntity combinationEntity);

    int deleteComById(Integer id);
}
