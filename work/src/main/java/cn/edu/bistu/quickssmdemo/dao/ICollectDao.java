package cn.edu.bistu.quickssmdemo.dao;

import cn.edu.bistu.quickssmdemo.entity.CollectEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICollectDao {
    int deleteCollect(CollectEntity collectEntity);

    int addCollect(CollectEntity collectEntity);

    CollectEntity enableCollect(CollectEntity collectEntity);
}
