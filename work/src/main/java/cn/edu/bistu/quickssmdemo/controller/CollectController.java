package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.CollectEntity;
import cn.edu.bistu.quickssmdemo.service.ICollectService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/collect")
public class CollectController {

    @Resource
    private ICollectService collectService;

    @RequestMapping("add")
    public Result add(@RequestBody CollectEntity collectEntity){
        Map<String, Object> result = new HashMap<>(2);
        int y=collectService.addCollect(collectEntity);
        System.out.println(y);
        result.put("result",y);
        return Result.success(result);
    }
    @RequestMapping("delete")
    public Result delete(@RequestBody CollectEntity collectEntity){
        //System.out.println(collectEntity.getCollectId()+collectEntity.getType()+collectEntity.getUserId());
            collectService.deleteCollect(collectEntity);
            return Result.success("add");

    }

}
