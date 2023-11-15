package cn.edu.bistu.quickssmdemo.controller;

import cn.edu.bistu.quickssmdemo.common.Result;
import cn.edu.bistu.quickssmdemo.entity.BookEntity;
import cn.edu.bistu.quickssmdemo.entity.CombinationEntity;
import cn.edu.bistu.quickssmdemo.service.ICombinationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/comb")
public class CombinationController {

    @Resource
    private ICombinationService combinationService;

    @RequestMapping("combManagePage")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(defaultValue = "") String combName,@RequestParam(defaultValue = "") Integer userId,@RequestParam(defaultValue = "") String recipe){
        pageNum=(pageNum-1)*pageSize;
        List<String> recipeS=new ArrayList();
        String[] newStr = recipe.split("\\s+");
        for (int i = 0; i < newStr.length; i++) {
            recipeS.add(newStr[i]);
        }
        String stateS=null;
        if(recipe!=""){
            stateS="ok";
        }
        List<CombinationEntity> data=combinationService.findPage(pageNum, pageSize, combName,userId,recipeS,stateS);
        Integer total=combinationService.findPageTotal(combName,userId);

        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return Result.success(res);
    }

    @RequestMapping("addOrUpdateCombInfo")
    public Result addUpdateInfo(@RequestBody CombinationEntity combinationEntity){
        if(combinationEntity.getId()!=null){
            combinationService.updateComInfo(combinationEntity);
        }else{
            combinationService.addCom(combinationEntity);
        }
        return Result.success(combinationEntity);
    }


    @RequestMapping("/getComb/{id}")
    public Result getBook(@PathVariable Integer id){
        CombinationEntity combinationEntity=combinationService.findComById(id);
        return Result.success(combinationEntity);
    }

    @RequestMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        combinationService.deleteComb(id);
        return Result.success();
    }
}
