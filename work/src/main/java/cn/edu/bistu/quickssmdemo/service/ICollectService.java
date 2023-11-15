package cn.edu.bistu.quickssmdemo.service;

import cn.edu.bistu.quickssmdemo.entity.CollectEntity;

public interface ICollectService {
    int addCollect(CollectEntity collectEntity);
    int deleteCollect(CollectEntity collectEntity);
}
