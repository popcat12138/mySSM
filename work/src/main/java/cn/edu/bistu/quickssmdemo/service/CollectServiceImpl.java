package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.dao.ICollectDao;
import cn.edu.bistu.quickssmdemo.dao.IUserDao;
import cn.edu.bistu.quickssmdemo.entity.CollectEntity;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements ICollectService{
    @Autowired
    ICollectDao collectDao;


    @Override
    public int addCollect(CollectEntity collectEntity) {
        if(collectDao.enableCollect(collectEntity)!=null){
            return 404;
        }
        return collectDao.addCollect(collectEntity);
    }

    @Override
    public int deleteCollect(CollectEntity collectEntity) {
        return collectDao.deleteCollect(collectEntity);
    }
}
